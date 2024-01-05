package nl.iodigital.iodigital.hakhaton.securitydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnicornController {

  private List<Unicorn> unicorns;

  {
    unicorns = List.of(
      new Unicorn(1, "Twilight Sparkle", "purple", 8, "purple"),
      new Unicorn(3, "Rainbow Dash", "blue", 10, "rainbow"),
      new Unicorn(4, "Pinkie Pie", "pink", 9, "pink"),
      new Unicorn(7, "Applejack", "orange", 11, "blonde"),
      new Unicorn(8, "Fluttershy", "yellow", 8, "pink"),
      new Unicorn(9, "Rarity", "white", 12, "purple")
    );
  }

  @GetMapping("/unicorns")
  public List<Unicorn> getUnicorns() {
    return unicorns;
  }

  @GetMapping("/unicorns/{id}")
  public Unicorn getUnicorn(@PathVariable Integer id) {
    return unicorns.stream()
      .filter(unicorn -> unicorn.id().equals(id))
      .findFirst()
      .orElseThrow();
  }

}
