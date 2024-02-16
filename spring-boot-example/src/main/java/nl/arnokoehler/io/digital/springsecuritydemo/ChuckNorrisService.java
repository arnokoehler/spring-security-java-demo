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
    return chuckNorrisRepository.findJokeById(id).orElseThrow(() -> new JokeNotFoundException(id));
  }

  public Joke getRandomJoke() {
    return chuckNorrisRepository.getRandomJoke().orElseThrow(JokeNotFoundException::new);
  }

  public Joke updateValues(Long id, Joke newJoke) {
    Joke jokeById = chuckNorrisRepository.findJokeById(id).orElseThrow(JokeNotFoundException::new);
    return chuckNorrisRepository.save(updateValues(newJoke, jokeById));
  }

  private static Joke updateValues(Joke updatedJoke, Joke original) {
    return Joke.builder()
        .id(original.getId())
        .joke(updatedJoke.getJoke() != null ? updatedJoke.getJoke() : original.getJoke())
        .category(updatedJoke.getCategory() != null ? updatedJoke.getCategory() : original.getCategory())
        .reference(updatedJoke.getReference() != null ? updatedJoke.getReference() : original.getReference())
        .lang(updatedJoke.getLang() != null ? updatedJoke.getLang() : original.getLang())
        .build();
  }
}
