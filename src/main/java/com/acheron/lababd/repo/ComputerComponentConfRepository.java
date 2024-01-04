package com.acheron.lababd.repo;

import com.acheron.lababd.entity.ComputerComponent;
import com.acheron.lababd.entity.ComputerConfigurationComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerComponentConfRepository extends JpaRepository<ComputerConfigurationComponent, Long> {

}
