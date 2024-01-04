package com.acheron.lababd.repo;

import com.acheron.lababd.entity.Computer;
import com.acheron.lababd.entity.Order;
import com.acheron.lababd.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
