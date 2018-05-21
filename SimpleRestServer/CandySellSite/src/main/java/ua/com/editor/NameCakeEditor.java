package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.CakeValue;
import ua.com.entity.NameCake;
import ua.com.service.CakeValueService;
import ua.com.service.NameCakeService;

public class NameCakeEditor extends PropertyEditorSupport{
	
	
	private final NameCakeService nameCakeService;

	public NameCakeEditor(NameCakeService nameCakeService){
		this.nameCakeService = nameCakeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		NameCake nameCake = nameCakeService.findOne(Integer.parseInt(text));
		setValue(nameCake);
	}
}
