import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

    /**
     * 1. Filtro per Elementi Specifici:
     * Scrivi un programma in Java che utilizza lambda e stream per filtrare una
     * lista di stringhe, selezionando solo quelle che iniziano con la lettera 'A' e
     * le stampa a schermo.
     * 
     * 2. Conversione e Mappatura:
     * Dato un elenco di numeri interi, usa lambda e stream per convertire ogni
     * numero nella sua rappresentazione quadrata e crea una nuova lista con questi
     * valori. Stampare la lista risultante.
     * 
     * 3. Ricerca di Elementi:
     * Utilizza lambda e stream per trovare il primo numero pari in una lista di
     * interi. Se esiste, stampa questo numero; altrimenti, stampa un messaggio che
     * dice "Nessun numero pari trovato".
     * 
     * 4. Aggregazione di Valori:
     * Scrivi un programma che utilizza lambda e stream per calcolare la somma degli
     * elementi in una lista di numeri decimali (double). Stampa il risultato.
     * 
     * 5. Ordinamento e Raccolta:
     * Dato un elenco di nomi, usa lambda e stream per ordinarli in ordine
     * alfabetico inverso e poi raccoglili in una nuova lista. Stampa la lista
     * ordinata.
     */
    public static void main(String[] args) throws Exception {

        // filterElements();
        // convertAndMap();
        // searchElement();
        // aggregateValues();
        // sortAndCollect();

        test1();
    }

    public static void filterElements() {

        List<String> strs = Arrays.asList("lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "Adipiscing", "elit",
                "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua", "ut",
                "enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco", "laboris", "nisi", "ut",
                "Aliquip", "ex", "ea", "commodo", "consequat", "duis", "aute", "irure", "dolor", "in", "reprehenderit",
                "in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla", "pariatur",
                "excepteur", "sint", "occaecat", "cupidatat", "non", "proident", "sunt", "in", "culpa", "qui",
                "officia", "deserunt", "mollit", "anim", "id", "est", "laborum");

        strs.stream()
                .filter(s -> s.toLowerCase().startsWith("a"))
                .forEach(System.out::println);
    }

    public static void convertAndMap() {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        nums.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        List<Integer> res = nums.stream()
                .map(v -> v * v)
                .toList();
        // .collect(Collectors.toList());

        res.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");
    }

    public static void searchElement() {

        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9, 11, 2, 13, 15, 17, 19);

        /* Optional<Integer> valueOpt = */
        nums.stream()
                .filter(v -> v % 2 == 0)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println, // v -> System.out.print(v);
                        () -> System.out.println("Nessun numero pari trovato"));

        // if (valueOpt.isPresent()) {
        // int value = valueOpt.get();
        // System.out.println(value);
        // } else {
        // System.out.println("Nessun numero pari trovato");
        // }
    }

    public static void aggregateValues() {

        List<Double> nums = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

        double sum = nums.stream()
                .reduce(0d, (x, y) -> x + y);

        System.out.println(sum);
    }

    public static void sortAndCollect() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Helen", "Ivy",
                "Jack", "Kate", "Liam", "Mia", "Noah", "Olivia", "Peter", "Quinn", "Rose", "Sam", "Tom", "Ursula",
                "Victor", "Wendy", "Xander", "Yvonne", "Zack");

        // List<String> revName = names.stream()
        // .sorted()
        // .toList()
        // .reversed();

        List<String> revName = names.stream()
                .sorted((a, b) -> b.compareTo(a))
                .toList();

        revName.forEach(System.out::println);
    }

    public static void test1() {

        for (int x = 0; x < 100; x++)
            System.out.println(~x);
    }
}
