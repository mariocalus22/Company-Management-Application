package projectApp.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FunctionalityErrorController implements ErrorController{
	
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.FORBIDDEN.value()) {
				return "unaccesible/unaccesibleFunctionality";
			}
		}
		
		return "unaccesible/error";
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
