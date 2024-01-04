package com.acheron.lababd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computerId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "configuration", nullable = false)
    private String configuration;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "computer",cascade = CascadeType.ALL)
    private List<ComputerComponent> computerComponent;
    @OneToMany(mappedBy = "computer",cascade = CascadeType.ALL)
    private List<ComputerConfigurationComponent> computerConfigurationComponents;


    // Getters and setters
}
