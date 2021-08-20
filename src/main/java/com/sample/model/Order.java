package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_list")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private Double appleCost;
	private Double orangeCost;
	private Double total;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getAppleCost() {
		return appleCost;
	}

	public void setAppleCost(Double appleCount) {
		this.appleCost = appleCount;
	}

	public Double getOrangeCost() {
		return orangeCost;
	}

	public void setOrangeCost(Double orangeCount) {
		this.orangeCost = orangeCount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
