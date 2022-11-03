package ru.midni.api.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResultHolder<T> {

  private boolean success;
  private String message;
  private T data;

  public ApiResultHolder() {
    this.success = true;
  }

  public static <T> ApiResultHolder<T> success() {
    ApiResultHolder<T> ApiResultHolder = new ApiResultHolder<>();
    ApiResultHolder.setSuccess(Boolean.TRUE);

    return ApiResultHolder;
  }

  public static <T> ApiResultHolder<T> success(T data) {
    if (Objects.isNull(data)) return error("Отсутствует тело ответа");

    ApiResultHolder<T> ApiResultHolder = new ApiResultHolder<>();
    ApiResultHolder.setSuccess(Boolean.TRUE);
    ApiResultHolder.setData(data);

    return ApiResultHolder;
  }

  public static <T> ApiResultHolder<T> error(String message) {
    ApiResultHolder<T> ApiResultHolder = new ApiResultHolder<>();
    ApiResultHolder.setSuccess(Boolean.FALSE);
    ApiResultHolder.setMessage(message);

    return ApiResultHolder;
  }

  public static <T> ApiResultHolder<T> error(String message, T data) {
    ApiResultHolder<T> ApiResultHolder = new ApiResultHolder<>();
    ApiResultHolder.setSuccess(Boolean.FALSE);
    ApiResultHolder.setMessage(message);
    ApiResultHolder.setData(data);

    return ApiResultHolder;
  }
}
