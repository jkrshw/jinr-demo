package cern.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class HelloController {

  @ResponseBody
  @GetMapping(value = "/echo/{message}", produces = "application/json")
  public Map respond(@PathVariable String message,
      @RequestParam(required = false, defaultValue = "false") boolean echo ) {
    String response = message;
    if (echo) {
      response += ".." + message;
    }
    return Collections.singletonMap("message", response);
  }

  @GetMapping(value = "/echo/{message}", produces = "text/html")
  public String echo(Model model, @PathVariable String message,
      @RequestParam(required = false, defaultValue = "false") boolean echo) {
    model.addAllAttributes(respond(message, echo));
    return "hello";
  }

  @GetMapping("/echo")
  public String echoPl() {
    return "hello-with-pl";
  }

}
