import DTOs.Product;

import java.util.Comparator;

public class tshirtCodeComparator
        implements Comparator<Product>
{
    private SortType sortType;

    public tshirtCodeComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(Product u1, Product u2)
    {
        int direction = sortType.getValue();
        return direction * (u1.getID() - u2.getID());
    }
}
