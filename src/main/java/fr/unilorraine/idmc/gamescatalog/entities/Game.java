package fr.unilorraine.idmc.gamescatalog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Long price;
    private int rating;
    private String category;

//    https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime
    private Instant releaseDate;

//    https://vladmihalcea.com/manytoone-jpa-hibernate/
    @Nullable
    @ManyToOne
//    why the _ (underscore) https://dev.to/aleksey/hibernate-naming-strategies-jpa-specification-vs-spring-boot-opinionation-m1c
//    https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto.data-access.configure-hibernate-naming-strategy
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

}
