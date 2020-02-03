package TP.service.serviceImpl;

import TP.bo.PokemonType;
import TP.repository.PokemonTypeRepository;
import org.springframework.stereotype.Service;
import TP.service.PokemonTypeService;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {


    private PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository=pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public PokemonType getPokemonType(String name) {
        return null;
    }

    @Override
    public List<PokemonType> getPokemonByTypes(List<String> types) {
        return null;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return this.pokemonTypeRepository;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }
}
