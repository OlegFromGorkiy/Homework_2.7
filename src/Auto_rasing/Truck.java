package Auto_rasing;

public class Truck extends Transport {

    MassCategory massCategory;
    DriverLicense driverLicense = DriverLicense.C;

    public Truck(String brand, String model, double engineVolume, int maxWeightInKilograms) {
        super(brand, model, engineVolume, DriverLicense.C);
        if (maxWeightInKilograms <= MassCategory.N1.MAX_MASS) massCategory = MassCategory.N1;
        else if (maxWeightInKilograms <= MassCategory.N2.MAX_MASS) massCategory = MassCategory.N2;
        else massCategory = MassCategory.N3;
    }
    public Truck(String brand, String model, double engineVolume, double maxWeightInTons) {
        super(brand, model, engineVolume, DriverLicense.C);
        int maxWeightInKilograms = (int) maxWeightInTons*1000;
        if (maxWeightInKilograms <= MassCategory.N1.MAX_MASS) massCategory = MassCategory.N1;
        else if (maxWeightInKilograms <= MassCategory.N2.MAX_MASS) massCategory = MassCategory.N2;
        else massCategory = MassCategory.N3;
    }

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

    public MassCategory getMassCategory() {
        return massCategory;
    }

    @Override
    public void getType() {
        if (getMassCategory() == null) System.out.println("Класс грузоподъемности неизвестен");
        else System.out.println("Класс грузоподъемности "+getMassCategory().name());
    }
    @Override
    public void diagnostic() {
        int i = (int) (Math.random()*10);
        if (i<=5) throw new RuntimeException("Диагностика не пройдена!");
        System.out.println("Машина прошла диагностику!");
    }

    private enum MassCategory {
        N1(3500),
        N2(12000),
        N3(Integer.MAX_VALUE),
        ;

        private final int MAX_MASS;

        MassCategory(int i) {
            this.MAX_MASS = i;
        }
    }
}
