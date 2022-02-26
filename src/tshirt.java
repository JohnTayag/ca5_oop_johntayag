import java.util.Objects;

public class tshirt implements Comparable <tshirt> {
    private String name;
    int code; // unique identifier for each tshirt instance
    private double price;
    private double size;

    public tshirt(String name, int code, double price, double size) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.size = size;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "tshirt{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tshirt tshirt = (tshirt) o;
        return code == tshirt.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    // Compare based on code within name
    // (Name has priority, and if names are the same then code is used
    @Override
    public int compareTo(tshirt o) {

            boolean SameName =
                    this.getName().equalsIgnoreCase(o.getName());

            if(SameName) // Both names are the same
            {
                //so, compare based on code
                return this.getCode() - o.getCode();
            }

            else //All other cases
            {
                return this.getName().compareToIgnoreCase(
                        o.getName());
            }

    }

}

