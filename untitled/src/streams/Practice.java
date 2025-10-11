package streams;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anirudh
 * @since 05/10/25
 */
public class Practice {
    public static void main(String[] args) {
        // Palindrome Filter

        String[] palindrome = {"madam", "racecar", "java", "noon", "python"};
        List<String> list = Arrays.stream(palindrome)
                .filter((String s) -> {
                    String firstHalf = s.substring(0, s.length() / 2);
                    int start = s.length() % 2 != 0 ? (s.length() / 2) + 1 : s.length() / 2;
                    StringBuilder sb = new StringBuilder(s.substring(start));
                    return firstHalf.contentEquals(sb.reverse());
                })
                .toList();

        // or

        Arrays.stream(palindrome).filter((String s) -> new StringBuilder(s).reverse().toString().equals(s))
                .forEach(System.out::println);
        System.out.println(list);


        //Find the first non-repeated character in a string

        System.out.println("swiss".chars()
                .mapToObj((int i) -> (char) i)
                .collect(Collectors.toMap(c -> c, val -> 1L, Long::sum, LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().map(Map.Entry::getKey).orElse('1'));

        //Find all duplicate elements in an array or list

        System.out.println(Stream.of(1, 2, 3, 2, 4, 5, 1)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList());

        //Check if two strings are anagrams
        String s = "listend";
        String s1 = "silent";
        System.out.println(s.length() == s1.length() && s.chars().sorted().boxed().toList().equals(s1.chars()
                .sorted().boxed().toList()
        ));

        //Find the longest word in a list of strings

        System.out.println(Stream.of("java", "stream", "api", "examples")
                .collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1, TreeMap::new))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()
        );

        System.out.println(Stream.of("java", "stream", "api", "examples")
                .max(Comparator.comparingInt(String::length))
                .orElse(""));

        //Find the kth largest element in an array

        System.out.println(Stream.of(10, 20, 4, 45, 99).sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(0));
        //Find words starting with a particular letter
        System.out.println(Stream.of("apple", "banana", "apricot", "grape")
                .filter(k->k.startsWith("a"))
                .toList()
        );


    }
}
