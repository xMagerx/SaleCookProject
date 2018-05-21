package ua.com.request;

public class SearchingCostRequest {
	private String timeproduction;
	
	private int complexityPay;

	public SearchingCostRequest(){}
	
	public SearchingCostRequest(String timeproduction, int complexityPay) {
		super();
		this.timeproduction = timeproduction;
		this.complexityPay = complexityPay;
	}

	public String getTimeproduction() {
		return timeproduction;
	}

	public void setTimeproduction(String timeproduction) {
		this.timeproduction = timeproduction;
	}

	public int getComplexityPay() {
		return complexityPay;
	}

	public void setComplexityPay(int complexityPay) {
		this.complexityPay = complexityPay;
	}

	@Override
	public String toString() {
		return "SearchingCostRequest [timeproduction=" + timeproduction + ", complexityPay=" + complexityPay + "]";
	}
	
}
