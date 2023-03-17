package com.marketingapp.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Lead> findAllLeads() {
		
		List<Lead> leads = this.leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long leadId) {
		this.leadRepo.deleteById(leadId);
		
	}

	@Override
	public Lead findLeadById(long leadId) {
		
		Optional<Lead> findById = this.leadRepo.findById(leadId);
		
		Lead lead = findById.get();
		
		return lead;
	}

}
