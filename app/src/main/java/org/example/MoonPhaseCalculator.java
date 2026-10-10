package org.example;
import java.time.LocalDate;

public interface MoonPhaseCalculator {

    default boolean isNewMoon(LocalDate date){
        return MoonPhase.NEW_MOON == getMoonPhase(date);
    }
    MoonPhase getMoonPhase(LocalDate date);
}
