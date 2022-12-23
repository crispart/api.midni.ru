package ru.midni.api.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.midni.api.api.dto.response.MessageResponse;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class MessageController {

  @GetMapping(value = "/public")
  public MessageResponse publicEndpoint() {
    return new MessageResponse("All good. You DO NOT need to be authenticated to call /api/public.");
  }

  @GetMapping(value = "/private")
  public MessageResponse privateEndpoint() {
    return new MessageResponse("All good. You can see this because you are Authenticated.");
  }

  @GetMapping(value = "/private-scoped")
  public MessageResponse privateScopedEndpoint() {
    return new MessageResponse("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
  }
}
