package com.biz.hotel.reservation.system;



public class HotelModel
{

    public int totalRate;
    public String hotelName;
    public int weekdayRates;
    public int weekendRates;
    public int ratingsForHotels;

    public HotelModel(int totalRate, String hotelName, int ratingsForHotels)
    {
        this.totalRate = totalRate;
        this.hotelName = hotelName;
        this.ratingsForHotels = ratingsForHotels;
    }
    public HotelModel(String hotelName, int weekdayRates, int weekendRates, int ratingsForHotels)
    {
        this.hotelName = hotelName;
        this.weekdayRates = weekdayRates;
        this.weekendRates = weekendRates;
        this.ratingsForHotels = ratingsForHotels;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof HotelModel))
        {
            return false;
        }
        return ((this.hotelName.equals((((HotelModel)obj).hotelName))) && (this.totalRate == (((HotelModel)obj).totalRate)) && (this.ratingsForHotels == (((HotelModel)obj).ratingsForHotels)));
    }
    @Override
    public int hashCode()
    {
        return this.hotelName.hashCode() ^ (new Integer(this.totalRate)).hashCode() ^ (new Integer(this.ratingsForHotels)).hashCode();
    }
}