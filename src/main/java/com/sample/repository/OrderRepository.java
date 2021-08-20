package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
