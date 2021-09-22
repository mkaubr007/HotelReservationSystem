
package com.biz.hotel.reservation.system;


import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class HotelReservation
{
    private ArrayList<HotelModel> hotelsList = new ArrayList<HotelModel>();
    private ArrayList<HotelModel> rateAndHotelsList = new ArrayList<HotelModel>();
    private ArrayList<HotelModel> listWithMinPrices = new ArrayList<HotelModel>();
    private HotelModel hotelModel;


    public final void AddingHotelsInList(String customerType)
    {
        System.out.println("Type of Customer:\t" + customerType);
        if (customerType.equals(CustomerType.Regular.toString()))
        {
            hotelsList.add(new HotelModel("Lakewood", 110, 90, 3));
            hotelsList.add(new HotelModel("Bridgewood", 150, 50, 4));
            hotelsList.add(new HotelModel("Ridgewood", 220, 150, 5));
            System.out.println("Hotel Name \tWeekdayHotelPrices\tweekendHotelPrices");
            for (HotelModel hotelModel : hotelsList)
            {
                System.out.println(hotelModel.hotelName + ":\t" + hotelModel.weekdayRates + "\t\t" + hotelModel.weekendRates);
            }
        }
        else if (customerType.equals(CustomerType.Rewards.toString()))
        {
            hotelsList.add(new HotelModel("Lakewood", 80, 80, 3));
            hotelsList.add(new HotelModel("Bridgewood", 110, 50, 4));
            hotelsList.add(new HotelModel("Ridgewood", 100, 40, 5));
            System.out.println("Hotel Name \tWeekdayHotelPrices\tweekendHotelPrices");
            for (HotelModel hotelModel : hotelsList)
            {
                System.out.println(hotelModel.hotelName + ":\t" + hotelModel.weekdayRates + "\t\t" + hotelModel.weekendRates);
            }
        }
        else
        {
            throw new HotelReservationCustomExceptions(HotelReservationCustomExceptions.ExceptionType.INVALID_CUSTOMER_TYPE, "Customer type is invalid");
        }

    }
    public final ArrayList<DayOfWeek> AddingDatesInList(String[] datesArray)
    {
        ArrayList<DayOfWeek> datesList = new ArrayList<DayOfWeek>();
        for (int i = 1; i < datesArray.length; i++)
        {
            LocalDateTime date = LocalDateTime.MIN;
            tangible.OutObject<LocalDateTime> tempOut_date = new tangible.OutObject<LocalDateTime>();
            if (LocalDateTime.TryParseExact(datesArray[i], "ddMMMMyyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, tempOut_date))
            {
                date = tempOut_date.outArgValue;
                System.out.println(date + "\t" + date.getDayOfWeek());
                datesList.add(date.getDayOfWeek());
            }
            else
            {
                date = tempOut_date.outArgValue;
                throw new HotelReservationCustomExceptions(HotelReservationCustomExceptions.ExceptionType.INVALID_DATE, "Date is not of correct type");
            }
        }
        return datesList;

    }

    public final void CalculatingPriceForEachHotel(ArrayList<DayOfWeek> datesList)
    {
        for (HotelModel hotelModel : hotelsList)
        {
            int totalPrice = 0;
            for (DayOfWeek day : datesList)
            {
                if (day.toString().equals("Saturday") || day.toString().equals("Sunday"))
                {
                    totalPrice = totalPrice + hotelModel.weekendRates;
                }
                else
                {
                    totalPrice = totalPrice + hotelModel.weekdayRates;
                }
            }
            System.out.println(" Hotel for given Dates:\t" + hotelModel.hotelName + " Total Price to be paid:\t" + totalPrice);
            rateAndHotelsList.add(new HotelModel(totalPrice,hotelModel.hotelName,hotelModel.ratingsForHotels));
        }
    }

    public final HotelModel CheapestHotelForGivenDates(ArrayList<DayOfWeek> datesList)
    {
        CalculatingPriceForEachHotel(datesList);
        for (HotelModel hotelModel : rateAndHotelsList.stream()(r -> r.totalRate).collect(Collectors.toList()))
        {
            if (hotelModel.totalRate == rateAndHotelsList.Min(r -> r.totalRate))
            {
                listWithMinPrices.add(hotelModel);
                System.out.println("\nHotel for given Dates:\t" + hotelModel.hotelName + "\nTotal Price to be paid for hotel:\t" + hotelModel.totalRate + "\nRating of Hotel:\t" + hotelModel.ratingsForHotels);
                System.out.println();

            };

        };
        for (HotelModel hotelModel : listWithMinPrices)
        {
            if (hotelModel.ratingsForHotels == listWithMinPrices.Max(r -> r.ratingsForHotels))
            {
                System.out.println("*************************Cheapest hotel with best ratings*****************************");
                System.out.println("\nCheapest Hotel for given Dates:\t" + hotelModel.hotelName + "\nTotal Price to be paid for cheapest hotel:\t" + hotelModel.totalRate + "\nRating of Hotel:\t" + hotelModel.ratingsForHotels);
                return hotelModel;
            }
        }
        return null;
    }

    public final void FindingHotelsWithBestRatings(ArrayList<DayOfWeek> dateList)
    {
        CalculatingPriceForEachHotel(dateList);
        for (HotelModel hotelModel : rateAndHotelsList)
        {
            if (hotelModel.ratingsForHotels == rateAndHotelsList.Max(r -> r.ratingsForHotels))
            {
                System.out.println("************************* Hotel with best ratings*****************************");
                System.out.println("\nBest Hotel for given Dates:\t" + hotelModel.hotelName + "\nTotal Price to be paid for  hotel:\t" + hotelModel.totalRate + "\nRating of Hotel:\t" + hotelModel.ratingsForHotels);
            }
        }
    }
}


}