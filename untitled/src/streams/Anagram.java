package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Anirudh
 * @since 29/09/25
 */
class Employee {
    int id;
    String name;
    String dept;
    long salary;

    public Employee(int id, String name, String dept, long salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Anagram {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = Arrays.stream(arr).collect(Collectors.groupingBy(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        })).values().stream().toList();
        System.out.println(list);

        //sum of two num using stream api

        int a = 2;
        int b = 3;
        int sum = IntStream.of(a, b).sum();
        System.out.println(sum);


        //longest string

        String[] strings = {"java", "python", "go", "javascript"};
        String last = Arrays.stream(strings).sorted(Comparator.comparingInt(String::length)).toList().getLast();
        String last1 = Arrays.stream(strings)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(last);


        //frequency map

        String[] fruits = {"apple", "banana", "apple", "cat", "banana", "apple"};

        Map<String, Long> collect = Arrays.stream(fruits).collect(Collectors.toMap(word -> word, word -> 1L, Long::sum));

        Map<String, Long> freqMap = Arrays.stream(fruits).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // sum of squares

        int[] nums = {1, 2, 3, 4};

        int reduce = Arrays.stream(nums).map(num -> num * num).reduce(0, Integer::sum);
        System.out.println(reduce);

        // top three freq num

        List<String> list1 = List.of("java", "python", "java", "c", "java", "python", "go");
        list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue(Collections.reverseOrder())).limit(3).forEach(System.out::println);

        // group by length

        List<String> a1 = List.of("a", "bb", "ccc", "dd", "ee", "ffff");
        Map<Integer, List<String>> collect1 = a1.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect1);
        // partition even odd

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(integers.stream().collect(Collectors.groupingBy(num -> num % 2 == 0)));

        //find duplicate elements

        Stream.of(1, 2, 2, 3, 4, 4, 5, 6, 6).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);

        // Employee salary problem

        Stream.of(new Employee(1, "Alice", "IT", 6000),
                new Employee(2, "Bob", "HR", 4000),
                new Employee(3, "Charlie", "IT", 7000),
                new Employee(4, "David", "Finance", 5000),
                new Employee(5, "Eva", "Finance", 8000))
                .collect(Collectors.groupingBy(Employee::getDept))
                .forEach((dept, empList) -> {
                    empList.stream()
                            .max(Comparator.comparingLong(Employee::getSalary))
                            .ifPresent(e -> System.out.println(dept + " : " + e.getSalary()));
                });

        // Top N Salaries (per Department)

        Stream.of(new Employee(1, "Alice", "IT", 6000),
                        new Employee(2, "Bob", "HR", 4000),
                        new Employee(3, "Charlie", "IT", 7000),
                        new Employee(4, "David", "Finance", 5000),
                        new Employee(5, "Eva", "Finance", 8000))
                .collect(Collectors.groupingBy(Employee::getDept))
                .forEach((dept, empList) -> {
                    List<Employee> collect2 = empList.stream()
                            .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                            .limit(2).collect(Collectors.toList());
                    System.out.println(collect2);
                });

        //Second Highest Number

        System.out.println(Stream.of(5, 1, 2, 9, 7).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        // Character Frequency

        System.out.println("banana".chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
    }
}
