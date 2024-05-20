import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Consumer<T> example
        // Accepts arguments, doesn't return results
        numbers.forEach(n -> {
            if(n % 2 == 0) {
                System.out.println(n);
            }
        });

        // Supplier<T> example
        // Doesn't accept arguments, return results
        List<String> greetingList = Stream.generate(() -> "Oi").limit(5).toList();
        // omg Method Reference hii!!
        greetingList.forEach(System.out::println);

        // Function<T, R> example
        // Accepts argument of type T, return results of type R
        List<Integer> doubledNumbers = numbers.stream().map(n -> n * 2).toList();
        doubledNumbers.forEach(System.out::println);

        // Predicate<T> example
        // Accepts arguments of type T, returns boolean
        numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

        // BinaryOperator<T> example
        // Accepts two arguments of type T and returns one of the same type
        // int sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        // Simplified version with method reference below
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}