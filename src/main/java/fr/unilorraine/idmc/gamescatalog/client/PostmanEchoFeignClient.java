package fr.unilorraine.idmc.gamescatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "postman-echo", url = "https://postman-echo.com/")
public interface PostmanEchoFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    String testGet();
}
