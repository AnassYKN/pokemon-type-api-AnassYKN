package service;

import bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    List<PokemonType> getAllPokemonTypes();
}
