package org.example.Homework.Homework1;

//        * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API +
//        * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API +
//        *
//        * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000 +
//        * 1.1 Найти максимальное +
//        * 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать +
//        * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000 +
//        *
//        * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department +
//        * 2.1 Создать список из 10-20 сотрудников +
//        * 2.2 Вывести список всех различных отделов (department) по списку сотрудников -+
//        * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20% +
//        * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
//        * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
//        */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        // Создание списка рандомных чисел
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(1_000)
                .toList();
        System.out.println("Тысяча чисел: " + list);

        // Вывод максимального числа из списка
        System.out.println("Максимальное число из списка: " + maxNumber(list));

       // Ввод суммы всех чисел больше 500_000
        System.out.println("Cумма всех чисел больше 500_000: " + sumAllNumberLarger500_000(list));

        // Вывод кол-ва чисел квадрат которых больше 100_000
        System.out.println("Количество чисел квадрат которых меньше 100_000: " + countNumbersSquareLess100_000(list));


        // Вывод списка всех отделов, сотрудников
        List<Employee> employees = generateEmployee();
        Map<String, Employee> mapDepartmentEmployee = employees.stream()
                .collect(Collectors.toMap(employee -> employee.getDepartment(), it -> it, (it1, it2) -> it1));

        System.out.println(mapDepartmentEmployee);

//        employees.stream()
//                .filter(it -> Boolean.parseBoolean(it.getDepartment()))
//                .forEach(System.out::println);


        // Увеличение зарплаты всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream()
                .filter(it -> it.getSalary() < 10_000)
                .forEach(it -> {
                    double newSalary = it.getSalary();
                    it.setSalary(newSalary * 1.2);
                });
        System.out.println(employees);
    }


    // Поиск максимального числа из списка
    private static Integer maxNumber(List<Integer> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .get();
    }


    private static Integer sumAllNumberLarger500_000 (List<Integer> list) {
        return list.stream().filter(it -> it >= 500_000)
                .map(it -> it * 5)
                .map(it -> it - 150)
                .mapToInt(Integer::intValue).sum();
    }

    private static long countNumbersSquareLess100_000 (List<Integer> list) {
        return list.stream().map(it -> it * it)
                .filter(it -> it <= 100_000 && it > 0)
                .count();

    }

    private static List<Employee> generateEmployee() {
        return List.of(
                new Employee("Иван", 34, 10000, "Python"),
                new Employee("Олег", 41, 11000, "C#"),
                new Employee("Дмитрий", 47, 3500, "Python"),
                new Employee("Константин", 45, 7400, "C#"),
                new Employee("Пётр", 35, 8600, "Java"),
                new Employee("Павел", 26, 5000, "C#"),
                new Employee("Сергей", 43, 15000, "Python"),
                new Employee("Илья", 29, 9000, "Java"),
                new Employee("Станислав", 45, 5400, "Python"),
                new Employee("Игорь", 37, 17000, "Java"),
                new Employee("Кирилл", 35, 10000, "Python"),
                new Employee("Иван", 26, 17000, "C#"),
                new Employee("Дмитрий", 35, 9500, "Java"),
                new Employee("Павел", 44, 14500, "Python"),
                new Employee("Олег", 36, 16800, "Java")
        );
    }



}
