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
@Table(name = "computer_components")
public class ComputerComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "component_name", nullable = false)
    private String componentName;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")
    private Computer computer;

    // Getters and setters
}

