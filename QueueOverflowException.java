/*
    Version: 1.0
    Author: Preyash Patel
    Date: 07/11/2020
 */

public class QueueOverflowException extends Exception {
    public QueueOverflowException(){
        super();
    }

    public QueueOverflowException(String message){
        super(message);
    }
}
