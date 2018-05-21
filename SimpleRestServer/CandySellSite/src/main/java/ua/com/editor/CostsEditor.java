package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.CakeValue;
import ua.com.entity.Costs;
import ua.com.service.CostsService;

public class CostsEditor extends PropertyEditorSupport{
	
	
	public final CostsService costsService;

	public CostsEditor(CostsService costsService) {
		this.costsService = costsService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Costs costs = costsService.findOne(Integer.parseInt(text));
		setValue(costs);
	}
	

}
