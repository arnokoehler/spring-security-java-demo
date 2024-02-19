package nl.arnokoehler.io.digital.springsecuritydemo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JokeResponse {

  private Long id;

  private String joke;
}
