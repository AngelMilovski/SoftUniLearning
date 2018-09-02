package collection_hierarchy.impl;

import collection_hierarchy.api.Addable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {

    private List<String> list;

    public AddCollection() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.list.add(element);
        return this.list.size() - 1;
    }
}