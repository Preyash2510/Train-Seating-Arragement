/*
    Version: 1.0
    Author: Preyash Patel
    Date: 07/11/2020
 */

/*
    Description:-
        Passenger class is a Data Class. It holds the data of a Passenger for the List.
        It implements the Comparable interface to compare two Passenger Objects.
        Its constructor can set Passenger's:
                                            Name,
                                            Station to get Off at,
                                            Ticket Class
                                            Cart number

 */
import java.lang.Comparable;

public class Passenger implements Comparable<Passenger> {

    //Static variables to keep these variables same across all instances of Passenger Class
    private static String[] cartName = {"A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "C4"};
    private static int[] full = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private String name,                        //Passenger Name var
                   station,                     //Passenger Station to get off var
                   ticket,                      //Passenger Ticket class var
                   cart;                        //Passenger Cart Number var

    private int priority_1 = 0,                 //Priority Control 1 for station priority
                priority_2 = 0;                 //Priority Control 2 for ticket priority

    /*
        Overloaded Constructor for Passenger
        Set's the name, station, ticket and priority

        Parameter:-
                    name    : String var to set name in Passenger class
                    station : String var to set station in Passenger class
                    ticket  : String var to set ticket in Passenger class
     */

    public Passenger(String name, String station, String ticket) throws TicketClassFullException {
        this.name = name;
        this.station = station;
        this.ticket = ticket;
        setPriority();
        assign();
    }

    //Set cart number for passenger
    public void setCart(String cart) {
        this.cart = cart;
    }

    //Set Name for Passenger
    public void setName(String name) {
        this.name = name;
    }

    //Set Station for Passenger
    public void setStation(String station) {
        this.station = station;
    }

    //Set Ticket for Passenger
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    //Get Cart for Passenger
    public String getCart() {
        return cart;
    }

    //Get Name of Passenger
    public String getFullName() {
        return name;
    }

    //Get Station of Passenger
    public String getStation() {
        return station;
    }

    //Get Ticket of Passenger
    public String getTicket() {
        return ticket;
    }

    /*
        Set the priority of the Passenger.
        Each station priority has a difference of 3, to accommodate the difference in tickets
     */
    public void setPriority(){
        switch (this.station){
            case "Boston":          this.priority_1 = 0; break;
            case "New Haven":       this.priority_1 = 3; break;
            case "New York":        this.priority_1 = 6; break;
            case "Philadelphia":    this.priority_1 = 9; break;
            case "Wilmington":      this.priority_1 = 12; break;
            case "Washington":      this.priority_1 = 15; break;
            default:
                System.err.println("**Error: Station Unknown!!**");
                break;
        }

        switch (this.ticket){
            case "First":       this.priority_2 = 0; break;
            case "Second":      this.priority_2 = 1; break;
            case "Third":       this.priority_2 = 2; break;
            default:
                System.err.println("**Error: Ticket Unknown!!**");
                break;
        }
    }

    /*
        Compare two Passenger
        return:
            -100: means the passed object is null
            + Number: means that the object should be less than This Object
            - Number: means that the object should be greater than This Object
     */
    @Override
    public int compareTo(Passenger p) {

        if(p == null){
            return -100;
        }

        //Add all priority in a Passenger class, and subtract with the passed passenger Object
        return (this.priority_1 + this.priority_2) - (p.priority_1 + p.priority_2);
    }

    //For printing info into string
    @Override
    public String toString() {
        String format = String.format("%-15s%5s%20s%5s%10s%5s%8s%7s",
                this.station, "|", this.name, "|", this.ticket, "|", this.cart, "|");

        return format;
    }

    /*
        Assigns Cart number to passenger according to their class and the cart availability.
            It has static variables to keep track of which carts are full and which are empty

            Example:
                    ["A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "C4"]
                    [ 0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ]

                    Let's say a new Passenger Object is created then the ticket will also be assigned to the Passenger
                    ,So when this method is called, it will check the ticket and assign cart# to Passenger accordingly

                    Passenger p1 = new Passenger("Preyash Patel", "Boston", "First")
                      |
                      V
                    ["A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "C4"]
                    [ 1  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ]

                    Passenger p2 = new Passenger("Dhairya Desai", "Boston", "First")
                      |
                      V
                    ["A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "C4"]
                    [ 2  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ,  0  ]

     */
    public void assign() throws TicketClassFullException {
        switch (getTicket()){
            case "First":
                if(full[0] < 4){
                    setCart(cartName[0]);
                    full[0]++;
                }else if (full[1] < 4){
                    setCart(cartName[1]);
                    full[1]++;
                }
                else {
                    throw new TicketClassFullException("First Class is Full!!");
                }
                break;

            case "Second":
                if(full[2] < 8){
                    setCart(cartName[2]);
                    full[2]++;
                }
                else if(full[3] < 8){
                    setCart(cartName[3]);
                    full[3]++;
                }
                else if(full[4] < 8){
                    setCart(cartName[4]);
                    full[4]++;
                }
                else {
                    throw new TicketClassFullException("Second Class is Full!!");
                }
                break;

            case "Third":
                if(full[5] < 20){
                    setCart(cartName[5]);
                    full[5]++;
                }
                else if(full[6] < 20){
                    setCart(cartName[6]);
                    full[6]++;
                }
                else if(full[7] < 20){
                    setCart(cartName[7]);
                    full[7]++;
                }
                else if(full[8] < 20){
                    setCart(cartName[8]);
                    full[8]++;
                }
                else {
                    throw new TicketClassFullException("Third Class is Full!!");
                }
                break;
        }
    }
}
