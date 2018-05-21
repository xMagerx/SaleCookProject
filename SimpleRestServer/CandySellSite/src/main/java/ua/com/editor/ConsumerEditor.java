package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.Consumer;
import ua.com.service.ConsumerService;

public class ConsumerEditor extends PropertyEditorSupport{
	
private final ConsumerService consumerService;
	
	public  ConsumerEditor(ConsumerService consumersService) {
		this.consumerService = consumersService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Consumer consumer = consumerService.findOne(Integer.parseInt(text));
		setValue(consumer);
	}

}
