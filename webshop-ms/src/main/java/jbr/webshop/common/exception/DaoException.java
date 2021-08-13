package jbr.webshop.common.exception;

public class DaoException extends Exception {

  private static final long serialVersionUID = 1L;

  public DaoException() {
    super();
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(Throwable throwable) {
    super(throwable);
  }

  public DaoException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
