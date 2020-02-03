package TP.repository.repositoryImpl;

import TP.bo.PokemonType;
import TP.repository.PokemonTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            InputStream pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json");

            ObjectMapper objectMapper = new ObjectMapper();
            PokemonType[] pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        PokemonType bo = new PokemonType();
        for (PokemonType pokemon : pokemons) {
            if (pokemon.getId() == id) {
                bo = pokemon;
                System.out.println(pokemon.getName());
            }
        }
        return bo;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        PokemonType bo = new PokemonType();
        for (PokemonType pokemon : pokemons) {
            if (pokemon.getName().equals(name)) {
                bo = pokemon;
                System.out.println(pokemon.getName());
            }
        }
        return bo;
    }

    @Override
    public List<PokemonType> findPokemonByType(List<String> types) {
        return pokemons.stream().filter(p ->
                !Collections.disjoint(p.getTypes(), types)).
                collect(Collectors.toList());
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }
}
