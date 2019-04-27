class SpaceAge {

    private final static double SECONDS_OF_YEAR_ON_EARTH = 31557600;

    private final static double MERCURY_MULTIPLIER = 0.2408467;
    private final static double VENUS_MULTIPLIER = 0.61519726;
    private final static double MARS_MULTIPLIER = 1.8808158;
    private final static double JUPITER_MULTIPLIER = 11.862615;
    private final static double SATURN_MULTIPLIER = 29.447498;
    private final static double URANUS_MULTIPLIER = 84.016846;
    private final static double NEPTUNE_MULTIPLIER = 164.79132;

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        return formatTo2Decimals(seconds / SECONDS_OF_YEAR_ON_EARTH);
    }

    double onMercury() {
        return formatTo2Decimals(onEarth() / MERCURY_MULTIPLIER);
    }

    double onVenus() {
        return formatTo2Decimals(onEarth() / VENUS_MULTIPLIER);
    }

    double onMars() {
        return formatTo2Decimals(onEarth() / MARS_MULTIPLIER);
    }

    double onJupiter() {
        return formatTo2Decimals(onEarth() / JUPITER_MULTIPLIER);
    }

    double onSaturn() {
        return formatTo2Decimals(onEarth() / SATURN_MULTIPLIER);
    }

    double onUranus() {
        return formatTo2Decimals(onEarth() / URANUS_MULTIPLIER);
    }

    double onNeptune() {
        return formatTo2Decimals(onEarth() / NEPTUNE_MULTIPLIER);
    }

    private double formatTo2Decimals(double num) {
        int round = (int) Math.round(num * 100);
        return round / 100.0;
    }

}
