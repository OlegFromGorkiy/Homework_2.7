package Auto_rasing;

public class Bus extends Transport {
    BusCapacity busCapacity;
    DriverLicense driverLicense = DriverLicense.D;

    public Bus(String brand, String model, double engineVolume, int numberOfPassengers) {
        super(brand, model, engineVolume, DriverLicense.D);
        if (numberOfPassengers <= BusCapacity.EXTRA_SMALL.MAX_CAPACITY) busCapacity = BusCapacity.EXTRA_SMALL;
        else if (numberOfPassengers <= BusCapacity.SMALL.MAX_CAPACITY) busCapacity = BusCapacity.SMALL;
        else if (numberOfPassengers <= BusCapacity.MEDIUM.MAX_CAPACITY) busCapacity = BusCapacity.MEDIUM;
        else if (numberOfPassengers <= BusCapacity.LARGE.MAX_CAPACITY) busCapacity = BusCapacity.LARGE;
        else busCapacity = BusCapacity.EXTRA_LARGE;
    }

    @Override
    public void pitStop() {
        System.out.println(this.toString() + " pulled into a pit stop");
    }

    @Override
    public void bestTime() {
        System.out.println(this.toString() + " showed the best lap time");
    }

    @Override
    public void maxSpeed() {
        System.out.println(this.toString() + " showed the max speed jn this lap");
    }

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    @Override
    public void getType() {
        if (getBusCapacity() == null) System.out.println("Класс автобуса неизвестен");
        else System.out.println("Класс автобуса - " + getBusCapacity().name());
    }
    @Override
    public void diagnostic() {
        System.out.println("Автобусам диагностика не требуется!");
    }

    private enum BusCapacity {
        EXTRA_SMALL(10),
        SMALL(25),
        MEDIUM(60),
        LARGE(80),
        EXTRA_LARGE(Integer.MAX_VALUE);

        private final int MAX_CAPACITY;

        BusCapacity(int i) {
            MAX_CAPACITY = i;
        }
    }

}
