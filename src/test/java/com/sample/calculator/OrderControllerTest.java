package com.sample.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sample.controller.OrderController;
import com.sample.dto.GoodsDTO;
import com.sample.dto.OrderDTO;
import com.sample.service.OrderService;

@SpringBootTest
public class OrderControllerTest {

	@InjectMocks
	private OrderController orderController;
	
	@Mock
    OrderService orderService;
	
	@Test
	public void getAllOrdersTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        OrderDTO orderDTO=new OrderDTO(1,3.0,4.0,7.0);
        List<OrderDTO> orderDTOs= Arrays.asList(orderDTO);
        when(orderService.getAllOrders()).thenReturn(orderDTOs);
		ResponseEntity<List<OrderDTO>> testObject= orderController.getAllOrders();
		assertThat(testObject.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(testObject.getBody()).isNotEmpty();
		
	}
	
	@Test
	public void getOrderById() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        OrderDTO orderDTO=new OrderDTO(2,3.0,4.0,7.0);
        when(orderService.getOrderById(2)).thenReturn(orderDTO);
		ResponseEntity<OrderDTO> testObject= orderController.getOrderById(2);
		assertThat(testObject.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(testObject.getBody()).isNotNull();
		
	}
	
	@Test
	public void getOrderSummary (){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		GoodsDTO goodsDTO =new GoodsDTO();
		goodsDTO.setAppleCount(3);
		goodsDTO.setOrangeCount(6);
		OrderDTO orderDTO=new OrderDTO(2,3.0,4.0,7.0);
        when(orderService.getOrderSummary(goodsDTO)).thenReturn(orderDTO);
		ResponseEntity<OrderDTO> testObject= orderController.getOrder(goodsDTO);
		assertThat(testObject.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(testObject.getBody()).isNotNull();
		
	}
	
	@Test
	public void getOffer() {
		GoodsDTO goodsDTO =new GoodsDTO();
		goodsDTO.setAppleCount(3);
		goodsDTO.setOrangeCount(6);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		OrderDTO orderDTO=new OrderDTO(2,3.0,4.0,7.0);
        when(orderService.getOffer(goodsDTO)).thenReturn(orderDTO);
		ResponseEntity<OrderDTO> testObject= orderController.getOfferOrder(goodsDTO);
		assertThat(testObject.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(testObject.getBody()).isNotNull();
		
	}
}
