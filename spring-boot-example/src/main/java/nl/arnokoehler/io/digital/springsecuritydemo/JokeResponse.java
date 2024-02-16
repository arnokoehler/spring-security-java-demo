package nl.arnokoehler.io.digital.springsecuritydemo;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JokeResponse {

  @Id private Long id;

  private String joke;
}
