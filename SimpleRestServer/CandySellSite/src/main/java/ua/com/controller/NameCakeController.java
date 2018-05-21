package ua.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.editor.CakeValueEditor;
import ua.com.editor.ConsumerEditor;
import ua.com.editor.FormOfCakeEditor;
import ua.com.entity.CakeValue;
import ua.com.entity.Consumer;
import ua.com.entity.FormOfCake;
import ua.com.entity.NameCake;
import ua.com.entity.Person;
import ua.com.request.DeleteNameCakeRequest;
import ua.com.request.DeletePersonRequest;
import ua.com.request.LoginRequest;
import ua.com.request.MyPageRequest;
import ua.com.request.SearchingRequest;
import ua.com.response.PersonResponse;
import ua.com.service.CakeValueService;
import ua.com.service.FormOfCakeService;
import ua.com.service.NameCakeService;

@CrossOrigin
@RestController
@RequestMapping("/namecake")
public class NameCakeController {
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
	
	
//	@PutMapping
//	public void save(NameCake nameCake) {
//		nameCakeService.save(nameCake);		
//	}
	
	@PutMapping
	public NameCake register(@RequestBody NameCake nameCake) throws IOException{
		return nameCakeService.save(nameCake);
	}
	

	@GetMapping
	public List<NameCake> namecakes(){
		return nameCakeService.findAll();
	}
	
	
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteNameCakeRequest request){
		return nameCakeService.delete(request.getId());
	}
}
