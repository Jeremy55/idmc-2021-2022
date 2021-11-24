package fr.unilorraine.idmc.gamescatalog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
//    why instant https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime
// how to use it https://stackoverflow.com/a/45674593/1107450
public class NewGame {

    private String name;
    private Long price;
    private int rating;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Instant releaseDate;

    private Long publisherId;

}
