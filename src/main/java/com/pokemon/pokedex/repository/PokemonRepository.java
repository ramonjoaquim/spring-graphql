package com.pokemon.pokedex.repository;

import com.pokemon.pokedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findByName(String name);
    List<Pokemon> findByTrainers_Id(Integer id);
}
