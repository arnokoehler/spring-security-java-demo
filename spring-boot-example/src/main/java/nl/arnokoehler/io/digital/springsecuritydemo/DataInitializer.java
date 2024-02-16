package nl.arnokoehler.io.digital.springsecuritydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

  private final ChuckNorrisRepository chuckNorrisRepository;

  public DataInitializer(ChuckNorrisRepository chuckNorrisRepository) {
    this.chuckNorrisRepository = chuckNorrisRepository;
  }

  @Override
  public void run(String... args) {
    // Perform data initialization or manipulation here
    Joke joke = new Joke();
    joke.setJoke("Chuck Norris can divide by zero.");
    joke.setCategory("nerdy");
    chuckNorrisRepository.save(joke);
  }
}
