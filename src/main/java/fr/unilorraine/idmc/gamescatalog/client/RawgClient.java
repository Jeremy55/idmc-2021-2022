package fr.unilorraine.idmc.gamescatalog.client;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "rawg", url="${app.rawg.url}")
public interface RawgClient {
    @RequestMapping(method = RequestMethod.GET,value="/games?key={key}")
    String getGames(@PathVariable(value="key") String key);
    @RequestMapping(method = RequestMethod.GET, value = "/games/{id}?key={key}")
    String getGame(@PathVariable(value="id") String id,@PathVariable(value = "key") String key);
}
