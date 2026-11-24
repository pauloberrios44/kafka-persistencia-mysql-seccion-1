package com.pcfactory.ventas.cyber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false)
    private Long valor;
}
