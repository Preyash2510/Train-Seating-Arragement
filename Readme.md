# Train Seating Layout

This Java Side Project was built to learn the Data Structure **_Priority Queue_**.

### Priority Queue
The Data Structure is Generic, however it can only do basic functions of the Queue.

#### Functionality
* Add Element
* Remove Element
* Get Front
* Get Last
* Peek
* Get Size

---
## Compile & Run
```bash
javac TrainLayout.java
java TrainLayout
```
---
## Program Running
### Options
They run in a loop after each option selection is executed
```bash
1: Enter a Passenger
2: Enter Multiple Passengers
3: Display Passenger List
4: Get Off Station
0: Exit
Pick an Option (type the number): #input
```
#### Option 1
```bash
******************* Enter Passenger *******************
Enter the Full Name of Passenger: #input
Enter the station the Passenger gets off: #input
Enter the Ticket Class of Passenger: #input
```

#### Option 2
Enter Multiple Passenger
```bash
************** Enter Multiple Passenger ***************
How many Passenger would like to enter: #input
# Loop to enter n number of Passenger
```

#### Option 3
Displays the List
```bash
# Displays the list of passengers
```

#### Option 4
Removes Passengers from the Queue
```bash
***************** Getting Off Station *****************
# Removes all the Passenger at a Station in the following order
# Every time a option 4 is selected one station is removed
# {"Boston", "New Haven", "New York", "Philadelphia", "Wilmington", "Washington"}
```

#### Option 0
Exit
```bash
************************* Exit ************************
The Train has gone to hangar.
Train Route: Closed
```

Author: Preyash Patel
