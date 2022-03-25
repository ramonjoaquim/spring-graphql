package com.pokemon.pokedex.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pokemon.pokedex.model.Gym;
import com.pokemon.pokedex.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymService implements GraphQLQueryResolver {

    private final GymRepository gymRepository;

    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Optional<Gym> getGymById(Integer id) {
        return gymRepository.findById(id);
    }
}
