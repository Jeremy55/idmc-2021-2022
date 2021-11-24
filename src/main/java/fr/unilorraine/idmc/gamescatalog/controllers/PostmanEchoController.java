package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {

    private final PostmanEchoClient client;

    @GetMapping("get")
    public String testGet() {
        return client.testGet();
    }
}
