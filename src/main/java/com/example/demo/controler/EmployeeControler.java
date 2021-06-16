package com.example.demo.controler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeSearchDto;
import com.example.demo.entity.Employee;
import com.example.demo.excel.EmployeeExcelExporter;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeControler {
	@Autowired
	EmployeeService service;

	@GetMapping("")
	public List<Employee> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return service.addNewEmployee(employee);
	}

	@PutMapping("")
	public Employee editEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@GetMapping("/search")
	public List<Employee> search(@RequestBody EmployeeSearchDto dto) {
		return service.search(dto);
	}

	@GetMapping("/export")
	public void exportFileExcell(HttpServletResponse response) throws IOException{
		response.setContentType("application/octet-stream"); // xac dinh kieu nhi phan tuy y
		// https://stackoverflow.com/questions/20508788/do-i-need-content-type-application-octet-stream-for-file-download
		DateFormat date = new SimpleDateFormat("yyyy_MM_dd_mm_HH");
		String currentDate = date.format(new Date()).toString();

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=employee_" + currentDate + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<Employee> list = service.getAll();
		EmployeeExcelExporter export = new EmployeeExcelExporter(list);
		export.export(response);
	}

}
