package com.demo.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.entities.Compliance;
import com.demo.entities.StatusReport;
import com.demo.entities.Users;
import com.demo.service.IComplianceService;

@RestController
@RequestMapping("/compliance")
public class IComplianceController {
	@Autowired
	IComplianceService service;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Compliance> createRL(@Valid @RequestBody Compliance co) {
    	Compliance comp = service.createRL(co);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{com_id}")
				.buildAndExpand(comp.getComplianceId())
				.toUri();
		return ResponseEntity.created(location).body(comp);
	}
    
    @GetMapping
	public List<Compliance> getAllRl(){
		return service.getAllRl();
	}
    @GetMapping("/{compid}")
	public ResponseEntity<Compliance> getAllRlById(@PathVariable int compid){
    	if(service.getAllRlById(compid)==null) {
    		throw new EntityNotFoundException("compliance Id not found");
    	}else {
    		return new ResponseEntity(service.getAllRlById(compid),HttpStatus.OK);
    	}
		
	}
    @PostMapping("/status")
    @ResponseStatus(HttpStatus.CREATED)
	public void createStatusReport(@RequestBody StatusReport statusreport) {
		service.createStatusReport(statusreport);
		
	}
    @GetMapping("/statusReport/{userid}")
	public List<StatusReport> getAllStatusReport(@PathVariable int userid){
		return service.getAllStatusReport(userid);
		
	}

}
