package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepository;
	
	@GetMapping
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepository.findAll();	
		return leads;
	}
	
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		leadRepository.save(lead);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneLeadById(@PathVariable long id) {
		leadRepository.deleteById(id);
	}
	
	@PutMapping()
	public void updateOneLead(@RequestBody LeadDto leadDto) {
		Lead lead = new Lead();
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadRepository.save(lead);
	}
	
	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable long id) {
		Optional<Lead> findById = leadRepository.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
