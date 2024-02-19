package nl.arnokoehler.io.digital.springsecuritydemo;

import org.springframework.stereotype.Service;

@Service
public class JokeMapper {

  public JokeResponse map(Joke joke) {
    return JokeResponse.builder()
      .id(joke.getId())
      .joke(joke.getJoke())
      .category(joke.getCategory())
      .reference(joke.getReference())
      .lang(joke.getLang())
      .build();
  }

  public Joke map(JokeRequest jokeRequest) {
    return Joke.builder()
      .joke(jokeRequest.getJoke())
      .category(jokeRequest.getCategory())
      .reference(jokeRequest.getReference())
      .lang(jokeRequest.getLang())
      .build();
  }
}
