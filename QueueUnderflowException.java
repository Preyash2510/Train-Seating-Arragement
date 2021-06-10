/*
    Version: 1.0
    Author: Preyash Patel
    Date: 07/11/2020
 */

public class QueueUnderflowException extends Exception{
    public QueueUnderflowException(){
        super();
    }

    public QueueUnderflowException(String message){
        super(message);
    }
}
