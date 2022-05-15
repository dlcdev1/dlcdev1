package entities.enums;

public enum OrderStatus {
	
	PENDING_PAYMENT(0),
	PROCESSING(1),
	SHIPPED(2),
	DELIVERED(3);

	int order;
	
	private OrderStatus(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
	
	
	
}
