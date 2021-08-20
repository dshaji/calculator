package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.GoodsDTO;
import com.sample.dto.OrderDTO;
import com.sample.model.Order;
import com.sample.repository.OrderRepository;


@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	private static final Double apple = 0.60;
	private static final Double orange = 0.25;

	public OrderDTO getOrderSummary(GoodsDTO goodsDTO) {
		Order order = new Order();
		OrderDTO orderDTO = new OrderDTO();
		order.setAppleCost(goodsDTO.getAppleCount() * apple);
		order.setOrangeCost(goodsDTO.getOrangeCount() * orange);
		order.setTotal(order.getAppleCost() + order.getOrangeCost());
		orderDTO.setAppleCount(order.getAppleCost());
		orderDTO.setOrangeCount(order.getOrangeCost());
		orderDTO.setTotal(order.getTotal());
		orderRepository.save(order);
		orderDTO.setOrderId(order.getOrderId());
		return orderDTO;
	}

	public List<OrderDTO> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		if (!orders.isEmpty()) {
			orderList = orders.stream().map(this::orderEntitytoDTO).collect(Collectors.toList());
		}
		return orderList;
	}

	public OrderDTO getOrderById(Integer id) {
		Order order = orderRepository.getById(id);
		OrderDTO orderDTO = orderEntitytoDTO(order);
		return orderDTO;
	}

	public OrderDTO getOffer(GoodsDTO goodsDTO) {
		OrderDTO orderDTO = new OrderDTO();
		Integer appleCount= (goodsDTO.getAppleCount() % 2 + goodsDTO.getAppleCount() / 2) ;
		Double appleCost=appleCount*apple;
		Integer orangeCount = (goodsDTO.getOrangeCount() / 3) * 2 + (goodsDTO.getOrangeCount() % 3) ;
		Double orangeCost = orangeCount*orange;
		orderDTO.setAppleCount(appleCost);
		orderDTO.setOrangeCount(orangeCost);
		Double total = appleCost + orangeCost;
		orderDTO.setTotal(total);
		Order order = new Order();
		order.setAppleCost(appleCost);
		order.setOrangeCost(orangeCost);
		order.setTotal(total);
		orderRepository.save(order);
		orderDTO.setOrderId(order.getOrderId());
		return orderDTO;
	}

	public OrderDTO orderEntitytoDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setAppleCount(order.getAppleCost());
		orderDTO.setOrangeCount(order.getOrangeCost());
		orderDTO.setTotal(order.getTotal());
		return orderDTO;
	}

}
