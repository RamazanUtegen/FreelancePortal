package freelancee;

import java.util.Objects;

public class Freelancer extends Person {
    private String skill;

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

    @Override
    public String toString() {
        return "Freelancer{" + "name='" + getName() + '\'' + ", skill='" + skill + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freelancer)) return false;
        Freelancer that = (Freelancer) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), skill);
    }
}