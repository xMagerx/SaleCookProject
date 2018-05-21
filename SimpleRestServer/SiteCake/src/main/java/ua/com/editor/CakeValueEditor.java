package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.CakeValue;
import ua.com.service.CakeValueService;

public class CakeValueEditor extends PropertyEditorSupport{
	
private final CakeValueService cakeValueService;

public CakeValueEditor(CakeValueService cakeValueService){
	this.cakeValueService = cakeValueService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	CakeValue cakeValue = cakeValueService.findOne(Integer.parseInt(text));
	setValue(cakeValue);
}
	
}
