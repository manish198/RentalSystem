package phase_17;

public class Driver {
    public static void main(String[] args) {
        Set<Identifiable> s = new Set<>();

        // Add elements
        s.add(new Identifiable(1));
        s.add(new Identifiable(2));
        s.add(new Identifiable(3));
        s.add(new Identifiable(4));
        s.add(new Identifiable(5));

        // Display elements
        s.display();

        // Remove an element
        Identifiable removedElement = s.remove(3);
        System.out.println("Removed element: " + removedElement);

        // Check if an element is in the set
        System.out.println("Is 2 in the set? " + s.peek(2));
        System.out.println("Is 3 in the set? " + s.peek(3));

        // Display the size of the set
        System.out.println("Size of set: " + s.size());

        // Create another set
        Set<Identifiable> t = new Set<>();
        t.add(new Identifiable(1));
        t.add(new Identifiable(2));
        t.add(new Identifiable(4));

        // Compare two sets for equality
        System.out.println("Are s and t equal? " + s.equals(t));
    }
}