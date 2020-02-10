package TP.repository;

import java.util.Locale;

public interface TranslationRepository {

    String getPokemonName(int id, Locale locale);
}
