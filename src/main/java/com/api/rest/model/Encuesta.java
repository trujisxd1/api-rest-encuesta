package com.api.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Encuesta_Id")
    private Integer id;

    @Column(name = "pregunta")
    private  String pregunta;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Encuesta_Id")
    @OrderBy

   private Set<Opcion> opciones;


}
