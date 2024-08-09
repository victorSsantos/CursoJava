package generics.services;

import java.util.List;

public class CalculationService {

    public static <T extends Comparable<T>> T max (List<T> list){

        if(list.isEmpty())
            throw new IllegalArgumentException("List can't be empty!!");

        T max = list.getFirst();
        for(T item:list){
            if(item.compareTo(max) > 0)
                max = item;
        }
        return max;
    }
}
