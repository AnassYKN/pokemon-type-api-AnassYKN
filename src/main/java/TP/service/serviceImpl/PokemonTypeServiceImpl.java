package TP.service.serviceImpl;

import TP.bo.PokemonType;
import TP.repository.PokemonTypeRepository;
import TP.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TP.service.PokemonTypeService;

import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    private PokemonTypeRepository pokemonTypeRepository;
    private TranslationRepository translationRepository;
    Locale local = Locale.FRENCH;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository=pokemonTypeRepository;
    }

    public PokemonTypeServiceImpl() {}

    @Override
    public PokemonType getPokemonType(int id) {

        PokemonType pt =this.pokemonTypeRepository.findPokemonTypeById(id);
        if (translationRepository != null) {
            String pokemonName = translationRepository.getPokemonName(id, local);
            if (pokemonName != null) pt.setName(pokemonName);
        }
        return pt;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {
        List<PokemonType> listPt= this.pokemonTypeRepository.findAllPokemonType();
        for (PokemonType pokemon : listPt) {
                String pokemonName = translationRepository.getPokemonName(pokemon.getId(), local);
                if (pokemonName != null) pokemon.setName(pokemonName);
            }

        return listPt;
    }

    @Override
    public PokemonType getPokemonType(String name) { return this.pokemonTypeRepository.findPokemonTypeByName(name); }

    @Override
    public List<PokemonType> getPokemonByTypes(List<String> types) { return this.pokemonTypeRepository.findPokemonByType(types); }

    @Override
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return this.pokemonTypeRepository;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }
}
