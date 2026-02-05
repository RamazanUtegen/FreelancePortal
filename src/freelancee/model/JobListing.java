package freelancee.model;

public class JobListing {
    private String title;
    private double price;


    private JobListing(Builder builder) {
        this.title = builder.title;
        this.price = builder.price;
    }


    public JobListing() {}

    public String getTitle() { return title; }
    public double getPrice() { return price; }


    public static class Builder {
        private String title;
        private double price;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public JobListing build() {
            return new JobListing(this);
        }
    }
}