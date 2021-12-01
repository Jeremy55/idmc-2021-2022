package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.RawgClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rawg")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PartnersController {

    private final RawgClient rawgClient;

    @Value("${app.rawg.key}")
    private String apiKey;

    @GetMapping()
    public String home() {
        return rawgClient.getGames(apiKey);
    }

    @GetMapping("/games/{id}")
    public String game(@PathVariable("id") String gameId) {
        return rawgClient.getGame(gameId,apiKey);
    }
}
