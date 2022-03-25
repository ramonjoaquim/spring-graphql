package com.pokemon.pokedex.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pokemon.pokedex.model.Insignia;
import com.pokemon.pokedex.repository.InsigniaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsigniaService implements GraphQLQueryResolver {

    private final InsigniaRepository insigniaRepository;

    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }

    public List<Insignia> getAllInsignias() {
        return insigniaRepository.findAll();
    }

    public Optional<Insignia> getInsigniaById(Integer id) {
        return insigniaRepository.findById(id);
    }
}
