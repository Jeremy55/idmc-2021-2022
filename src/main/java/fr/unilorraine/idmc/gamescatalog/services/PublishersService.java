package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublisherRepository repo;

    public Publisher create(Publisher p) {
        return repo.save(p);
    }

    public Iterable<Publisher> findAll() {
        return repo.findAll();
    }
}
