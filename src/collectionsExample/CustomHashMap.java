package collectionsExample;

import java.util.LinkedList;
import java.util.List;

public class CustomHashMap {
    //    float loadFactor = 0.75f;
    int capacity = 16;
    List<Entry>[] backedArray;

    CustomHashMap() {
        backedArray = new LinkedList[capacity];
    }

    CustomHashMap(int capacity) {
        this.capacity = capacity;
        backedArray = new LinkedList[capacity];
    }

    static class Entry {
        String key;
        Object value;

        public Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public Object get(String key) {
        int index = getIndexFor(key);

        List<Entry> list = backedArray[index];
        if (list != null) {
            for (Entry e : list) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public boolean put(String key, Object value) {
        int index = getIndexFor(key);

        List<Entry> list = backedArray[index];

        if (list == null || list.isEmpty()) {
            list = new LinkedList<>();
            list.add(new Entry(key, value));
        } else {
            boolean objFound = false;
            for (Entry e : list) {
                if (e.key.equals(key)) {
                    e.value = value;
                    objFound = true;
                    break;
                }
            }
            if (!objFound)
                list.add(new Entry(key, value));
        }
        backedArray[index] = list;
        return true;
    }

//    public int size(){
//        return back
//    }

    private int getIndexFor(String key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = key.hashCode();
        }

        return hash % capacity;
    }

    public static void main(String[] args) {
        CustomHashMap c = new CustomHashMap();
        c.put("Divya", 1);
        c.put("Gupta", 2);
        c.put("Gupta", 3);

        System.out.println(c.get("Divya"));
        System.out.println(c.get("Gupta"));
    }

}
