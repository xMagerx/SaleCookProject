package ua.com.request;

public class SearchingCakestorageRequest {
	private String ingridient;
	
	private String amount;
	
	
	public SearchingCakestorageRequest() {

	}


	public SearchingCakestorageRequest(String ingridient, String amount) {
		super();
		this.ingridient = ingridient;
		this.amount = amount;
	}


	public String getIngridient() {
		return ingridient;
	}


	public void setIngridient(String ingridient) {
		this.ingridient = ingridient;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
}
