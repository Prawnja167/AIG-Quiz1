import java.util.Vector;

public class PermutationCombination {
    Vector<String> persons = new Vector<>();
    Vector<Vector<String>> personCombination = new Vector<>();
    Vector<Vector<String>> personPermutation = new Vector<>();

    public void doCombination(int n, Vector<String> person) {
        if (n == person.size()) {
            personCombination.add(person);
            return;
        }

        for (int i=0; i<person.size(); i++) {
            Vector<String> newPerson = new Vector<>(person);
            newPerson.remove(person.get(i));
            doCombination(n, newPerson);
        }

    }

    public void doPermutation(int n, Vector<String> person, Vector<String> curr) {
        if (n==curr.size()) {
            personPermutation.add(curr);
            return;
        }

        for (int i=0; i<person.size(); i++) {
            Vector<String> newPerson = new Vector<>(person);
            Vector<String> newCurr = new Vector<>(curr);
            newPerson.remove(person.get(i));
            newCurr.add(person.get(i));
            doPermutation(n, newPerson, newCurr);
        }

    }

    public PermutationCombination() {
        persons.add("1");
        persons.add("2");
        persons.add("3");
        persons.add("4");

        doCombination(3, persons);
        System.out.println("Combination");
        for (Vector<String> vector : personCombination) {
            for (String string : vector) {
                System.out.print(string+" ");
            }
            System.out.println();
        }

        System.out.println();

        doPermutation(3, persons, new Vector<String>());
        System.out.println("Permutation");
        for (Vector<String> vector : personPermutation) {
            for (String string : vector) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}
