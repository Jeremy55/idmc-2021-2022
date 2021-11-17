package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository repository;

    public Iterable<Game> findAll() {
        return repository.findAll();
    }

    public Game create(Game gg) {
        return repository.save(gg);
    }
}
