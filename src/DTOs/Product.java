package DTOs;

import java.util.Objects;

    public class Product implements Comparable <Product>
    {

    private int ID; // unique identifier for each DTOs.Product instance
    private String name;
    private double price;
    private double size;

    public Product(String name, int id, double price, double size) {
        this.name = name;
        this.ID = id;
        this.price = price;
        this.size = size;
    }

    public Product(String name, double price, double size) {
            this.ID = 0;
            this.name = name;
            this.price = price;
            this.size = size;
        }

    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DTOs.Product{" +
                "name='" + name + '\'' +
                ", code=" + ID +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product Product = (Product) o;
        return ID == Product.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    // Compare based on code within name
    // (Name has priority, and if names are the same then code is used
        //FIX
    @Override
    public int compareTo(Product o) {

            boolean SameName =
                    this.getName().equalsIgnoreCase(o.getName());

            if(SameName) // Both names are the same
            {
                //so, compare based on code
                return this.getID() - o.getID();
            }

            else //All other cases
            {
                return this.getName().compareToIgnoreCase(
                        o.getName());
            }

    }

}

