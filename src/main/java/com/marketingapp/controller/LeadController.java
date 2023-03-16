package com.marketingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@RequestMapping("/create") // @WebServlet()
	public String viewCreateLeadForm() {
		return "create_lead"; // acts as RequestDispatcher()
	}

	/*   USING ModelAtribute():
	@RequestMapping("/saveReg")
	public String saveOneLead(@ModelAttribute Lead lead, ModelMap model) {
		
		model.addAttribute("message", "Lead is saved!");
		
		leadService.saveReg(lead);
		
		return "create_lead";
	}
	*/

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
	 */
	
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

}
