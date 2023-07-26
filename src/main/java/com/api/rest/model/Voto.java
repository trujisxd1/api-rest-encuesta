package com.api.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue
    @Column(name = "Voto_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Opcion_id")
    private  Opcion opcion;
}
