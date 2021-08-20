package com.sample.dto;

public class OrderDTO {

	private Integer orderId;
	private Double appleCount;
	private Double orangeCount;
	private Double total;

	public OrderDTO(int i, double d, double e, double f) {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public Double getAppleCount() {
		return appleCount;
	}

	public void setAppleCount(Double appleCount) {
		this.appleCount = appleCount;
	}

	public Double getOrangeCount() {
		return orangeCount;
	}

	public void setOrangeCount(Double orangeCount) {
		this.orangeCount = orangeCount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
