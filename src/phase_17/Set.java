package phase_17;

import java.util.HashMap;
import java.util.Map;

public class Set<T extends Identifiable> {
    private Map<Integer, T> elements;

    public Set() {
        elements = new HashMap<>();
    }

    public void add(T element) {
        if (!elements.containsKey(element.getID())) {
            elements.put(element.getID(), element);
        }
    }

    public T remove(int id) {
        return elements.remove(id);
    }

    public boolean peek(int id) {
        return elements.containsKey(id);
    }

    public int size() {
        return elements.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Set)) return false;
        Set<?> other = (Set<?>) o;
        if (elements.size() != other.elements.size()) return false;
        for (int id : elements.keySet()) {
            if (!other.elements.containsKey(id) || !elements.get(id).equals(other.elements.get(id))) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (T element : elements.values()) {
            System.out.println(element);
        }
    }
}
