package jbr.webshop.common.exception;

public class BaseException extends Exception {

  private static final long serialVersionUID = 1L;

  public BaseException() {
    super();
  }

  public BaseException(String message) {
    super(message);
  }

  public BaseException(Throwable throwable) {
    super(throwable);
  }

  public BaseException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
