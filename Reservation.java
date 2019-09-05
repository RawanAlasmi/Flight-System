/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba1507475p2kauflightreservation;

import java.util.Date;


/** 
Name: RawanFahadAlasmi
ID: 1507475
Section: BA
Course Name: Programming II (COCS203)  
Assignment Number: 2 
*/

public class Reservation {
    
    private String pnrNo;
    private Date reservationDate;
    private Flight flight;
    private Passenger[] passenger;
    
    public Reservation(String pnrNo, Date reservationDate, int totlaPassenger) {
        this.pnrNo = pnrNo;
        this.reservationDate = reservationDate;
        passenger= new Passenger[totlaPassenger];
    }
        
    public String getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public Passenger getPassenger(int index){
        return passenger[index];
    }
    public Passenger[] getAllPassenger() {
        return passenger;
    }
    
    public void setPassenger(Passenger passenger, int index) {
        this.passenger[index] = passenger;
    }
    
}
