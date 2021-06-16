package com.example.demo.dto;

public class EmployeeSearchDto {
	private String fieldSearch;
	private String value;
	public String getFieldSearch() {
		return fieldSearch;
	}
	public void setFieldSearch(String fieldSearch) {
		this.fieldSearch = fieldSearch;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public EmployeeSearchDto(String fieldSearch, String value) {
		super();
		this.fieldSearch = fieldSearch;
		this.value = value;
	}
	
	
}
