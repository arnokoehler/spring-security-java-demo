package nl.arnokoehler.io.digital.springsecuritydemo;

public class JokeNotFoundException extends RuntimeException {

  public JokeNotFoundException() {
  }

  public JokeNotFoundException(Long id) {
    super("Could not find joke " + id);
  }
}
