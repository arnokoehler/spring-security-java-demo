package nl.arnokoehler.io.digital.springsecuritydemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChuckNorrisService {

  private final ChuckNorrisRepository chuckNorrisRepository;

   public List<Joke> getAllJokesS() {
    return chuckNorrisRepository.findAll();
  }

  public Joke getJoke(Long id) {
    return chuckNorrisRepository.findJokeById(id);
  }

  public Joke getRandomJoke() {
    return chuckNorrisRepository.getRandomJoke();
  }

  public Joke updateJoke(Long id, Joke joke) {
    Joke jokeById = chuckNorrisRepository.findJokeById(id);
    if (jokeById != null) {
      joke.setId(id);
      return chuckNorrisRepository.save(joke);
    }
    return null;
  }
}
