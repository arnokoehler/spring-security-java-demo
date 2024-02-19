package nl.arnokoehler.io.digital.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChuckNorrisControllerMvcTest {

  @Autowired
  private MockMvc mvc;

  @Test
  @WithMockUser(username = "user", roles = "USER")
  public void test_jokes_withMockUser() throws Exception {
    mvc.perform(get("/jokes"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"id\":1,\"joke\":\"Chuck Norris can divide by zero.\"}]"));
  }

  @Test
  @WithAnonymousUser
  public void test_jokes_withAnonymousUser() throws Exception {
    mvc.perform(get("/jokes")
            .with(anonymous()))
        .andExpect(status().isForbidden());
  }

  @Test
  @WithAnonymousUser
  public void test_random_joke_withAnonymousUser() throws Exception {
    mvc.perform(get("/random/joke")
            .with(anonymous()))
        .andExpect(status().isOk());
  }

}