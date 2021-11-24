package fr.unilorraine.idmc.gamescatalog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.postman")
@Getter
@Setter
public class PostmanProperties {

    @Value("${app.postman.echo-url}")
    private String echoUrl;

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;

}
