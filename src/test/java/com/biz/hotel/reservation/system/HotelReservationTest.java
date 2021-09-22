
package com.biz.hotel.reservation.system;

import org.junit.Assert;
import org.junit.Test;


import java.util.*;
import java.time.*;


public class HotelReservationTest
{
    private HotelReservation hotelReservation = new HotelReservation();
    /**
     Findings the cheapest hotel and price for given dates for regular customer.
     */
//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void FindingCheapestHotelAndPrice_ForGivenDates_ForRegularCustomer()
    public final void FindingCheapestHotelAndPrice_ForGivenDates_ForRegularCustomer()
    {
        String[] customerTypeAnddates = {"Regular", "11September2020", "12September2020"};
        hotelReservation.AddingHotelsInList(customerTypeAnddates[0]);
        ArrayList<DayOfWeek> dayofweeks = hotelReservation.AddingDatesInList(customerTypeAnddates);
        //getting actual and expected hotel object
        HotelModel hotelModelActual = hotelReservation.CheapestHotelForGivenDates(dayofweeks);
        HotelModel hotelModelExpected = new HotelModel(200, "Bridgewood", 4);
        //assert
        assert hotelModelExpected == hotelModelActual;


    }
    /**
     Findings the cheapest hotel and price for given dates for rewards customer.
     */
//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void FindingCheapestHotelAndPrice_ForGivenDates_ForRewardsCustomer()
    public final void FindingCheapestHotelAndPrice_ForGivenDates_ForRewardsCustomer()
    {
        //getting data
        String[] customerTypeAnddates = {"Rewards", "11September2020", "12September2020"};
        //adding customer type
        hotelReservation.AddingHotelsInList(customerTypeAnddates[0]);
        //getting days of week from method
        ArrayList<DayOfWeek> dayofweeks = hotelReservation.AddingDatesInList(customerTypeAnddates);
        //getting actual object
        HotelModel hotelModelActual = hotelReservation.CheapestHotelForGivenDates(dayofweeks);
        //expected object
        HotelModel hotelModelExpected = new HotelModel(140, "Ridgewood", 5);
        //assert
        assert hotelModelExpected == hotelModelActual;
    }
}
