/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba1507475p2kauflightreservation;

/** 
Name: RawanFahadAlasmi
ID: 1507475
Section: BA
Course Name: Programming II (COCS203)  
Assignment Number: 2 
*/

import java.util.Date;
import java.util.Scanner;

public class BA1507475P2KAUFlightReservation {
   

    public static int uniqueNumber;
    public static String uniqueCode;
    public static int indexFlight = 0;
    public static int indexPassenger = 0;
    public static int indexReservation = 0;

    public static void main(String[] args) {

        uniqueNumber = 100; 
        uniqueCode = "JED"; 
        Scanner read = new Scanner(System.in); 
        
        int flightTotal, passengerTotal, reservationTotal;
        Flight flight[];
        Passenger passenger[];
        Reservation reservation[];

        //get total flight
        System.out.println("System is going to set initial parameters, please provide the following details");
        System.out.println("Enter Total Fligth Available");
        flightTotal = read.nextInt();
        flight = new Flight[flightTotal];
        //get total passengers
        System.out.println("Now, Enter Total Passengers, System is going accommodate");
        passengerTotal = read.nextInt();
        passenger = new Passenger[passengerTotal];
        //get total reservations
        System.out.println("Lastly, Enter number of reservations System has to create");
        reservationTotal = read.nextInt();
        reservation = new Reservation[reservationTotal];
        System.out.println("********* Thank You, System has been set, ready for Booking *********\n");

        generateMainMenu(flight, passenger, reservation, flightTotal, passengerTotal, reservationTotal, read);

    } // end main method
    //------------------------------------------------------------------------------------------------------
    
    
    public static void generateMainMenu(Flight flight[], Passenger passenger[], Reservation reservation[], int flightTotal, int passengerTotal, int reservationTotal, Scanner read) {

        while (true) {
            mainMenu(); 
            int option = 0;
            String pnr;
            System.out.println("Enter Your Chooice");
            option = read.nextInt(); 
            switch (option) {
                case 1:
                    if (!userAddedAllFlights(flight)) {
                        Flight objFlight = new Flight();
                        inputFlight(read, objFlight, flight); 
                    }
                    break;
                case 2:
                   
                    if (!userAddedAllPassengers(passenger)) {
                        Passenger objPassenger = new Passenger();
                        inputPassenger(read, objPassenger, passenger); 
                    }
                    break;
                case 3:
                    if (indexFlight == 0 || indexPassenger == 0) {
                        System.out.println("No passenger or Flight Record in the System!");
                    } else {

                        if (indexReservation <= reservation.length) {
                            //Print this message if there are no room for reservations
                            System.out.println("You have already completed the maximum reservations");
                        } 
                        {
                            listFlightDetails(flight);
                            System.out.println("Choose a flight Index from the above list ");
                            int chosenFlighIndex = read.nextInt();
                            boolean wrong_index = true;

                            if (chosenFlighIndex < 0 || chosenFlighIndex > indexFlight-1) {
                                System.out.println("Please Choose only Index shown in the Flight list!");
                                
                                while (wrong_index) {
                                    listFlightDetails(flight); //print all the avaiable flights with thier index
                                    System.out.println("Choose a flight Index from the above list ");
                                    chosenFlighIndex = read.nextInt();
                                    wrong_index = (chosenFlighIndex < 0 || chosenFlighIndex > indexFlight-1);
                                    
                                }
                            }
                            if (flight[chosenFlighIndex].getRemSeats() > 0) {
                                    addNewBooking(read, flight, passenger, reservation, chosenFlighIndex);
                                } else {
                                    System.out.println("There are no avaialbe seats in this flight!!");
                                }
                        }
                    }

                    break;

                case 4:
                    //Print booking detials by PNR number
                    System.out.println("Enter the PNR number to bring the Booking details");
                    pnr = read.next();
                    int length = reservation.length;
                    int index = 0,
                     counter = 0;
                    for (int i = 0; i < length; i++) {
                        String reservationPNR = reservation[i].getPnrNo();
                        if (reservationPNR != null && reservationPNR.equals(pnr)) {
                            index = i;
                            counter++;
                            break;
                        }
                    }
                    if (counter > 0) {
                        printBooking(reservation, index);
                    } 
                    else {
                        System.out.println("No Record found with the PNR " + pnr);
                    }
                    break;

                case 5:
                    //Print all the flight details
                    listAllFlights(flight);
                    break;
                case 6:
                    //Exit program menu and end program!
                    System.out.println("Thank you for using KAU Reservation System, Good Bye!");
                    System.exit(0);
                default:
                    System.out.println("You are required to choose from the program menu which from 1 to 6");
            }//end switch
        }//end the loop
    }//end generateMainMenu method
    //------------------------------------------------------------------------------------------------------
    
    public static void mainMenu() {
        //Print flight reservation system menu
        String hash = "#############################################";
        System.out.println(hash);
        System.out.println("***** Welcome to KAU Flight Reservation System *****");
        System.out.println("1. Add Flight Details in the System");
        System.out.println("2. Add Passenger Details in the System");
        System.out.println("3. Make a new Booking");
        System.out.println("4. Search and Print a Booking");
        System.out.println("5. List Flight Status");
        System.out.println("6. Exit from the System");
        System.out.println(hash);

    } //end mainMenu method
    //------------------------------------------------------------------------------------------------------
    
    public static void inputFlight(Scanner keyBoard, Flight tempFlight, Flight[] flight) {

        System.out.println("Enter Flight Code");
        tempFlight.setFlightCode(keyBoard.next());
        System.out.println("Enter City From");
        tempFlight.setCityFrom(keyBoard.next());
        System.out.println("Enter City To");
        tempFlight.setCityTo(keyBoard.next());
        System.out.println("Enter Total Seats");
        int totalSeats = keyBoard.nextInt();
        tempFlight.setTotalSeats(totalSeats);
        tempFlight.setRemSeats(totalSeats);
        System.out.println("Enter Price For a Seat");
        tempFlight.setPrice(keyBoard.nextDouble()); 
        flight[indexFlight] = tempFlight; 
        System.out.println("Successfully Added Flight Details in the System!");
        indexFlight++; 
    } //end inputFlight method
    //------------------------------------------------------------------------------------------------------
    
    public static void inputPassenger(Scanner keyBoard, Passenger tempPassenger, Passenger[] passenger) {
        System.out.println("Enter Passenger Name");
        keyBoard.nextLine();
        String name = keyBoard.nextLine();
        tempPassenger.setName(name);
        String passengerName = tempPassenger.getName();
        System.out.println("Enter Age of " + passengerName);
        tempPassenger.setAge(keyBoard.nextInt());
        System.out.println("Enter Gender of " + passengerName);
        tempPassenger.setGender(keyBoard.next().charAt(0));
        System.out.println("Enter Phone Number of " + passengerName);
        tempPassenger.setPhone(keyBoard.next());
        passenger[indexPassenger] = tempPassenger; 
        System.out.println("Successfully Added Passenger Details in the System!");
        indexPassenger++; 
    }// end inputPassenger method
    //------------------------------------------------------------------------------------------------------
    
    public static void addNewBooking(Scanner KeyBoard, Flight[] flight, Passenger[] passenger, Reservation[] reservation, int chosenFlighIndex) {

        boolean moreThanMax = true;
        System.out.println("How many Passenger in this Booking");
        int totalPassenger = KeyBoard.nextInt();
        int choosenPassengerIndex;
       
        while (moreThanMax) {
            if (totalPassenger > passenger.length) {
                System.out.println("You can reserve Maximum " + passenger.length + " passengers only!");
                System.out.println("How many Passenger in this Booking");
                totalPassenger = KeyBoard.nextInt();
            } else {
                moreThanMax = false;
            }
        }

        String pnr = uniqueCode + uniqueNumber;
        reservation[indexReservation] = new Reservation(pnr, new Date(), totalPassenger);
        reservation[indexReservation].setFlight(flight[chosenFlighIndex]);
        int remSeats = flight[chosenFlighIndex].getRemSeats();
        
        for (int i = 0; i < totalPassenger; i++) {

            if (passenger[i] != null) {
                do {
                    listPassengerDetails(passenger);
                    System.out.println("Choose a Passenger(" + (i + 1) + ") index from the above list");
                    choosenPassengerIndex = KeyBoard.nextInt();

                    if (!(choosenPassengerIndex <= indexPassenger - 1)) {
                        System.out.println("Please Choose only Index shown in the Passenger list!");
                    }
                } while (!(choosenPassengerIndex <= indexPassenger - 1));

                if(remSeats> 0){
                reservation[indexReservation].setPassenger(passenger[chosenFlighIndex], i);
                flight[chosenFlighIndex].setRemSeats(remSeats - 1); 
                remSeats= remSeats -1;
                }
                else{
                    System.out.println("There are no avaialbe seats in this flight!!");
                    break;
                }
            }
        } // end for loop
        System.out.println("Your Booking is confrimed, Booking reference (PNR Number) is:" + pnr);
        uniqueNumber++;   

    } // end addNewBooking method
    //------------------------------------------------------------------------------------------------------
    
    
    public static void listFlightDetails(Flight[] flight) {
        int length = flight.length, index;

        for (int i = 0; i < length; i++) {
            index = i;
            if (flight[index] != null) {
                System.out.println(
                        "Enter " + index + " for Flight code:"
                        + flight[index].getFlightCode() + " ,"
                        + flight[index].getCityFrom() + " ,"
                        + flight[index].getCityTo());
            }
        }
    }// end listFlightDetails method
    //------------------------------------------------------------------------------------------------------
    
    public static void listPassengerDetails(Passenger[] passenger) {
        int length = passenger.length, index;
        for (int i = 0; i < length; i++) {
            index = i;
            if (passenger[index] != null) {
                System.out.println("Enter " + index
                        + " for Passenger :"
                        + passenger[index].getName()
                        + " ,"
                        + passenger[index].getGender());
            }
        }
    } // end listPassengerDetails method
    //------------------------------------------------------------------------------------------------------
    
    public static void printBooking(Reservation[] reservation, int index) {

        Flight objFlight = reservation[index].getFlight(); 
        Passenger[] objPassenger = reservation[index].getAllPassenger(); 
        Reservation objReservation = reservation[index];  
        String stars = "***********";
        String line_seperator = "------------------------------------------------------------------";

        System.out.println(stars + " RESERVATION DETAILS ARE AS FOLLOWS  " + stars);
        System.out.println(stars + "   ELECTRONIC TICKET  PASSENGER ITINERARY RECEIPT " + stars);
        System.out.println("PNR NO :" + objReservation.getPnrNo() + " Date :" + objReservation.getReservationDate());
        System.out.println(line_seperator);
        objFlight.printFlight();
        System.out.println();
        System.out.println(line_seperator);

        int length = objPassenger.length;
        double price = objFlight.getPrice();

        for (int i = 0; i < length; i++) {
            if(objPassenger[i]!=null){
            objPassenger[i].printPassenger();
            System.out.println("  Price : " + price);
            }
        }

        double totalCost = price * objPassenger.length;
        System.out.println();
        System.out.println();
        System.out.println("---------------------------Total Price " + totalCost + "--------------------------------");
        System.out.println("AT CHECK-IN, PLEASE SHOW A PICTURE IDENTIFICATION AND THE DOCUMENT YOU GAVE FOR REFERENCE AT RESERVATION TIME");
        System.out.println(line_seperator);
    } // end printBooking method
    //------------------------------------------------------------------------------------------------------
    
    public static void listAllFlights(Flight[] flights) {
        
        if(indexFlight!=0){
            System.out.println("*********** FLIGHT DETAILS ARE AS FOLLOWS ***********");
            for (int i = 0; i < indexFlight; i++) {
            flights[i].printFlightStatus(); 
            System.out.println("--------------------------------------------------");
        }
        }
        else
        {
            System.out.println("Flight Record Not Added");
        }
        
    } //end listAllFlights method
    //------------------------------------------------------------------------------------------------------ 
    
    public static boolean userAddedAllFlights(Flight[] flight) {
        int length = flight.length -1;
        if (flight[length] != null) {
            System.out.println("All flight records are already created!, Max Allowed:" + (length+1));
            return true;
        } else {
            return false;
        }
    }// end userAddedAllFlights method
    //------------------------------------------------------------------------------------------------------ 
    
    public static boolean userAddedAllPassengers(Passenger[] passenger) {

        int length = passenger.length -1;
        if (passenger[length] != null) {
            System.out.println("All passengers records are already created!, Max Allowed:" + (length +1));
            return true;
        } else {
            return false;
        }
    }//end userAddedAllPassengers method
}// end class

