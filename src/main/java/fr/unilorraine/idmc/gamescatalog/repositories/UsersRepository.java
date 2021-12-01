package fr.unilorraine.idmc.gamescatalog.repositories;

import fr.unilorraine.idmc.gamescatalog.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUsername(String username);

}