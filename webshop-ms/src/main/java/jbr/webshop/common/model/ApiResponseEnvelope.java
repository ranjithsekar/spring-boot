package jbr.webshop.common.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class ApiResponseEnvelope implements Serializable {
  private static final long serialVersionUID = 1L;

  private int code;
  private ApiResponseEntity payload;
  private String error;

  public ApiResponseEnvelope() {
    super();
  }

  public ApiResponseEnvelope(int code) {
    super();
    this.code = code;
  }

  public ApiResponseEnvelope(int code, ApiResponseEntity payload) {
    super();
    this.code = code;
    this.payload = payload;
  }

  public ApiResponseEnvelope(int code, ApiResponseEntity payload, String errorMsg) {
    super();
    this.code = code;
    this.payload = payload;
    this.error = errorMsg;
  }

  public ApiResponseEnvelope(int code, String errorMsg) {
    super();
    this.code = code;
    this.error = errorMsg;
  }

  public String getUid() {
    return UUID.randomUUID()
        .toString();
  }

}
