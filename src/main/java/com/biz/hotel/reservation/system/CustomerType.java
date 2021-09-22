package com.biz.hotel.reservation.system;

public enum CustomerType
{
    Regular,
    Rewards;

    public static final int SIZE = java.lang.Integer.SIZE;

    public int getValue()
    {
        return this.ordinal();
    }

    public static CustomerType forValue(int value)
    {
        return values()[value];
    }
}
