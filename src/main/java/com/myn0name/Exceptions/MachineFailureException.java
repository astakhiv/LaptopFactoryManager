package com.myn0name.Exceptions;

/**
 * MachineFailureException
 */
public class MachineFailureException extends RuntimeException {
    public MachineFailureException(String errorMessage) {
      super(errorMessage);
    }
}
