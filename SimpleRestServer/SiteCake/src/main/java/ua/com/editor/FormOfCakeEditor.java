package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.FormOfCake;
import ua.com.service.FormOfCakeService;



public class FormOfCakeEditor extends PropertyEditorSupport{
	private final FormOfCakeService formOfCakeService;

	public FormOfCakeEditor(FormOfCakeService formOfCakeService){
		this.formOfCakeService = formOfCakeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		FormOfCake formOfCake = formOfCakeService.findOne(Integer.parseInt(text));
		setValue(formOfCake);
	}
}
