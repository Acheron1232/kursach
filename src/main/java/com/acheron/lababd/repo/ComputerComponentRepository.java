package com.acheron.lababd.repo;

import com.acheron.lababd.entity.Computer;
import com.acheron.lababd.entity.ComputerComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerComponentRepository extends JpaRepository<ComputerComponent, Long> {

}
