package Auto_rasing;

import java.util.LinkedList;
import java.util.List;

public class Mechanic {
    private String firstName;
    private String lastName;
    private String company;
    List<DriverLicense> skillList;

    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        skillList = new LinkedList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public void fixTransport(Transport t) {
        System.out.println("Transport class " + t.getClass().getSimpleName() + " was fixing");
    }

    public void doMaintenance(Transport t) {
        System.out.println("Transport class " + t.getClass().getSimpleName() + " was serviced");
    }

    public void setSkill(DriverLicense dl) {
        if (skillList.contains(dl)) return;
        skillList.add(dl);
    }

    public void removeSkill(DriverLicense dl) {
        skillList.remove(dl);
    }

    public boolean canWork(Transport t) {
        return skillList.contains(t.getDriverLicense());
    }
}
