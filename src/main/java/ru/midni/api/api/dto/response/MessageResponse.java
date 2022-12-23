package ru.midni.api.api.dto.response;

public class MessageResponse {

  private final String message;

  public MessageResponse(String message) {
    this.message = message;
  }

  @SuppressWarnings("unused")
  public String getMessage() {
    return this.message;
  }
}
