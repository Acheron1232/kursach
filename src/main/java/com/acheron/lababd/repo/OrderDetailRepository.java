package com.acheron.lababd.repo;

import com.acheron.lababd.entity.Order;
import com.acheron.lababd.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Optional<OrderDetail> findByOrder(Order order);
}
