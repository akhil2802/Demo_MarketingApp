package com.marketingapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;
import com.marketingapp.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveReg(Lead lead) {
		
		leadRepo.save(lead);
	}

}
