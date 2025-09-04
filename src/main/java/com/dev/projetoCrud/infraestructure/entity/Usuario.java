package com.dev.projetoCrud.infraestructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
@Entity

public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @Column(name = "email", unique = true)
    private String email;

   @Column(name = "nome")
    private String nome;


}
