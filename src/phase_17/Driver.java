package phase_17;

public class Driver {
    public static void main(String[] args) {
        Set<Identifiable> set = new Set<>();
        set.addElement(new Identifiable(12));
        set.addElement(new Identifiable(22));
        set.addElement(new Identifiable(663));
        set.addElement(new Identifiable(422));
        set.displayAll();
        System.out.println("Size: " + set.totalSize());
        System.out.println("Is 663 in the set? " + set.peek(663));
        Identifiable removedElement = set.removeElement(422);
        System.out.println("Removed: " + removedElement);
        System.out.println("Size: " + set.totalSize());

        Set<Identifiable> secondSet = new Set<>();
        secondSet.addElement(new Identifiable(12));
        secondSet.addElement(new Identifiable(22));
        secondSet.addElement(new Identifiable(663));
        System.out.println("Are both sets equal? " + set.equals(secondSet));
    }
}