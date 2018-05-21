package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.CakeValue;
import ua.com.entity.Cakestorage;
import ua.com.service.CakeValueService;
import ua.com.service.CakestorageService;

public class CakestorageEditor extends PropertyEditorSupport{
	
private final CakestorageService cakestorageService;

public CakestorageEditor(CakestorageService cakestorageService){
	this.cakestorageService = cakestorageService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	Cakestorage cakestorage = cakestorageService.findOne(Integer.parseInt(text));
	setValue(cakestorage);
}

}
