package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.Delivery;
import ua.com.entity.Recipes;
import ua.com.service.DeliveryService;
import ua.com.service.RecipesService;

@Controller
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;
	
	@RequestMapping(value="/delivery",method = RequestMethod.GET)
	public String saveValue(Model model){
		model.addAttribute("delivery", new Delivery());
		return "delivery";
	}

	@RequestMapping(value="/delivery/save",method = RequestMethod.POST)
	public String save(@ModelAttribute Delivery delivery) throws Exception{
		deliveryService.save(delivery);
		return "redirect:/delivery";
	}
}
