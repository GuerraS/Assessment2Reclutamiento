package com.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_supliers;
    private String name;
    private String fecha;
    private char status;
}