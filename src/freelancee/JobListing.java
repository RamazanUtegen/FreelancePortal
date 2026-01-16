package freelancee;

import java.util.Objects;

public class JobListing {
    private String title;
    private double price;

    public JobListing(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "JobListing{" + "title='" + title + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobListing)) return false;
        JobListing that = (JobListing) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}