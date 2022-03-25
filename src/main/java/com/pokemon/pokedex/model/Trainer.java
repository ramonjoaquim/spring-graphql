package com.pokemon.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "trainer", uniqueConstraints = { @UniqueConstraint(columnNames = "gym_id")})
public class Trainer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id", referencedColumnName = "id")
    private Gym gym;

    @ManyToMany
    @JoinTable(
            name = "pokemon_trainers",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id"))
    private Set<Pokemon> pokemons;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<Insignia> insignias;
}
