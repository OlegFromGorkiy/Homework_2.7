package Auto_rasing;

public class Car extends Transport {
    BodyType bodyType;

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume, DriverLicense.B);
        this.bodyType = bodyType;
    }

    public Car(String brand, String model, double engineVolume, String bodyType) {
        super(brand, model, engineVolume, DriverLicense.B);
        this.bodyType = BodyType.convertBodyType(bodyType);// == null ? BodyType.SEDAN : BodyType.convertBodyType(bodyType);
    }

    public BodyType getBodyType() {
        return bodyType;
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

    @Override
    public void getType() {
        if (getBodyType() == null) System.out.println("Корпус авто неизвестен");
        else System.out.println("корпус авто - " + getBodyType().getName());
    }

    @Override
    public void diagnostic() {
        int i = (int) (Math.random()*10);
        if (i<=5) throw new RuntimeException("Диагностика не пройдена!");
        System.out.println("Машина прошла диагностику!");
    }

    private enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String NAME;

        BodyType(String name) {
            this.NAME = name;
        }

        public String getName() {
            return NAME;
        }

        public static BodyType convertBodyType(String name) {
            for (int i = 0; i < BodyType.values().length; i++) {
                if (BodyType.values()[i].getName().equals(name)) {
                    return BodyType.values()[i];
                }
            }
            return null;
        }


    }
}
