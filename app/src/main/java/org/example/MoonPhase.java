package org.example;

public enum MoonPhase {
    NEW_MOON("New Moon"),
    WAXING_CRESCENT("Waxing Crescent"),
    FIRST_QUARTER("First Quarter"),
    WAXING_GIBBOUS("Waxing Gibbous"),
    FULL_MOON("Full Moon"),
    WANING_GIBBOUS("Waning Gibbous"),
    WANING_CRESCENT("Waning Crescent"),
    LAST_QUARTER("Last Quarter");
    String name;

    MoonPhase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//4. Update MoonPhaseCalculator. Using default methods will help prevent compiler errors:
