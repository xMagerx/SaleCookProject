package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.CakeValue;
import ua.com.entity.FormOfCake;
import ua.com.service.CakeValueService;
import ua.com.service.FormOfCakeService;

@Controller
public class AtributeController {
	
	@Autowired
	private CakeValueService cakeValueService;
 
	@Autowired
	private FormOfCakeService formOfCakeService;
	
	@RequestMapping(value="/cake",method = RequestMethod.GET)
	public String saveValue(Model model){
		model.addAttribute("cakeValue", new CakeValue());
		model.addAttribute("formOfCake", new FormOfCake());
		return "cake";
	}
	
	@RequestMapping(value="/attribute/save",method = RequestMethod.POST)
	public String save(@ModelAttribute CakeValue cakeValue,FormOfCake formOfCake) throws Exception{
		cakeValueService.save(cakeValue);
		formOfCakeService.save(formOfCake);
		return "redirect:/cake";
	}
	
}
