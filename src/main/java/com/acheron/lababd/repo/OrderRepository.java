package com.acheron.lababd.repo;

import com.acheron.lababd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Можна додати додаткові методи, які потрібні для роботи з сутністю Order
}
