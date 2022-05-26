package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product; //TODO Composição
		
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("ORDER SUMMAY\n");
//		sb.append("\nOrder moment: " + moment);
//		sb.append("\nOrder status: " + order_status);
//		sb.append("\nClient: " + client);
//		sb.append("\nOrder items");
//		
//		for (OrderItem order_item : order_items) {
//			sb.append(order_item.getProducts());
//			sb.append(order_item.getPrice());
//			sb.append(order_item.getQuantity());
//			sb.append(order_item.subTotal());
//		}
		
		
		return getProduct().getName() 
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity" 
				+ quantity 
				+", Subtotal: $"
				+ String.format("%.2f", subTotal()); 
	}
	

}
