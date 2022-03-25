package com.pokemon.pokedex.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pokemon.pokedex.model.Pokemon;
import com.pokemon.pokedex.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService implements GraphQLQueryResolver {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public List<Pokemon> getPokemonByName(String name) {
        return pokemonRepository.findByName(name);
    }

    public Optional<Pokemon> getPokemonById(Integer id) {
        return pokemonRepository.findById(id);
    }

    public List<Pokemon> getPokemonByTrainerId(Integer id) {
        return pokemonRepository.findByTrainers_Id(id);
    }
}
