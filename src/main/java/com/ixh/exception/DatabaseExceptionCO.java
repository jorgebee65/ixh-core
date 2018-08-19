package com.ixh.exception;

public class DatabaseExceptionCO extends Exception {

   public DatabaseExceptionCO(String message, Throwable cause, Class<?> pOwner) {
      super(message, cause);
   }

   public DatabaseExceptionCO(String message, Class<?> pOwner) {
      super(message);
   }

   public DatabaseExceptionCO(Throwable cause, Class<?> pOwner) {
      super(cause);
   }

   public DatabaseExceptionCO(String message) {
      super(message);
   }

   public DatabaseExceptionCO(String message, Throwable cause) {
      super(message, cause);

   }

}
