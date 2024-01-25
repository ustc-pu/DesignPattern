# Identify requirements
1. Entry, assign a spot and issues a ticket when vehicle enters the parking lot, 
2. Exit, Scans the ticket and handles the payment.
3. The payment methods can be credit card and cash.
4. Parking spot has four types: compact, large, handicapped, EV(with charging supports)
5. Vehicle has five types: EV, car, van, truck, motorcycle.
6. Parking lot shuold display how many spots are available.
7. There could be multiple entry and exit points
8. Customer can pay the fee at exit point or at a machine near the parking spot.

# Key Usecases
1. Vehicle enters the parking lot and the system assigns a spot and issues a ticket
2. Vehicle exits the parking lot, the system hanles the payment and let the customer exit.

# Establish the classes


```java
1. Vehicle class:
String plateNumber,
int spotId, 
Ticket ticket, 
VehicleTypeEnum vehicleType

2. Spot class:
int spotId, 
SpotTypeEnum spotType, 
boolean available

3. Ticket class:
long ticketId, 
String plateNumber, 
Date entryTime, 
Date exitTime, 
double fee, 
Payment payment


4. ParkingLot class
// could be a singletone 
Map<Integer, Entry> entries,
Map<Integer, EXit> exits,
Map<Integer, Spot> spots,
Parkingrate parkingrate,

void displayFreeSpots();

5. Exit class
int exitId,
void validateTicket(Ticket ticket);

6. Entry class
int entryId,
void getTicket();

7. Payment interface
// strategy pattern
boolean pay(double amount);

7.1 CashPayment
7.2 CreditCardPayment 

8 VehicleTypeEnum: EV, CAR, VAN, TRUCK, MOTORCYCLE
9 SpotTypeEnum: COMPACT, LARGE, EV, HANDICAPPED

```

## Class relationships

- Spot Vehicle, aggregation 1:1
- Vehicle Ticket, aggregation 1:1
- Ticket Payment, association
- ParkingLot (Spot, Entry, Exit) composition 1:n
- Payment CreditCardPayment/CashPayment inhertance

TODO:
Add a diagram here


