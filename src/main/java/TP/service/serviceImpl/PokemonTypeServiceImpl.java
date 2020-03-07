package TP.service.serviceImpl;

import TP.bo.PokemonType;
import TP.repository.PokemonTypeRepository;
import TP.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import TP.service.PokemonTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    private PokemonTypeRepository pokemonTypeRepository;
    @Autowired
    private TranslationRepository translationRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository=pokemonTypeRepository;
    }

    public PokemonTypeServiceImpl() {}

    @Override
    public PokemonType getPokemonType(int id) {

        PokemonType pt =this.pokemonTypeRepository.findPokemonTypeById(id);
        if (translationRepository != null) {
            pt.setName(translationRepository.getPokemonName(pt.getId(), LocaleContextHolder.getLocale()));
        }
        return pt;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {
        List<PokemonType> listPt = this.pokemonTypeRepository.findAllPokemonType();
        List<PokemonType> listPtTrans = new ArrayList<>();
        for (PokemonType pokemon : listPt) {
                listPtTrans.add(this.getPokemonType(pokemon.getId()));
            }

        return listPtTrans;
    }

    @Override
    public PokemonType getPokemonType(String name) {
        PokemonType pt =this.pokemonTypeRepository.findPokemonTypeByName(name);
        if (translationRepository != null) {
            pt.setName(translationRepository.getPokemonName(pt.getId(), LocaleContextHolder.getLocale()));
        }
        return pt;
    }

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
