package projectApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectApp.dao.partnersRepository;
import projectApp.entities.Employee;
import projectApp.entities.business_partners;

@Controller
@RequestMapping("/partners")
public class PartnersController {
	
	@Autowired
	partnersRepository partRepo;
	
	@GetMapping
	public String ShowPartners(Model model) {
		List<business_partners> partners = partRepo.findAll();
		model.addAttribute("partners", partners);
		
		return "partners/partnersList";
	}
	
	@GetMapping("/new")
	public String CreatePartners(Model model) {
		business_partners Abusiness_partners = new business_partners();
		
		model.addAttribute("partner", Abusiness_partners);
		
		return "partners/CreateBusinessPartner";
	}
	
	@PostMapping("/save")
	public String savePartner(Model model, business_partners partner) {
		//salvare angajat in baza de date
		partRepo.save(partner);
		
		return "redirect:/partners";
		
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("id") long partnId ,Model model) {
		
		business_partners bp = partRepo.findByPartnerId(partnId);
		
		model.addAttribute("partner", bp);
		
		return "partners/CreateBusinessPartner";
		
	}
	
	@GetMapping("/delete")
	public String deletePartner(@RequestParam("id") long partnId ,Model model) {
		
		business_partners bp = partRepo.findByPartnerId(partnId);
		
		partRepo.delete(bp);
		
		return "redirect:/partners";
		
	}
	

}
