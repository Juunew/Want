package com.trip.want.common.constant;

public enum Continent {
    ASIA("아시아"),
    NORTH_AMERICA("북미"),
    SOUTH_AMERICA("남미"),
    EUROPE("유럽"),
    AFRICA("아프리카"),
    AUSTRALIA("오스트레일리아");

    private final String description;

    Continent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
