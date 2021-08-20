package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.GoodsDTO;
import com.sample.dto.OrderDTO;
import com.sample.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/getOrder")
	public ResponseEntity<OrderDTO> getOrder(@RequestBody GoodsDTO goodsDTO) {
		OrderDTO orderDTO = orderService.getOrderSummary(goodsDTO);
		if(orderDTO!=null)
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getAllOrders")
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<OrderDTO> orderList = orderService.getAllOrders();
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	@PostMapping(value = "/getOrderById")
	public ResponseEntity<OrderDTO> getOrderById(@RequestParam Integer id) {
		OrderDTO orderDTO = orderService.getOrderById(id);
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/offer")
	public ResponseEntity<OrderDTO> getOfferOrder(@RequestBody GoodsDTO goodsDTO) {
		OrderDTO orderDTO = orderService.getOffer(goodsDTO);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}

}
