import java.util.Scanner;

public class TrainLayout {

    //An Array for the stations in the route
    private static final String[] station =
            {"Boston", "New Haven", "New York", "Philadelphia", "Wilmington", "Washington"};

    //Variable for the PassengerPriorityQueue (Priority Queue), with 112 seats
    public static PassengerPriorityQueue<Passenger> train = new PassengerPriorityQueue<>(112);

    private static int stationNum = 0;      //Checks the number of stations the train stopped at

    private static final Scanner kb = new Scanner(System.in);

    //Main method Prints all the option and calls the continue method
    public static void main(String[] args) throws QueueOverflowException,
                                                  QueueUnderflowException,
                                                  TicketClassFullException
    {

        System.out.println("******************** Train Program ********************");

        System.out.println("1: Enter a Passenger");
        System.out.println("2: Enter Multiple Passengers");
        System.out.println("3: Display Passenger List");
        System.out.println("4: Get Off Station");
        System.out.println("0: Exit");

        continueMain();

    }

    //This method takes an input and using switch executes the method associated with the option
    public static void continueMain() throws QueueUnderflowException,
                                             TicketClassFullException,
                                             QueueOverflowException
    {
        int option;

        System.out.print("Pick an Option (type the number): ");
        option = kb.nextInt();

        switch (option){
            case 1:
                System.out.println("******************* Enter Passenger *******************");
                enter();
            break;

            case 2:
                System.out.println("************** Enter Multiple Passenger ***************");
                enterMult();
            break;

            case 3:
                train.display();
            break;

            case 4:
                System.out.println("***************** Getting Off Station *****************");
                remove(station[stationNum]);        //This always ensures that stations will be in-order of the array
                stationNum++;
            break;

            case 0:
                System.out.println("************************* Exit ************************");
                System.out.println("The Train has gone to hangar.\nTrain Route: Closed");
                kb.close();
                System.exit(0);

            break;
        }

        main(new String[0]);
    }

    /*
        This method takes user input for the following and create a passenger
            - Passenger full name
            - Passenger station they get off
            - Passenger ticket type

        Then put them into a Queue.
     */
    public static void enter() throws TicketClassFullException,
                                      QueueOverflowException
    {

        String name,
                station,
                ticket;

        System.out.print("Enter the Full Name of Passenger: ");
        kb.nextLine();
        name = kb.nextLine();

        System.out.print("Enter the station the Passenger gets off: ");
        station = kb.nextLine();

        System.out.print("Enter the Ticket Class of Passenger: ");
        ticket = kb.nextLine().replaceAll(" Class", "").trim();

        Passenger p = new Passenger(name, station, ticket);

        train.enqueue(p);
    }

    /*
        This method enters multiple people into the queue.
        It asks for number of people to enter, then loops till the number
     */
    public static void enterMult() throws TicketClassFullException,
                                          QueueOverflowException
    {
        int num;

        System.out.print("How many Passenger would like to enter: ");
        num = kb.nextInt();

        for (int i = 0; i < num; i++){
            System.out.println("********************* Passenger " + (i + 1) + " *********************");
            String name,
                    station,
                    ticket;

            System.out.print("Enter the Full Name of Passenger: ");
            if(i == 0){
                kb.nextLine();
            }
            name = kb.nextLine();

            System.out.print("Enter the station the Passenger gets off: ");
            station = kb.nextLine();

            System.out.print("Enter the Ticket Class of Passenger: ");
            ticket = kb.nextLine().replaceAll(" Class", "").trim();

            Passenger p = new Passenger(name, station, ticket);

            train.enqueue(p);
        }
    }

    /*
        This method remove all the Passenger that get off at a particular station
     */
    public static void remove(String station) throws QueueUnderflowException {

        for(int i = train.getFront(), occupy = 0;
            occupy < train.getOccupancy();
            i = (i + 1) % train.getCapacity(), occupy++)
        {
            if(train.peek().getStation().equals(station)){
                train.dequeue();
            }
            else{
                break;
            }
        }
    }
}
