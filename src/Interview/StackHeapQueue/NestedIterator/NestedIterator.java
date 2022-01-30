package Interview.StackHeapQueue.NestedIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int temp = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger i:nestedList){
            if (i.isInteger()){
                list.add(i.getInteger());
            }else {
                addList(i.getList());
            }
        }
    }

    public void addList(List<NestedInteger> nestedList){
        for (NestedInteger i:nestedList){
            if (i.isInteger()){
                list.add(i.getInteger());
            }else {
                addList(i.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (list.size()-1>=temp){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Integer next() {
        int res = list.get(temp);
        temp++;
        return res;
    }
}
