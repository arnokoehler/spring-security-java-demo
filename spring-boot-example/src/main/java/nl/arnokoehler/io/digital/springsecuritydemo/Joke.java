package nl.arnokoehler.io.digital.springsecuritydemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "JOKES")
public class Joke {

  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String joke;

  private String category;

  private String reference;

  private String lang;


}
