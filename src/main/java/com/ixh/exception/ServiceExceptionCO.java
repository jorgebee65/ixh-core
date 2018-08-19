package com.ixh.exception;

public class ServiceExceptionCO extends Exception {

   public ServiceExceptionCO(String message, Throwable cause, Class<?> pOwner) {
      super(message, cause);

   }

   public ServiceExceptionCO(String message, Throwable cause) {
      super(message, cause);

   }

   public ServiceExceptionCO(String message, Class<?> pOwner) {
      super(message);
   }

   protected ServiceExceptionCO(Throwable cause, Class<?> pOwner) {
      super(cause);
   }
}
