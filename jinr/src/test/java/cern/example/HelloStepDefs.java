package cern.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@SpringBootTest
@ContextConfiguration(classes = ExampleApplication.class)
public class HelloStepDefs implements En {

  /* Instance vars for holding state between steps */
  private String message;
  private Map result;

  @Autowired
  public HelloStepDefs(HelloController helloController) {
    Given("^a message$", () -> {
      message = "hello";
    });

    When("^the message is sent without repeat$", () -> {
      result = helloController.respond(message, false);
    });

    Then("^the same message is returned$", () -> {
      assertThat(result.get("message"), is(message));
    });

    When("^the message is sent with repeat$", () -> {
      result = helloController.respond(message, true);
    });

    Then("^the message is returned twice$", () -> {
      assertThat(result.get("message"), is(message + ".." + message));
    });

  }

}
