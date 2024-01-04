package com.acheron.lababd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "computer_configuration_components")
public class ComputerConfigurationComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuration_component_id")
    private Long configurationComponentId;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")
    private Computer computer;

    @Column(name = "component_name", nullable = false)
    private String componentName;

    // Getters and setters
}
