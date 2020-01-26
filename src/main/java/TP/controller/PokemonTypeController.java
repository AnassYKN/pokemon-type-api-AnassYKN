package TP.controller;

import TP.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import TP.service.PokemonTypeService;

import java.util.List;

@RestController
@RequestMapping(value = "/pokemon-types")
public class PokemonTypeController {

    private PokemonTypeService service;

    @Autowired
    public PokemonTypeController(PokemonTypeService service) {
        this.service=service;
    }

    @GetMapping("/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable("id") int id){
        return this.service.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.service.getAllPokemonTypes();
    }
}
