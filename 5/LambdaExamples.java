import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

// Функциональные интерфейсы
@FunctionalInterface
interface Operation {
    int calculate(int x, int y);
}

interface CheckPerson {
    boolean test(Person p);
}

interface Predicate<Person> {
    boolean test(Person t);
}

// Класс Person для примеров
class Person {
    public enum Sex { MALE, FEMALE }
    private int age;
    private Sex gender;
    
    public Person(int age, Sex gender) {
        this.age = age;
        this.gender = gender;
    }
    
    public int getAge() { return age; }
    public Sex getGender() { return gender; }
    public void printPerson() { 
        System.out.println("Person: age=" + age + ", gender=" + gender); 
    }
}

// Основной класс с примерами
public class LambdaExamples {
    
    // Supplier пример
    public static void supplierExample() {
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
    }
    
    // Calculator класс
    static class Calculator {
        interface IntegerMath {
            int operation(int a, int b);
        }
        
        public int operateBinary(int a, int b, IntegerMath op) {
            return op.operation(a, b);
        }
        
        public static void calculatorExample() {
            Calculator myApp = new Calculator();
            IntegerMath addition = (a, b) -> a + b;
            IntegerMath subtraction = (a, b) -> a - b;
            
            System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
            System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
        }
    }
    
    // Operation пример
    public static void operationExample() {
        Operation sum = (a, b) -> a + b;
        Operation sub = (a, b) -> a - b;
        System.out.println("5 + 3 = " + sum.calculate(5, 3));
        System.out.println("5 - 3 = " + sub.calculate(5, 3));
    }
    
    // Person filtering методы
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    // Consumer и Stream примеры
    public static void consumerAndStreamExamples() {
        // Consumer пример
        String str = "as a- the-d -on and";
        String regex = "-";
        Consumer<String> consumer = s -> System.out.println(Arrays.toString(s.split(regex)));
        consumer.accept(str);
        
        // Supplier примеры
        Supplier<StringBuilder> supplier = () -> new StringBuilder("java");
        StringBuilder builder = supplier.get();
        System.out.println("StringBuilder: " + builder);
        
        Supplier<int[]> supplier2 = () -> new int[10];
        int[] arr = supplier2.get();
        System.out.println("Массив длиной: " + arr.length);
        
        // Stream пример
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // перебором
        System.out.println("Четные числа (for-each):");
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
        
        // через поток
        System.out.println("Четные числа (stream):");
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .forEach(x -> System.out.println(x));
        
        // String mapping пример
        String[] arrayStr = {"hello", "world", "java"};
        System.out.println("Длины строк:");
        System.out.println(Arrays.stream(arrayStr)
            .map(s -> s.length())
            .collect(Collectors.toList()));
        
        // Character codes пример
        List<String> strings = List.of("as a the d on and".split("\\s+"));
        List<Integer> listCode = strings.stream()
            .collect(Collectors.mapping(
                s -> (int) s.charAt(0),
                Collectors.toList()
            ));
        System.out.println("Коды символов: " + listCode);
    }
    
    // Switch expression пример
    public static int defineLevel(String role) {
        return switch (role) {
            case "guest" -> 0;
            case "client" -> 1;
            case "moderator" -> 2;
            case "admin" -> 3;
            default -> {
                System.out.println("non-authentic role = " + role);
                yield -1;
            }
        };
    }
    
    // Effectively final примеры
    public static void effectivelyFinalExamples() {
        // Пример 1 - ошибка (закомментирован)
        /*
        int x = 5;
        Runnable r = () -> System.out.println(x);
        function(r);
        x = 6; // ошибка компиляции
        */
        
        // Пример 2 - рабочий
        int x = 5;
        Runnable r = createRunnable(x);
        x = 6; // теперь разрешено
        r.run(); // выведет 5
    }
    
    public static Runnable createRunnable(int value) {
        return () -> System.out.println("Значение: " + value);
    }
    
    public static void function(Runnable f) {
        f.run();
    }
    
    // Counter классы
    static class Counter {
        public void increment() {
            int localCount = 0;
            Runnable r = () -> {
                System.out.println(localCount); // можно читать
            };
            r.run();
        }
    }
    
    static class Counter2 {
        private int count = 0;
        
        public void increment() {
            Runnable r = () -> {
                count++;
                System.out.println("Текущее значение счётчика: " + count);
            };
            r.run();
        }
        
        public int getCount() {
            return count;
        }
    }
    
    // Currying пример
    static class Curr {
        public static int multiplyNumbers(int firstNum, int secondNum, int thirdNum) {
            return firstNum * secondNum * thirdNum;
        }
        
        public static Function<Integer, Function<Integer, Function<Integer, Integer>>> curry() {
            return f -> (s -> (t -> multiplyNumbers(f, s, t)));
        }
    }
    
    // Главный метод
    public static void main(String[] args) {
        System.out.println("=== Supplier Example ===");
        supplierExample();
        
        System.out.println("\n=== Calculator Example ===");
        Calculator.calculatorExample();
        
        System.out.println("\n=== Operation Example ===");
        operationExample();
        
        System.out.println("\n=== Consumer and Stream Examples ===");
        consumerAndStreamExamples();
        
        System.out.println("\n=== Switch Expression ===");
        System.out.println("Уровень 'admin': " + defineLevel("admin"));
        System.out.println("Уровень 'unknown': " + defineLevel("unknown"));
        
        System.out.println("\n=== Effectively Final Examples ===");
        effectivelyFinalExamples();
        
        System.out.println("\n=== Counter Examples ===");
        Counter counter = new Counter();
        counter.increment();
        
        Counter2 counter2 = new Counter2();
        counter2.increment();
        counter2.increment();
        counter2.increment();
        System.out.println("Финальное значение счётчика: " + counter2.getCount());
        
        System.out.println("\n=== Currying Example ===");
        Integer result = Curr.multiplyNumbers(1, 2, 3);
        System.out.println("Обычный метод: " + result);
        
        Integer curriedResult = Curr.curry()
            .apply(1)
            .apply(2)
            .apply(3);
        System.out.println("Каррирование: " + curriedResult);
        
        System.out.println("\n=== Person Filtering Examples ===");
        List<Person> roster = Arrays.asList(
            new Person(20, Person.Sex.MALE),
            new Person(25, Person.Sex.FEMALE),
            new Person(17, Person.Sex.MALE),
            new Person(30, Person.Sex.MALE)
        );
        
        // Анонимный класс
        printPersons(roster, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
        
        // Лямбда выражение
        printPersons(roster, 
            (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
        
        // С Predicate
        printPersonsWithPredicate(roster,
            p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }
}