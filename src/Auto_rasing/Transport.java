package Auto_rasing;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Transport implements Competetable {
    private String brand;
    private String model;
    private double engineVolume;
    private DriverLicense driverLicense;
    private Driver driver;
    private List<Sponsor> sponsors;
    private List<Mechanic> mechanics;

    public Transport(String brand, String model, double engineVolume, DriverLicense driverLicense) {
        this.brand = check(brand);
        this.model = check(model);
        this.engineVolume = check(engineVolume);
        this.driverLicense = driverLicense;
        sponsors = new ArrayList<>();
        mechanics = new LinkedList<>();
    }

    public String check(String str) {
        if (str == null) str = "";
        if (str.matches("^\\s+$") || str.length() == 0) return "default";
        else return str;
    }

    public double check(double d) {
        return Math.abs(d);
    }

    public void start() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stopped");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = check(brand);
    }

    //   public void setDriverLicense(DriverLicense driverLicense) {this.driverLicense = driverLicense; }

    public Driver getDriver() {
        return driver;
    }

    public boolean setDriver(Driver driver) {
        if (driver.canDrive(this)) {
            this.driver = driver;
            return true;
        } else {
            System.out.println("This driver can't drive this transport type!");
            return false;
        }
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void addSponsor(Sponsor sponsor) {
        sponsors.add(sponsor);
    }

    public void removeSponsor(Sponsor sponsor) {
        if (!sponsors.contains(sponsor)) {
            System.out.println("This sponsor already removed!");
            return;
        }
        while (sponsors.contains(sponsor)) {
            sponsors.remove(sponsor);
        }
    }

    public void removeSponsor(int index) {
        if (index < sponsors.size() && index >= 0) {
            sponsors.remove(index);
        } else throw new IndexOutOfBoundsException("Bad index for list of sponsors!");
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void addMechanic(Mechanic m) {
        if (m.canWork(this)) {
            mechanics.add(m);
            //return true;
        } else {
            System.out.println(String.format("%s %s can't add with this transport type!",
                    m.getFirstName(), m.getLastName()));
            // return false;
        }
    }

    public void getInfo() {
        System.out.println(this.toString() + " info:");
        System.out.println("Driver: " + driver.getName());
        System.out.println("Mechanics:");
        for (Mechanic m : mechanics) {
            System.out.printf("%s %s from %s.%n", m.getFirstName(), m.getLastName(), m.getCompany());
        }
        System.out.println("Sponsors:");
        for (Sponsor s : sponsors) {
            System.out.println(s.getName());
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = check(brand);
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = check(engineVolume);
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel();
    }

    public abstract void getType();

    public abstract void diagnostic();
}
