import Auto_rasing.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Transport> cars = new ArrayList<>();
        cars.add(new Car("VW", "Tiguan", 2.0, "Внедорожник"));
        cars.add(new Truck("MAN", "BigMAN", 12.0, 40000));

        Mechanic ivan = new Mechanic("Ivan", "Ivanov", "Maz");
        ivan.setSkill(DriverLicense.C);
        Mechanic fabio = new Mechanic("Fabio", "Gamboni", "Lamborghini");
        fabio.setSkill(DriverLicense.B);
        Mechanic elon = new Mechanic("Elon", "Mask", "SpaseX");
        for (DriverLicense dl : DriverLicense.values()) {
            elon.setSkill(dl);
        }
        List<Mechanic> mechanics = new ArrayList<>();
        mechanics.add(ivan);
        mechanics.add(fabio);
        mechanics.add(elon);

        List<Driver> drivers = new LinkedList<>();
        drivers.add(new Driver("Vasiliy", DriverLicense.B, 10));
        drivers.add(new Driver("Michael", DriverLicense.C, 25));

        List<Sponsor> sponsors = new LinkedList<>();
        sponsors.add(new Sponsor("VTB", 100_000));
        sponsors.add(new Sponsor("Igor Kvasha", 1000));

        for (Transport t : cars) {
            for (Driver d : drivers) {
                if (t.setDriver(d)) break;
            }
            for (Mechanic m : mechanics) {
                t.addMechanic(m);
            }
            for (Sponsor s : sponsors) {
                t.addSponsor(s);
            }
            t.getInfo();
            System.out.println("***");
        }
        System.out.println("***");
        SuperMarket superMarket = new SuperMarket();
        for (int i = 0; i < 15; i++) {
            superMarket.work(superMarket.generateName());
        }
    }
}