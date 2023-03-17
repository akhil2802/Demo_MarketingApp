package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.util.email.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/create") // @WebServlet()
	public String viewCreateLeadForm() {
		return "create_lead"; // acts as RequestDispatcher()
	}

	//   USING ModelAtribute():
	@RequestMapping("/saveReg")
	public String saveOneLead(@ModelAttribute Lead lead, Model model) {
		
		model.addAttribute("message", "Lead is saved!");
		
		leadService.saveReg(lead);
		
		emailService.sendEmail(lead.getEmail(), "Lead Saved", "New lead has been saved!");
		
		return "create_lead";
	}
	

	/*    USING RequestParam():
	 * @RequestMapping("/saveReg") public String
	 * saveOneLead(@RequestParam("firstName") String
	 * firstName, @RequestParam("lastName") String lastName,
	 * 
	 * @RequestParam("email") String email, @RequestParam("mobile") Long mobile, ModelMap model) {
	 * 
	 * Lead lead = new Lead(); lead.setFirstName(firstName);
	 * lead.setLastName(lastName); lead.setEmail(email); lead.setMobile(mobile);
	 * model.addAttribute("message", "Lead is saved!");         // similar to request.setAttribute();
	 * leadService.saveReg(lead);
	 * 
	 * return "create_lead"; }
	 
	
	@RequestMapping("/saveReg")
	public String saveOneLead(LeadDto leadDto, ModelMap model) {
		
		Lead lead = new Lead();
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		
		model.addAttribute("message", "Lead is saved!");
		
		leadService.saveReg(lead);
		
		return "create_lead";
	}
	*/
	
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		
	    List<Lead> leads = leadService.findAllLeads();
	    model.addAttribute("leads", leads);
	    
	    return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long leadId, Model model) { 
		
		leadService.deleteLeadById(leadId);
		
	    List<Lead> leads = leadService.findAllLeads();
	    model.addAttribute("leads", leads);
	    
	    return "list_leads";
	}
	
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long leadId, Model model) { 
		
		Lead lead = leadService.findLeadById(leadId);
		
		model.addAttribute("lead", lead);
	    
	    return "update_lead";
	}
	
	@RequestMapping("/editReg")
	public String editReg(LeadDto leadDto , Model model) { 
		
		Lead lead = new Lead();
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		
		leadService.saveReg(lead);
		
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
	    
	    return "list_leads";
	}
	
	

}
