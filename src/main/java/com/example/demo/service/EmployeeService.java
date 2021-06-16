package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeSearchDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;
	@Autowired
	EntityManager em;
	
	public List<Employee> getAll(){
		return repo.findAll();
	}
	
	public Employee getById(int id) {
		return repo.findById(id).get();
	}
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public Employee addNewEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}
	public List<Employee> search(EmployeeSearchDto searchDto){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cQuery = cb.createQuery(Employee.class);
		Root<Employee> root = cQuery.from(Employee.class);
		Predicate predicate =cb.equal(root.get(searchDto.getFieldSearch()),  searchDto.getValue());
		cQuery.select(root).where(predicate);
		return em.createQuery(cQuery).getResultList();
	}
}
