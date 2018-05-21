package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.editor.CakeValueEditor;
import ua.com.editor.FormOfCakeEditor;
import ua.com.entity.CakeValue;
import ua.com.entity.FormOfCake;
import ua.com.entity.NameCake;
import ua.com.service.CakeValueService;
import ua.com.service.FormOfCakeService;
import ua.com.service.NameCakeService;

@Controller
public class CakeController {
	
	@Autowired
	private NameCakeService nameCakeService;
	
	@Autowired
	private FormOfCakeService formOfCakeService;
	
	@Autowired
	private CakeValueService cakeValueService;
	
	@InitBinder("namecake")
	
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(FormOfCake.class, new FormOfCakeEditor(formOfCakeService));
		binder.registerCustomEditor(CakeValue.class, new CakeValueEditor(cakeValueService));
	}

	
	@RequestMapping(value ="/namecake", method = RequestMethod.GET)
	public String showcake(Model model) {
		model.addAttribute("namecake", new NameCake());
		model.addAttribute("forms", formOfCakeService.findAll());
		model.addAttribute("values", cakeValueService.findAll());
		return "namecake";
	}
	@RequestMapping(value ="/person", method = RequestMethod.POST)
	public String saveCake(@ModelAttribute NameCake namecake) throws Exception {
		nameCakeService.save(namecake);
		return "redirect:/namecake";
	}
}
