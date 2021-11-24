package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoJDK11Client;
import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {

    private final PostmanEchoJDK11Client client;
    private final PostmanEchoFeignClient feignClient;

    @GetMapping("get")
    public String testGet() {
        return client.testGet();
    }

    @GetMapping("get/feign")
    public String testGetFeign() {
        return feignClient.testGet();
    }
}
