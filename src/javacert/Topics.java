package javacert;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Topics {
    public static void main(String[] args) throws IOException {
        stringLogic();
        arrayLogic();
        instanceOfLogic();
        queueLogic();
        varTests();
        varArgsTests();
        lambdaTests();
        streamTests();
        ioTests();
    }

    private final void privatePlusFinal() {}
    private static void privatePlusStatic() {}

    private static void stringLogic() {
        String s1 = "a";
        String s2 = "abcabc";
        String s3 = new String("a");
        String name = "JavaConceptOfTheDay".substring(4);


        System.out.println(s1 == s3); //
        //System.out.println(s1 == new StringBuilder(s1)); // Does not compile. reference equality doesn't allow different types
        System.out.println(s1 == s3.intern()); //
        System.out.println(s1.equals(s3));
        System.out.println(s2.startsWith(s1));
        System.out.println(s2.replace("a", "A"));
        System.out.println(s2.replace("bc", "BC"));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s3.intern()));
    }

    public static void arrayLogic() {
        int[] arr1 = new int[]{1,1,1};
        int[] arr2 = new int[]{1,2,3};

        // Array comparison
        System.out.println(arr1.equals(arr2));           // bad! reference equality. Inherited Object.equals()
        System.out.println(Arrays.equals(arr1, arr2));   // good
        System.out.println(Arrays.compare(arr1, arr2));  // utility
        System.out.println(Arrays.mismatch(arr1, arr2)); // utility
    }

    public static void queueLogic() {
        // 6 queue methods
        // .add
        // .element
        // .remove

        // .offer
        // .peek
        // .poll

        Queue<Integer> ll = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>();
    }

    private static void instanceOfLogic() {
        class Employee {}
        class Boss extends Employee {}

        Employee employeeObj = new Employee();
        Boss bossObj = new Boss();
        Employee empRefBossObj = bossObj;

        System.out.println(bossObj == empRefBossObj);  //  == allows different types, since types are related

        System.out.println("===== Employee tests======");
        System.out.println(employeeObj instanceof Employee); // true
        System.out.println(employeeObj instanceof Boss);     // false
        // System.out.println(employeeObj instanceof String);     // compiler error, unrelated types
        System.out.println(bossObj instanceof Employee);     // true
        System.out.println(bossObj instanceof Boss);         // true
        System.out.println(empRefBossObj instanceof Employee); // true
        System.out.println(empRefBossObj instanceof Boss);   // true

        System.out.println("===== null tests======");
        System.out.println(null instanceof Employee);   // false
        System.out.println(null instanceof Object);     // false
        // System.out.println(employeeObj instanceof Number);   // java: incompatible types: Employee cannot be converted to java.lang.Number

        System.out.println("===== Object tests======");
        System.out.println(employeeObj instanceof Object);     // true for all objects


        System.out.println("===== array tests======");
        System.out.println(new int[]{} instanceof int[]);
        // System.out.println(new int[]{} instanceof Number[]);  // compiler error, unrelated types
        System.out.println(new Integer[]{} instanceof Number[]);
    }

    private static void varTests() throws IOException {
        // class var {} // var is a reserved type(not a keyword), thus can't be used as Class name
        var var = "";
        var = null; // var can be assigned to a raw/naked null after initialized to a non-null type.

        var arr = new int[]{1,2,3};
        // var[] arr = new int[]{1,2,3}; // compiler error

        for (var c : "bob".toCharArray()) {}
        try (var in = new BufferedReader(new FileReader(new File("/Downloads")))) {}
    }

    private static void varArgsTests() {
        // five ways of passing varargs
        varArgMethod();
        varArgMethod(null);
        varArgMethod("bob");
        varArgMethod("a","b","c");
        varArgMethod(new String[]{"a","b","c"});
    }

    private static void varArgMethod(String... str) {}

    private static void lambdaTests() {
        // Core Functional Interfaces
        Predicate<Integer> isEven = e -> e % 2 == 0;                           // isEven.test(3);
        Function<Double, Long> round = Math::round;                            // round.apply(1.7d);
        Function<Long, Long> identity = Function.identity();
        round.andThen(identity);

        Supplier<Double> randomValues = Math::random;                          // randomValues.get();
        Consumer<String> printLine = System.out::println;                      // printLine.accept("Hello World!");
        Comparator<String> lengthComp = Comparator.comparing(String::length);  // new PriorityQueue<>(lengthComp);

        UnaryOperator<Integer> plusOne = a -> a + 1;            // new ArrayList<Integer>(List.of(1,2,3)).replaceAll(plusOne);
        Function<Integer, Integer> plusTwo  =  plusOne.andThen(plusOne);
        BinaryOperator<Integer> sum = Integer::sum;             // Stream.<Integer>empty().reduce(sum);
        // Concurrent Functional Interfaces
        Runnable runnable = () -> {};                           // new Thread(runnable).start();
        Callable<Integer> callable = () -> 5;                   // new ScheduledThreadPoolExecutor(3).submit(callable);

        ObjIntConsumer<String> con = (String s, int e) -> System.out.println(s + e);
        ToLongFunction<String> lon = String::length; // upcasted from int to long
        DoubleSupplier ran = Math::random; // boxed from double to Double
        Supplier<Double> ran2 = Math::random; // DoubleSupplier and Supplier<Double> are (almost?) always the same. Boxing handled.


    }

    private static void streamTests() {
        // 11 Terminal
        // .findFirst()
        // .findAny()
        // .min()
        // .max()
        // .count() - returns long
        // .allMatch()
        // .anyMatch()
        // .noneMatch()
        // .forEach()
        // .reduce()
        // .collect()

        // 8 Intermediate
        // .sorted()
        // .distinct()
        // .filter()
        // .map()
        // .flatMap()
        // .limit()
        // .skip()
        // .peek()

        // IntStream -> Stream<Integer>
        Stream<Integer> streamI = IntStream.rangeClosed(0, 10).boxed();
        Stream<Integer> streamI2 = IntStream.rangeClosed(0, 10).mapToObj(Integer::valueOf);

        // Stream<Integer> -> IntStream
        IntStream iStream = Stream.of(1,2,3).mapToInt(x -> x);

        // Optional
        ////// three Optional Constructors
        Optional<Integer> oI = Optional.of(1);
        Optional<Integer> oI2 = Optional.ofNullable(null);
        Optional<Integer> oI3 = Optional.empty();


        ///// Optional Methods
        oI.get();
        oI.orElse(2);
        oI.orElseGet(() -> 3);
        oI.orElseThrow(IllegalStateException::new);
        oI.isPresent();
        oI.ifPresent(System.out::println);

        // partition
    }

    public static void ioTests() throws IOException {
        // copy file
        try (var in = new BufferedReader(new FileReader(new File("")));
             var out = new BufferedWriter(new FileWriter(new File("")))) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
        }
    }
}