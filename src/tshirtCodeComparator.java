import java.util.Comparator;
public class tshirtCodeComparator implements Comparator<tshirt> {
    @Override
    public int compare(tshirt o1, tshirt o2) {
        return o1.getCode();
    }
}
