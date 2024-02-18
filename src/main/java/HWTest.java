import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HWTest {
    public static void main(String[] args) {
        List<String> listName = Arrays.asList("Ivan", "Peter", "Tomas", "Rubi", "Karl", "Martin",
                "Dirk", "Laslo", "Viktor", "Lasse");

        List<String> first = Arrays.asList("a", "b", "c", "d");
        List<String> second = Arrays.asList("A", "B", "C");

        String[] array = {"1, 5, 9", "4, 2, 0"};


        // Exercise 1;
        //nameCheckEx1(listName, count -> count % 2 != 0);

        // Exercise 2; two methods: one with stream, second with functional interface;
        //sortToUpperCaseEx2(listName);
        //sortToUpperWithFunctionalEx2(listName, names -> names.sort(Comparator.naturalOrder()));

        //Exercise 3;
        //getNumbersEx3(array);

        //Exercise 4;
        //getIterateEx4(25214903917L, 11L, (long) Math.pow(2,48));


        //Exercise 5;
        //zipEx5(first.stream(), second.stream());


    }

    public static String nameCheckEx1(List<String> name, CheckIndex functional) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = null;
        int count = 1;

        for (String endname : name
        ) {
            if (functional.chekName(count)) {
                stringBuilder.append(count + ".");
                stringBuilder.append(" " + endname);
                if (count != name.size() && count != name.size() - 1) {
                    stringBuilder.append(", ");
                }

            }
            count++;
        }
        System.out.println(stringBuilder.toString());
        return result = stringBuilder.toString();
    }

    public static String nameCheckWithStreamEx1(List<String> name){
        List<String> intStream =  IntStream
                .range(0, name.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(i -> + i+1 + ". " + name.get(i))
                .collect(Collectors.toList());
        String result = String.join(", ", intStream);
        return result;
    }

    public static List<String> sortToUpperCaseEx2(List<String> names) {
        final List<String> sortedName = names.stream()
                .sorted(Comparator.reverseOrder())
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(sortedName);
        return sortedName;
    }

    public static List<String> sortToUpperWithFunctionalEx2(List<String> names, CompareTo vergleichen) {
        List<String> result = new ArrayList<>();
        vergleichen.compare(names);
        for (String name : names
        ) {
            result.add(name.toUpperCase());
        }
        System.out.println(result);
        return result;
    }


    public static <T> List<T> getNumbersEx3(T[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T str : array
        ) {
            stringBuilder.append(str + ",");
        }
        String result = stringBuilder.toString();

        String[] resultArray = result.split(",");

        List<String> list = Arrays.asList(resultArray);


        final List<Integer> collect = list.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(collect);
        return (List<T>) collect;
    }


    public static Stream<Long> getIterateEx4(long a, long c, long m) {

        long x = 0;
        final Stream<Long> iterate = Stream.iterate(x, x1 -> (a * x1 + c) % m);
        iterate.limit(20)
                .forEach(System.out::println);
        return iterate;
    }

    public static <T> Stream<T> zipEx5(Stream<T> first, Stream<T> second) {
        List<T> list1 = (List<T>) first.toList();
        List<T> list2 = (List<T>) second.toList();
        List<T> listResult = new ArrayList<>();
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            listResult.add(list1.get(i));
            listResult.add(list2.get(i));
        }
        Stream<T> result = listResult.stream();
        System.out.println(Arrays.toString(result.toArray()));
        return result;

    }


}
