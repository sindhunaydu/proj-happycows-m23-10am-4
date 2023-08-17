package edu.ucsb.cs156.happycows.errors;

public class NoCowsException extends Exception {
    public NoCowsException(String messageString){
      super(messageString);
    }
  }
