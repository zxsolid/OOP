package HomeWork1.Task2_3;

import java.util.Comparator;

public class FromNameComp implements Comparator<BaseCreature> {

    @Override
    public int compare(BaseCreature o1, BaseCreature o2) {
        return o1.getName().compareTo(o2.getName());
    }
}