
import DTOs.tshirt;

import java.util.Comparator;

public class tshirtCodeComparator
        implements Comparator<tshirt>
{
    private SortType sortType;

    public tshirtCodeComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(tshirt u1, tshirt u2)
    {
        int direction = sortType.getValue();
        return direction * (u1.getCode() - u2.getCode());
    }
}
