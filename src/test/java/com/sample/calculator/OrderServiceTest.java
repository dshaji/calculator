package com.sample.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.dto.GoodsDTO;
import com.sample.dto.OrderDTO;
import com.sample.service.OrderService;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	private OrderService orderservice;

	@Test
	public void getOrdersTest() {
		List<OrderDTO> orderDTO = orderservice.getAllOrders();
		assertThat(orderDTO != null);
		assertThat(orderDTO.size()>0);

	}

	@Test
	public void getOrderByIdTest() {
		OrderDTO orderDTO = orderservice.getOrderById(1);
		assertThat(orderDTO != null);
		assertThat(orderDTO.getOrderId().equals(1));
	}

	@Test
	public void getOrderSummaryTest() {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setAppleCount(2);
		goodsDTO.setOrangeCount(4);
		OrderDTO orderDTO= orderservice.getOrderSummary(goodsDTO);
		assertThat(orderDTO!=null);
		assertThat(orderDTO.getTotal().equals(2.2));
	}
	
	@Test
	public void getOffer() {
		GoodsDTO goodsDTO=new GoodsDTO();
		goodsDTO.setAppleCount(4);
		goodsDTO.setOrangeCount(6);
		OrderDTO orderDTO=orderservice.getOffer(goodsDTO);
		assertThat(orderDTO!=null);
		assertThat(orderDTO.getTotal().equals(1.6));
	}
}
