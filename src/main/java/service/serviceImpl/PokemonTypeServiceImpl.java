package service.serviceImpl;

import bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PokemonTypeRepository;
import service.PokemonTypeService;

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

    public PokemonTypeRepository getPokemonTypeRepository() {
        return this.pokemonTypeRepository;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }
}
