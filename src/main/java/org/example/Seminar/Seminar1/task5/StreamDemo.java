package org.example.Seminar.Seminar1.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        //генерация чисел в List через Stream
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000))
                .limit(100)
                .toList();
        System.out.println(list);





        List<Product> products = generateRandomProducts();
        System.out.println(" <- Через Stream -> ");

//        Stream<Product> originalStream = products.stream();
//        Stream<Product> electtonicsStream = products.stream().filter(product -> product.getCategory().equals("Электроника"));
//        Stream<Product> lowCostElectronics = electtonicsStream.filter(it -> it.getCost() < 10_000);
//        lowCostElectronics.forEach(product -> System.out.println(product));

        products.stream()
                .filter(it -> it.getCategory().equals("Электроника"))
                .filter(it -> it.getCost() < 10_000)
                .forEach(System.out::println);

        //Найти и расепчатать товары категории Электроника дешевле 10_000
        System.out.println(" <- Через цикл -> ");
        for (Product product : products) {
            if (product.getCategory().equals("Электроника") && product.getCost() < 10_000){
                System.out.println(product);
            }
        }

        //Всем продуктам из категории "Продукты" повысить стоимость на 5%

        products.stream()
                .filter(it -> it.getCategory().equals("Продукты"))
                .forEach(it -> {
                    double oldCost = it.getCost();
                    it.setCost(oldCost * 1.05);
                });
        System.out.println(products);


        //Все продукты, начинающиеся на "М", собрать в список
        List<Product> m = products.stream()// Тогда здесь заменить List на Set
                .filter(it -> it.getName().startsWith("М"))
                .collect(Collectors.toCollection(ArrayList::new));//ArrayList можно заменить на TreeSet
//        .toList(); // вместо строки с collect, если не важно, что возвращается.
        System.out.println(m);

        //Все продукты, начинающиеся на "М", собрать в список. Для готовой коллекции
//        List<Product> existCollection = new ArrayList<>();
//        products.stream()
//                .filter(it -> it.getName().startsWith("М"))
//                .collect(Collectors.toCollection(() -> existCollection));
//        System.out.println(existCollection);
    }

    private static List<Product> generateRandomProducts(){
        return List.of(
                new Product("Молоко", 70, "Продукты"),
                new Product("Хлеб", 52, "Продукты"),
                new Product("Масло", 135, "Продукты"),
                new Product("Чипсы", 118, "Продукты"),
                new Product("Макароны", 68, "Продукты"),

                new Product("Компьютер", 70_000, "Электроника"),
                new Product("Наушники", 7_000, "Электроника"),
                new Product("Клавиатура", 3_500, "Электроника"),
                new Product("Мышь", 2_300, "Электроника"),

                new Product("Глицин", 35, "Лекарства"),
                new Product("Бинт", 19, "Лекарства"),
                new Product("Маска защитная", 150, "Лекарства"),
                new Product("Кетанов", 158, "Лекарства"),
                new Product("Парацетамол", 136, "Лекарства")
        );
    }

}
