package freelancee.model;

public class Freelancer extends Person {
    private String skill;


    public Freelancer() {
        super(); // Вызывает пустой конструктор Person
    }


    public Freelancer(String name, String skill) {
        super(name);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}