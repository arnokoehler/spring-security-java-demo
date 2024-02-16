package nl.arnokoehler.io.digital.springsecuritydemo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class ChuckNorrisController {

  private final ChuckNorrisService chuckNorrisService;

  private final JokeMapper jokeMapper;

  @GetMapping("/jokes/")
  public List<JokeResponse> getAllJokes() {
    return chuckNorrisService.getAllJokesS().stream().map(jokeMapper::map).collect(Collectors.toList());
  }

  @GetMapping("/jokes/random")
  public JokeResponse getRandomJoke() {
    return jokeMapper.map(chuckNorrisService.getRandomJoke());
  }

  @GetMapping("/jokes/{id}")
  public JokeResponse getJokeById(@PathVariable("id") Long id) {
    return jokeMapper.map(chuckNorrisService.getJoke(id));
  }

  @PutMapping("/jokes/{id}")
  public void updateJoke(@PathVariable("id") Long id, @RequestBody JokeRequest jokeRequest) {
    chuckNorrisService.updateJoke(id, jokeMapper.map(jokeRequest));
  }

}
