package projectApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projectApp.dao.UserAccountRepository;
import projectApp.entities.UserAccount;

@Controller
public class SecurityController {
	
	@Autowired
	UserAccountRepository accountRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		//creare obiect userACcount
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		//redirectionare catre pagina de inregistrare
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveNewAccount(Model model, UserAccount user) {
		//criptare parola
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		//salvare utilizator in baza de date
		accountRepo.save(user);
		return "redirect:/";
	}
	
	
    }

