package nl.arnokoehler.io.digital.springsecuritydemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChuckNorrisRepository extends JpaRepository<Joke, Long>{

  Joke findJokeById(Long id);

  Joke findJokeByJoke(String joke);

  Joke findJokeByCategory(String category);

  @Query(value = "SELECT * FROM jokes ORDER BY RAND() LIMIT 1", nativeQuery = true)
  Joke getRandomJoke();
}
