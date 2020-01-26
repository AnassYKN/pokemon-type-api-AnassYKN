import TP.bo.PokemonType;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import TP.repository.PokemonTypeRepository;
import TP.repository.repositoryImpl.PokemonTypeRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonRepositoryImplTest {

    private PokemonTypeRepositoryImpl repository = new PokemonTypeRepositoryImpl();

    @Test
    void findPokemonTypeById_with25_shouldReturnPikachu(){
        PokemonType pikachu = repository.findPokemonTypeById(25);
        assertNotNull(pikachu);
        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());
    }

    @Test
    void findPokemonTypeById_with145_shouldReturnZapdos(){
        PokemonType zapdos = repository.findPokemonTypeById(145);
        assertNotNull(zapdos);
        assertEquals("zapdos", zapdos.getName());
        assertEquals(145, zapdos.getId());
    }

    @Test
    void findPokemonTypeByName_withEevee_shouldReturnEevee(){
        PokemonType eevee = repository.findPokemonTypeByName("eevee");
        assertNotNull(eevee);
        assertEquals("eevee", eevee.getName());
        assertEquals(133, eevee.getId());
    }

    @Test
    void findPokemonTypeByName_withMewTwo_shouldReturnMewTwo(){
        PokemonType mewtwo = repository.findPokemonTypeByName("mewtwo");
        assertNotNull(mewtwo);
        assertEquals("mewtwo", mewtwo.getName());
        assertEquals(150, mewtwo.getId());
    }

    @Test
    void findAllPokemonType_shouldReturn151Pokemons(){
        List<PokemonType> pokemons = repository.findAllPokemonType();
        assertNotNull(pokemons);
        assertEquals(151, pokemons.size());
    }

    @Test
    void applicationContext_shouldLoadPokemonRepository(){

        var context = new AnnotationConfigApplicationContext("TP/repository");
        var repoByName = context.getBean("pokemonTypeRepositoryImpl");
        var repoByClass = context.getBean(PokemonTypeRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }
}
