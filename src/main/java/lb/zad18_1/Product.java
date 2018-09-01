package lb.zad18_1;

public class Product {
    private String name;
    private double price;
    private Enum<Category> category;

    public Product(String name, double price, Enum<Category> category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Enum<Category> getCategory() {
        return category;
    }

    public void setCategory(Enum<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name+" "+price+" "+category;
    }

}
