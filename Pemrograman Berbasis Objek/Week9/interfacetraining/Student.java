package interfacetraining;

public class Student implements ICumlaude {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void studyInCampus () {
        System.out.println("I am a student, my name is " + this.name);
        System.out.println("I study in campus");
    }
    
    @Override
    public void graduate() {
        System.out.println("I have finished the thesis for Undergraduated");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3,1");
    }
}
