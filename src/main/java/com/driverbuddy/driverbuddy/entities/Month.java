package com.driverbuddy.driverbuddy.entities;

public enum Month {
    Ianuarie(0, "Ianuarie"),
    Februarie(1, "Februarie"),
    Martie(2, "Martie"),
    Aprilie(3, "Aprilie"),
    Mai(4, "Mai"),
    Iunie(5, "Iunie"),
    Iulie(6, "Iulie"),
    August(7, "August"),
    Septembrie(8, "Septembrie"),
    Octombrie(9, "Octombrie"),
    Noiembrie(10, "Noiembrie"),
    Decembrie(11, "Decembrie");

    private final int id;
    private final String name;

    private Month(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Month fromIndex(int index) {
        for (Month month : Month.values()) {
            if (month.getId() == index) {
                return month;
            }
        }
        throw new IllegalArgumentException("Invalid index for month: " + index);
    }
}
