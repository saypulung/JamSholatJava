package com.puricreative;

import com.batoulapps.adhan2.*;
import com.batoulapps.adhan2.data.DateComponents;
import com.batoulapps.adhan2.model.Rounding;
import com.batoulapps.adhan2.model.Shafaq;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String args[]) {
        PrayerTimes prayerTimes = getPrayerTimes();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        System.out.println(
                String.format("%s/%s/%s",
                        prayerTimes.getDateComponents().getDay(),
                        prayerTimes.getDateComponents().getMonth(),
                        prayerTimes.getDateComponents().getYear()
                ));

        Date d;
        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getFajr().getEpochSeconds()));
        System.out.println("Fajr: " + formatter.format(d));

        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getSunrise().getEpochSeconds()));
        System.out.println("Sunrise: " + formatter.format(d));

        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getDhuhr().getEpochSeconds()));
        System.out.println("Dhuhr: " + formatter.format(d));

        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getAsr().getEpochSeconds()));
        System.out.println("Asr: " + formatter.format(d));

        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getMaghrib().getEpochSeconds()));
        System.out.println("Maghrib: " + formatter.format(d));

        d = Date.from(java.time.Instant.ofEpochSecond(prayerTimes.getIsha().getEpochSeconds()));
        System.out.println("Isha: " + formatter.format(d));
    }

    @NotNull
    private static PrayerTimes getPrayerTimes() {
        Coordinates coordinates = new Coordinates(-5.376D, 105.277D);
        DateComponents dateComponents = new DateComponents(2026, 2, 6);
        CalculationParameters calculationParameters = new CalculationParameters(
                20.0,
                18.0,
                0,
                CalculationMethod.NORTH_AMERICA,
                Madhab.SHAFI,
                null,
                new PrayerAdjustments(),
                new PrayerAdjustments(),
                Rounding.NEAREST,
                Shafaq.AHMER
        );

        return new PrayerTimes(coordinates, dateComponents, calculationParameters);
    }
}
