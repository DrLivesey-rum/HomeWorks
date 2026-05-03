package javastreamapitask1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectors {
    public static void main(String[] args) {
        // 1. Создаём список заказов
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // 2. Группируем заказы по продуктам
        Map<String, List<Order>> ordersByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        // 3. Для каждого продукта находим общую стоимость заказов
        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.summingDouble(Order::getCost)
                ));

        // 4. Сортируем продукты по убыванию общей стоимости и берём топ-3
        List<Map.Entry<String, Double>> topProducts = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        // 5. Выводим результат
        System.out.println("Три самых дорогих продукта (по общей стоимости заказов):");
        for (Map.Entry<String, Double> entry : topProducts) {
            System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue());
        }
    }
}

