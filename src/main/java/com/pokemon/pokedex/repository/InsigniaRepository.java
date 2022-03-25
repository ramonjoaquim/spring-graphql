package com.pokemon.pokedex.repository;

import com.pokemon.pokedex.model.Insignia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, Integer> {
}
