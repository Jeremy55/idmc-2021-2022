package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import fr.unilorraine.idmc.gamescatalog.services.PublishersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("publishers")
@RequiredArgsConstructor
public class PublishersController {

    private final PublishersService service;

    @GetMapping
    public Iterable<Publisher> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Publisher create(@RequestBody Publisher p) {
        return service.create(p);
    }
}
