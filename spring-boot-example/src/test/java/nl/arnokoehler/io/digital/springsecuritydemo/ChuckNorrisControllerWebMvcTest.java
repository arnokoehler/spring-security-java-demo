package nl.arnokoehler.io.digital.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(ChuckNorrisController.class)
class ChuckNorrisControllerWebMvcTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ChuckNorrisService service;

  @MockBean
  private JokeMapper jokeMapper;

  @Test
  @WithAnonymousUser
  public void test() throws Exception {
    Joke chuckNorris = Joke.builder().id(1L).joke("Chuck Norris can divide by zero.").category("Chuck Norris").build();
    when(service.getRandomJoke()).thenReturn(chuckNorris);
    when(jokeMapper.map(any(Joke.class))).thenAnswer(invocation -> {
      Joke joke = invocation.getArgument(0);
      return new JokeResponse(joke.getId(), joke.getJoke());
    });

    mvc.perform(get("/jokes"))
        .andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }
}