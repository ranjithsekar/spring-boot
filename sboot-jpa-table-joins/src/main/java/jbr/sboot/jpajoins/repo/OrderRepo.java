package jbr.sboot.jpajoins.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jbr.sboot.jpajoins.model.OrderModel;

public interface OrderRepo extends JpaRepository<OrderModel, Long> {

}
