package Auto_rasing;

public class Sponsor {
    private String name;
    private int budget;

    public Sponsor(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void toSponsor(){
        System.out.println(this.name + " sponsored this race for " + this.budget +"$!");
    }
}
