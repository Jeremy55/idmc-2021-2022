package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Pas une simple API mais une API rest sinon on peut utiliser @controller.
@RequestMapping("games") // Pas besoin de mettre un / c'est automatique.
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public Iterable<Game> findAll(){
        return gamesService.findAll();
    }

}
