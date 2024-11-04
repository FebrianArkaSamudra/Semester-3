package interfacetraining;

public class Undergraduated  implements ICumlaude,IAchievers {
    private String name;

    public Undergraduated(String name) {
        this.name = name;
    }   

    @Override
    public void graduate() {
        System.out.println("I have finished the thesis for Undergraduated");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3,51");
    }

    @Override
    public void winTheCompetition() {
        System.out.println("I have won an INTERNATIONAL competition");
    }

    @Override
    public void publishTheJournal() {
        System.out.println("I publish articles in INTERNATIONAL journals");
    }
}
