package com.but.simple.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class Utils {

    private Utils(){ }

    public static String dateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        ZoneId zoneId = ZoneId.of("Europe/Kiev");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        return zonedDateTime.format(dateTimeFormatter);
    }
}
