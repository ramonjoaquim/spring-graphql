package com.pokemon.pokedex.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pokemon.pokedex.model.Region;
import com.pokemon.pokedex.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService implements GraphQLQueryResolver {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Optional<Region> getRegionById(Integer id) {
        return regionRepository.findById(id);
    }

    public List<Region> getRegionByName(String name) {
        return regionRepository.findByName(name);
    }
}
