package com.pokemon.pokedex.service;

import com.pokemon.pokedex.enums.Category;
import com.pokemon.pokedex.model.*;
import com.pokemon.pokedex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class DataLoader {

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private InsigniaRepository insigniaRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @PostConstruct
    public void loadData() {
        generateDataAsh();
        generateDataMisty();
        generateDataBrock();
    }

    public void generateDataAsh() {
        Region region = Region.builder()
                .name("Kanto")
                .build();
        Region regionSaved = regionRepository.save(region);

        Gym gym = Gym.builder()
                .name("Pewter")
                .region(regionSaved)
                .build();
        Gym gymSaved = gymRepository.save(gym);

        Insignia insignia = Insignia.builder()
                .name("Rock Insignia")
                .gym(gymSaved)
                .build();
        Insignia insigniaSaved = insigniaRepository.save(insignia);

        Pokemon pokemon = Pokemon.builder()
                .name("Pikachu")
                .category(Category.ELETRIC)
                .build();
        Pokemon pokemonSaved = pokemonRepository.save(pokemon);

        Trainer trainer = Trainer.builder()
                .name("Ash Ketchum")
                .age(10)
                .gym(gymSaved)
                .pokemons(Collections.singleton(pokemonSaved))
                .insignias(Collections.singletonList(insigniaSaved))
                .build();
        trainerRepository.save(trainer);
    }

    public void generateDataMisty() {
        Gym gym = Gym.builder()
                .name("Cerulean")
                .region(regionRepository.getById(1))
                .build();
        Gym gymSaved = gymRepository.save(gym);

        Insignia insignia = Insignia.builder()
                .name("Waterfall Insignia")
                .gym(gymSaved)
                .build();
        Insignia insigniaSaved = insigniaRepository.save(insignia);

        Pokemon pokemon = Pokemon.builder()
                .name("Staryu")
                .category(Category.WATER)
                .build();
        Pokemon pokemonSaved = pokemonRepository.save(pokemon);

        Trainer trainer = Trainer.builder()
                .name("Misty")
                .age(10)
                .gym(gymSaved)
                .pokemons(Collections.singleton(pokemonSaved))
                .insignias(Collections.singletonList(insigniaSaved))
                .build();
        trainerRepository.save(trainer);
    }

    public void generateDataBrock() {
        Pokemon pokemon = Pokemon.builder()
                .name("Geodude ")
                .category(Category.ROCK)
                .build();
        Pokemon pokemonSaved = pokemonRepository.save(pokemon);

        Trainer trainer = Trainer.builder()
                .name("Brock")
                .age(15)
                .pokemons(Collections.singleton(pokemonSaved))
                .build();
        trainerRepository.save(trainer);
    }

}
