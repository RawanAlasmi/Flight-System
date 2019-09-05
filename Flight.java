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

public class Flight {
    
    private String flightCode;
    private String cityFrom;
    private String cityTo;
    private int totalSeats;
    private int remSeats;
    private double price;
    
    
    public Flight(String flightCode, String cityFrom, String cityTo, int totalSeats, double price) {
        this.flightCode = flightCode;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.totalSeats = totalSeats;
        this.price = price;
    }
       
    public Flight(){}
    
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setRemSeats(int remSeats) {
        this.remSeats = remSeats;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getRemSeats() {
        return remSeats;
    }

    public double getPrice() {
        return price;
    }
    
    public void printFlight(){
        //print flight details

        System.out.println("Flight No : " + flightCode);
        System.out.print("City From : " + cityFrom + "            City To : " + cityTo);
    }
    
    public void printFlightStatus(){
            System.out.print("Code : " + flightCode);
            System.out.print("  Total Seats : " + totalSeats);
            System.out.println("  Remaning Seats : " + remSeats);
            System.out.println("City From : " + cityFrom);
            System.out.println("City From : " + cityTo);
    }
    
    
    
}
