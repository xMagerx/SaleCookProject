package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.Person;
import ua.com.service.PersonService;

public class PersonEditor extends PropertyEditorSupport {
	
private final PersonService personService;
	
	public  PersonEditor(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Person person= personService.findOne(Integer.parseInt(text));
		setValue(person);
	}

}
