package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.Delivery;
import ua.com.service.DeliveryService;

public class DeliveryEditor extends PropertyEditorSupport{
	
	public final DeliveryService deliveryService;

	public DeliveryEditor(DeliveryService deliveryService) {
		super();
		this.deliveryService = deliveryService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Delivery delivery = deliveryService.findOne(Integer.parseInt(text));
		setValue(delivery);
	}

}
