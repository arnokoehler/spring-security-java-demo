package nl.arnokoehler.io.digital.springsecuritydemo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class ChuckNorrisController {

  private final ChuckNorrisService chuckNorrisService;

  private final JokeMapper jokeMapper;

  @GetMapping("/jokes")
  public List<JokeResponse> getAllJokes() {
    return chuckNorrisService.getAllJokesS().stream().map(jokeMapper::map).collect(Collectors.toList());
  }

  @GetMapping("/random/joke")
  public JokeResponse getRandomJoke() {
    Joke randomJoke = chuckNorrisService.getRandomJoke();
    return jokeMapper.map(randomJoke);
  }

  @GetMapping("/jokes/{id}")
  public JokeResponse getJokeById(@PathVariable("id") Long id) {
    Joke joke = chuckNorrisService.getJoke(id);
    return jokeMapper.map(joke);
  }

  @PutMapping("/jokes/{id}")
  public void updateJoke(@PathVariable("id") Long id, @RequestBody JokeRequest jokeRequest) {
    chuckNorrisService.updateJoke(id, jokeMapper.map(jokeRequest));
  }

}
