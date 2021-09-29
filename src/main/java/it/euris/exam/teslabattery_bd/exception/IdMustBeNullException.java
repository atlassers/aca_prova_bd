package it.euris.exam.teslabattery_bd.exception;

/**
 * Exception for managing the case "Id Must Not Be Null"
 * 
 * <p>
 * Extends {@code RuntimeException}
 * </p>
 * 
 * @author Dario Gualtieri
 * @since 2021-08-20
 *
 */
public class IdMustBeNullException extends RuntimeException {
  private static final long serialVersionUID = 11547588023389561L;

  public IdMustBeNullException() {
    super("Id must be null. You sent a dto with an id already present");
  }
  public IdMustBeNullException(String message) {
    super(message);
  }

}
