
package com.biz.hotel.reservation.system;



import java.util.*;
import java.time.*;

public class HotelReservationMain
{
    public static void main(String[] args)
    {
        HotelReservation hotelReservation = new HotelReservation();
        System.out.println("Welcome to Hotel Reservation Program");
        //instatiating hotel reservations
        ArrayList<DayOfWeek> datesList;
        //getting input from user
        String[] datesArray = InputCustomerTypeAndDate();

        //adding data into hotel list in hotel reservations using customer type
        AddingHotelDataAccToCustomerType(hotelReservation, datesArray);

        //adding dates in list and converting them to days of week
        //if date input is not in correct form, then custom exception thrown by method is catched.
        try
        {
            datesList = hotelReservation.AddingDatesInList(datesArray);
        }
        catch (HotelReservationCustomExceptions ex)
        {
            System.out.println(ex.Message);
            return;
        }

        //iterating loop until user wants to find best hotels
        while (true)
        {
            System.out.println("Please Enter 1 to find cheapest hotel\nPlease Enter 2 to find hotel with best ratings");
            //reading input to choose between cheap hotel or best rated hotel
            int option = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (option)
            {
                case 1:
                    //calling the method for getting cheapest hotel for given dates
                    hotelReservation.CheapestHotelForGivenDates(datesList);
                    break;
                case 2:
                    //calling method to calculate best rated hotel
                    hotelReservation.FindingHotelsWithBestRatings(datesList);
                    break;
                default:
                    System.out.println("Please enter the correct input");
                    break;
            }
            System.out.println("Do you want to find out again,press y to check again");
            String check = new Scanner(System.in).nextLine();
            if (!(check.toLowerCase().equals("y")))
            {
                break;
            }
        }


    }
    /**
     Addings the type of the hotel data acc to customer.

     @param hotelReservation The hotel reservation.
     @param datesArray The dates array.
     */
    public static void AddingHotelDataAccToCustomerType(HotelReservation hotelReservation, String[] datesArray)
    {

        try
        {
            //first input was taken as customer type, which is seperated and assigned to customer type
            String customerType = datesArray[0];
            //calling method for adding hotels in list
            hotelReservation.AddingHotelsInList(customerType);
            //creating day of week dates list
        }
        catch (HotelReservationCustomExceptions ex)
        {
            System.out.println(ex.Message);
            System.exit(0);
        }
    }

    /**
     Inputs the customer type and date.

     @return array of dates with first element as customer type
     */
    public static String[] InputCustomerTypeAndDate()
    {
        System.out.println("Please enter the customer type and dates(DDMMMMYYYY) for which cheapest hotel needs to be find out");
        //reading the dates in string
        String datesString = new Scanner(System.in).nextLine();
        //adding the string of dates in array
        String[] datesArray = datesString.split("[,]", -1);
        return datesArray;
    }

}