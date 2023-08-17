package edu.ucsb.cs156.happycows.errors;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String messageString){
        super(messageString);
    }
}
