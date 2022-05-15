package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date date;
	private OrderStatus order_status;
	private List<OrderItem> order_items = new ArrayList<>();
	private List<Client> client = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date date, OrderStatus order_status) {
		this.date = date;
		this.order_status = order_status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderStatus getOrder_status() {
		return order_status;
	}

	public void setOrder_status(OrderStatus order_status) {
		this.order_status = order_status;
	}

	public List<OrderItem> getOrder_item() {
		return order_items;
	}

	public List<Client> getClient() {
		return client;
	}
	
	public void addItem(OrderItem order_item) {
		order_items.add(order_item);
	}
	
	public void removeItem(OrderItem order_item) {
		order_items.remove(order_item);
	}
	
	
	public String toString() {
		StringBuilder stb = new StringBuilder();
		return "";
	}
	
	
	
	

}	
