package TP;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import TP.repository.PokemonTypeRepository;
import TP.repository.repositoryImpl.PokemonTypeRepositoryImpl;
import TP.service.PokemonTypeService;
import TP.service.serviceImpl.PokemonTypeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PokemonTypeServiceImplTest {
    @Test
    void pokemonTypeRepository_shouldBeCalled_whenFindById(){
        var pokemonTypeRepository = mock(PokemonTypeRepository.class);
        var pokemonTypeService = new PokemonTypeServiceImpl(pokemonTypeRepository);

        pokemonTypeService.getPokemonType(25);

        verify(pokemonTypeRepository).findPokemonTypeById(25);
    }

    @Test
    void pokemonTypeRepository_shouldBeCalled_whenFindAll(){
        var pokemonTypeRepository = mock(PokemonTypeRepository.class);
        var pokemonTypeService = new PokemonTypeServiceImpl(pokemonTypeRepository);

        pokemonTypeService.getAllPokemonTypes();

        verify(pokemonTypeRepository).findAllPokemonType();
    }
    @Test
    void applicationContext_shouldLoadPokemonTypeService(){
        var context = new AnnotationConfigApplicationContext(PokemonTypeServiceImpl.class, PokemonTypeRepositoryImpl.class);
        var serviceByName = context.getBean("pokemonTypeServiceImpl");
        var serviceByClass = context.getBean(PokemonTypeService.class);

        assertEquals(serviceByName, serviceByClass);
        assertNotNull(serviceByName);
        assertNotNull(serviceByClass);
    }
    @Test
    void pokemonTypeRepository_shouldBeAutowired_withSpring(){
        var context = new AnnotationConfigApplicationContext(PokemonTypeServiceImpl.class, PokemonTypeRepositoryImpl.class);
        var service = context.getBean(PokemonTypeServiceImpl.class);
        assertNotNull(service.getPokemonTypeRepository());
    }
}
