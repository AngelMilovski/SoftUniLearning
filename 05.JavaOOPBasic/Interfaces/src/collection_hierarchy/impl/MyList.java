package collection_hierarchy.impl;

import collection_hierarchy.api.Removable;

import java.util.ArrayList;
import java.util.List;

public class MyList implements Removable {

    private List<String> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public int used() {
        return this.list.size();
    }

    @Override
    public int add(String element) {
        this.list.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.list.remove(0);
    }
}