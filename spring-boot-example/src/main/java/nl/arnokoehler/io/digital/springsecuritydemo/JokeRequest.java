package nl.arnokoehler.io.digital.springsecuritydemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JokeRequest {

  private String joke;

  private String category;

  private String reference;

  private String lang;

}
