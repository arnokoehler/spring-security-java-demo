package nl.arnokoehler.io.digital.springsecuritydemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Joke {

  @Id private Long id;

  private String joke;

  private String category;

  private String reference;

  private String lang;


}
