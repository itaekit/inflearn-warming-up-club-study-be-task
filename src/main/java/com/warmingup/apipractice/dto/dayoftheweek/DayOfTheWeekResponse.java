package com.warmingup.apipractice.dto.dayoftheweek;

import java.time.LocalDate;

public class DayOfTheWeekResponse {
    private final String dayOfTheWeek;

    public DayOfTheWeekResponse(LocalDate date) {
        String tmp = date.getDayOfWeek().toString();
        this.dayOfTheWeek = tmp.substring(0, tmp.length() - 3);
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
