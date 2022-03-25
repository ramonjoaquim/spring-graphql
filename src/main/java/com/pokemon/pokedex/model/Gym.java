package com.pokemon.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "gym")
public class Gym implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_region")
    private Region region;

    @OneToOne(mappedBy = "gym", fetch = FetchType.LAZY)
    private Trainer trainer;

    @OneToOne(mappedBy = "gym", fetch = FetchType.LAZY)
    private Insignia insignia;
}
