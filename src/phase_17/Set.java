package phase_17;

import java.util.HashMap;
import java.util.Map;

public class Set<T extends Identifiable> {
    private Map<Integer, T> setContainer = new HashMap<>();

    public Set() {
    }

    public T removeElement(int id) {
        return setContainer.remove(id);
    }
    public int totalSize() {
        return setContainer.size();
    }

    public void displayAll() {
        for (T element : setContainer.values()) {
            System.out.println(element);
        }
    }

    public void addElement(T element) {
        if (!setContainer.containsKey(element.getID())) {
            setContainer.put(element.getID(), element);
        }
    }

    public boolean peek(int id) {
        return setContainer.containsKey(id);
    }



    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        else if (!(o instanceof Set)) {
            return false;
        }
        Set<?> other = (Set<?>) o;
        if (setContainer.size() != other.setContainer.size()) {
            return false;
        }
        for (int id : setContainer.keySet()) {
            if (!other.setContainer.containsKey(id) || !setContainer.get(id).equals(other.setContainer.get(id))) {
                return false;
            }
        }
        return true;
    }


}
