package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IComplianceRepository;
import com.demo.entities.Compliance;
import com.demo.entities.StatusReport;

@Service
public class IComplianceServiceImpl implements  IComplianceService{
	@Autowired
	private  IComplianceRepository repository;

	@Override
	public Compliance createRL(Compliance co) {
		return repository.save(co);
		
	}

	@Override
	public List<Compliance> getAllRl() {
		return (List<Compliance>) repository.findAll();
	}

	@Override
	public Compliance getAllRlById(int compid) {
		return repository.findById(compid).get();
	}

	@Override
	public StatusReport createStatusReport(StatusReport statusreport) {
		return repository.save(statusreport);
	}

	@Override
	public List<StatusReport> getAllStatusReport(int userid) {
		return repository.getByUserId(userid);
		//return null;
	}
	
	

}
