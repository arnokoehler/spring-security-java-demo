package nl.arnokoehler.io.digital.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ChuckNorrisRepositoryDataTest {

  @Autowired ChuckNorrisRepository chuckNorrisRepository;

  @Test
  public void test() {
    Joke joke = new Joke();
    joke.setJoke("Chuck Norris can divide by zero.");
    joke.setCategory("nerdy");
    chuckNorrisRepository.save(joke);
    Joke foundJoke = chuckNorrisRepository.findJokeByJoke("Chuck Norris can divide by zero.").get();
    assertEquals(joke, foundJoke);
  }

  @Test
  public void testFindById() {
    Joke joke = new Joke();
    joke.setJoke("Chuck Norris can divide by zero.");
    joke.setCategory("nerdy");
    Joke save = chuckNorrisRepository.save(joke);
    Joke foundJoke = chuckNorrisRepository.findJokeById(save.getId()).get();
    assertEquals(save, foundJoke);
  }

}