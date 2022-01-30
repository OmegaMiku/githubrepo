import java.util.*;

public class HomeWork4 {
    public static void main(String[] args) {
        String[] words = {"Cat", "Dog", "Mouse", "Dog", "Tiger", "Cat", "Hyppo", "Bear", "Elephant", "Bear"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

        System.out.println(map.keySet());

        System.out.println();
        PhoneBook pb = new PhoneBook();

        pb.add("Ivanov", "+79266026969");
        pb.add("Sokolov", "+79267653456");
        pb.add("Petrov", "+79255673425");
        pb.add("Pavlov", "+79296579812");
        pb.add("Komarov", "+79053421295");
        pb.add("Ivanov", "+79297613464");

        String lastName = "Ivanov";
        System.out.println(pb.get(lastName));
    }
}

class PhoneBook {
    private Map<String, HashSet<String>> map;

    PhoneBook() {
        this.map = new HashMap<>();
    }

    void add(String lastName, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(lastName)) {
            numbers = map.get(lastName);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(lastName, numbers);
    }

    Set<String> get(String lastName) {
        System.out.println(lastName);
        return map.get(lastName);
    }
}