/*
    Version: 1.0
    Author: Preyash Patel
    Date: 07/11/2020
 */

public class TicketClassFullException extends Exception {
    public TicketClassFullException(){
        super();
    }

    public TicketClassFullException(String ticket){
        super("This " + ticket + " does not exist!");
    }
}
