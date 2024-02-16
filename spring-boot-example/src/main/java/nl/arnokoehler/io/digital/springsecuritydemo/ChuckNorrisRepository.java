package nl.arnokoehler.io.digital.springsecuritydemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChuckNorrisRepository extends JpaRepository<Joke, Long>{

  Optional<Joke> findJokeById(Long id);

  Optional<Joke> findJokeByJoke(String joke);

  Optional<Joke> findJokeByCategory(String category);

  @Query(value = "SELECT * FROM jokes ORDER BY RAND() LIMIT 1", nativeQuery = true)
  Optional<Joke> getRandomJoke();
}
