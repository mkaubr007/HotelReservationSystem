
package com.biz.hotel.reservation.system;


public class HotelReservationCustomExceptions extends RuntimeException
{
    public boolean Message;

    public enum ExceptionType
    {
        INVALID_CUSTOMER_TYPE,
        INVALID_DATE,
        INVALID_TOTAL_RATE,
        INVALID_HOTEL_NAME;

        public static final int SIZE = java.lang.Integer.SIZE;

        public int getValue()
        {
            return this.ordinal();
        }

        public static ExceptionType forValue(int value)
        {
            return values()[value];
        }
    }
    public ExceptionType type = ExceptionType.values()[0];
    public HotelReservationCustomExceptions(ExceptionType type, String message)
    {
        super(message);
        this.type = type;
    }
}

