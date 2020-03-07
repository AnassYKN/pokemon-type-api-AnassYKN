package TP;

import TP.repository.TranslationRepository;
import TP.repository.repositoryImpl.TranslationRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class TranslationRepositoryImplTest {
    private TranslationRepositoryImpl repository = new TranslationRepositoryImpl();

    @Test
    void getPokemonName_with1_inFrench_shouldReturnBulbizarre(){
        var name = repository.getPokemonName(1, Locale.FRENCH);
        assertEquals("Bulbizarre", name);
    }

    @Test
    void getPokemonName_with1_inEnglish_shouldReturnBulbizarre(){
        var name = repository.getPokemonName(1, Locale.ENGLISH);
        assertEquals("Bulbasaur", name);
    }

    @Test
    void applicationContext_shouldLoadPokemonRepository(){

        //TODO
        var context = new AnnotationConfigApplicationContext("TP.repository.repositoryImpl");
        var repoByName = context.getBean("TranslationRepositoryImpl");
        var repoByClass = context.getBean(TranslationRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }
}
