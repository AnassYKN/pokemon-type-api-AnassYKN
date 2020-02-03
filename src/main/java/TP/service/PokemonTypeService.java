package TP.service;

import TP.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    List<PokemonType> getAllPokemonTypes();
    PokemonType getPokemonType(String name);
    List<PokemonType> getPokemonByTypes(List<String> types);
}
