package phase_17;

public class Identifiable {
    private int id;

    public Identifiable(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Identifiable)) return false;
        Identifiable other = (Identifiable) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Identifiable(" + id + ")";
    }
}
