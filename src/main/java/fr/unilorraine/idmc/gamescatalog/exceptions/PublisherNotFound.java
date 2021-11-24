package fr.unilorraine.idmc.gamescatalog.exceptions;

import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@ToString
@RequiredArgsConstructor
public class PublisherNotFound extends RuntimeException {

    private final Long id;

    public static PublisherNotFound of(NewGame gg) {
        return new PublisherNotFound(gg.getPublisherId());
    }
}
