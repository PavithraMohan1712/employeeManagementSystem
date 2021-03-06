package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.IEmployeeRepository;
import com.demo.entities.Employee;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		repository.deleteById(id);
		return true;
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee employee = repository.findById(emp.getUserId());
		employee.setEmail(emp.getEmail());
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repository.findAll();
	}

	@Override
	public Employee getEmployeeById(int userid) {
		// TODO Auto-generated method stub
		return repository.findById(userid);
	}

	@Override
	public List<Employee> getAllEmployeesByPagination(int maxPage, int ofset) {
		Pageable paging = PageRequest.of(maxPage-1, ofset);
		Page<Employee> pageresult = repository.findAll(paging);
		
		return pageresult.toList();
		//return null;
	}

	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		List<Employee> al= repository.findAll();
		return al.size();
	}
	

}
