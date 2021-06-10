/*
    Version: 1.0
    Author: Preyash Patel
    Date: 07/11/2020
 */

import java.lang.Comparable;

/*
    Description:-
        PassengerPriorityQueue is a generic Data Structure class. It represents a priority queue.
        This class has a generic that extends to Comparable Interface to compare objects.
        By comparing it also sorts the Passengers in the queue according
        to their get off station and their ticket type.
 */
public class PassengerPriorityQueue<E extends Comparable>
{
    //Variables for the Priority Queue
    public E[] queue;

    private int front = 0,
                rear = -1;

    private int capacity;
    private int occupied = 0;

    /*
        Overloaded Constructor for the Queue

        Parameter:-
                    capacity : int var for Queue Size
     */
    public PassengerPriorityQueue(int capacity){
        queue = (E[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    //Get the last element in the Queue
    public int getRear() {
        return rear;
    }

    //Get the first element in the Queue
    public int getFront() {
        return front;
    }

    //Get the size of the Queue
    public int getCapacity() {
        return capacity;
    }

    //Get the number of elements in the Queue
    public int getOccupancy(){
        return occupied;
    }

    //Checks if the Queue is full
    public boolean isFull(){
        return getOccupancy() == capacity;
    }

    //Checks if the Queue is empty
    public boolean isEmpty(){
        return getOccupancy() < 1;
    }

    /*
        Add elements to the rear of the Queue
        Also sort the queue according to priority
        Increment the Queue occupancy

        Parameter:-
                    element : Generic value to add to the Queue
     */
    public void enqueue(E element) throws QueueOverflowException {
        if (isFull()){
            throw new QueueOverflowException("The Queue is Full!");
        }

        rear = (rear + 1) % capacity;

        if(isEmpty()){
            occupied++;
            queue[rear] = element;
        }
        else {
            occupied++;
            int i = sortPriority(element);
            queue[i] = element;
        }
    }

    /*
        Get the last element value in the Queue

        Returns:-
                 E : The element in the end of Queue
     */
    public E peek() throws QueueUnderflowException {
        if (isEmpty()){
            throw new QueueUnderflowException("The Queue is Empty!");
        }

        return queue[front];
    }

    /*
        Remove the first element from the Queue
        Change the front index to next element
        Decrement the occupancy
     */
    public void dequeue() throws QueueUnderflowException {
        if (isEmpty()){
            throw new QueueUnderflowException("The Queue is Empty!");
        }

        occupied--;
        queue[front] = null;
        front = (front + 1) % capacity;
    }

    /*
        This method finds the index where the element should be according to its priority
        Also Shifts the elements backwards in Queue if they are lesser priority then the given element
        Uses the the CompareTo method in Passenger class

        Parameter:-
                    sortElement : Element needed to be sorted in the Queue

        Return:-
                    index : The index where the element needs to be in the Queue

     */
    public int sortPriority(E sortElement){

        for(int i = front, occupy = 0; occupy < getOccupancy(); occupy++, i = (i + 1) % capacity){
            int val = sortElement.compareTo(queue[i]);

            //If the value is exact match then shift the elements from the index
            if(val == 0){
                shift(i);
                return i;
            }
            //If the value is lesser match then shift the elements from the index
            else if(val <= -1){
                shift(i);
                return i;
            }
            //If the value is greater match then shift the element from the index + 1
            else if(val == 1){
                shift(i + 1);
                return i + 1;
            }
            //If the value itself was a null then don not continue and return the last element
            else if(val == -100){
                break;
            }
            else{
                continue;
            }
        }

        return rear;
    }

    /*
        Shifts the element from the given index backwards to the available spot in the Queue

        Parameter:-
                    i : Index to shift from
     */
    public void shift(int i){
        for(int j = rear; j >= i; j = (j - 1) % capacity){
            queue[(j + 1) % capacity] = queue[j];
        }
    }

    // Displays the whole list of passenger in the train if the train is not empty with their cart#
    public void display(){

        System.out.println("--------------------------------------------------------------------------|");
        System.out.println("                                  List                                    |");
        System.out.println("--------------------------------------------------------------------------|");
        System.out.printf("%-15s%5s%15s%10s%10s%5s%10s%5s\n", "Station", "|", "Name", "|", "Ticket", "|", "Cart#", "|");
        System.out.println("-------------------|------------------------|--------------|--------------|");

        if(isEmpty()){
            System.out.println("                             Train is Empty                               |");
        }
        else {
            for(int i = getFront(), occupy = 0;
                occupy < getOccupancy();
                i = (i + 1) % getCapacity(), occupy++)
            {
                System.out.println(queue[i].toString());
            }
        }

        System.out.println("--------------------------------------------------------------------------|");
    }
}
