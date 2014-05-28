package com.datasol.entra.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datasol.entra.controller.validator.RegisterValidator;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.ServiceException;
import com.datasol.entra.service.UserService;

@Controller
public class RegisterController {
	
	private static final Logger log = Logger.getLogger(RegisterController.class);
	
	@InitBinder("registerValidator")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegisterValidator());
	}
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register(Model model){
		User user = new User();
		if(!model.containsAttribute("user")){
			model.addAttribute("user",user);	
		}	
		return "register";
	}
	@RequestMapping(value="/registerDo",method = RequestMethod.POST)
	public String registerDo(WebRequest request ,Model model,@Valid @ModelAttribute("user") User user,
			BindingResult result,RedirectAttributes attr ){
		log.debug("starting registery for user " + user.getFirstName());
		RegisterValidator validator = new RegisterValidator();
		validator.validate(user, result);
		model.addAttribute("user",user);
		if(result.hasErrors()){
			//not valid form lets redirect to the page
			model.addAttribute("errors", result.getAllErrors());
			 attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			 attr.addFlashAttribute("user", user);
			return "redirect:register";
		}else{
			log.debug("form passed validation");			
			try {
				userService.registerUser(user);
				return "redirect:registry/registryEmailValidation";
			} catch (ServiceException e) {
				model.addAttribute("errors", "{entra.service.layer.erros}");
				return "redirect:register";
			}
		}
		
	}

}
