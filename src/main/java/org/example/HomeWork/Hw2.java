package org.example.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw2 {
    public static void main(String[] args) {
        ProductHw2 product = new ProductHw2("Апельсины", "Турция", 10, 20, "Люкс");
        ProductHw2 product1 = new ProductHw2("Лимоны", "Абхазия", 5, 30, "Высший");
        ProductHw2 product2 = new ProductHw2("Бананы", "Египет", 10, 40, "Средний");
        ProductHw2 product3 = new ProductHw2("Пшено", "Россия", 20, 35, "Высший");
        ProductHw2 product4 = new ProductHw2("Мандарины", "Абхазия", 15, 25, "Люкс");
        ProductHw2 product5 = new ProductHw2("Яблоки", "Россия", 7, 20, "Люкс");

        List<ProductHw2> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        System.out.println("productList = " + productList);

        List<ProductHw2> targetList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сорт (Люкс, Высшый, Средний): ");
        String searchName = sc.next();
        sc.close();
        setTargetList(productList, targetList, searchName);
        System.out.println("targetList = " + targetList);
        System.out.println("Наименования товаров заданного сорта с наименьшей ценой: " + findLowPrice(targetList));
    }

    /**
     * @param productList исходный список
     * @param targetList  формируемый список
     * @param searchName  критерий условия
     * @apiNote Формируем список по условию
     */
    private static void setTargetList(List<ProductHw2> productList, List<ProductHw2> targetList, String searchName) {
        for (ProductHw2 prod : productList) {
            if (prod.getVariety().toLowerCase().contains(searchName.toLowerCase())) {
                targetList.add(prod);
            }
        }
    }

    /**
     * @param targetList входящий список товаров заданного сорта
     * @return наименования товаров
     * @apiNote Получить наименования товаров заданного сорта с наименьшей ценой.
     */
    private static StringBuilder findLowPrice(List<ProductHw2> targetList) {
        int lowPrice = targetList.get(0).getPrice();
        StringBuilder productLowPrice = new StringBuilder();
        for (ProductHw2 prod : targetList) {
            if (prod.getPrice() < lowPrice) {
                lowPrice = prod.getPrice();
            }
        }
        for (ProductHw2 prod : targetList) {
            if (prod.getPrice() == lowPrice) {
                productLowPrice.append(prod.getName()).append(" ");
            }
        }
        return productLowPrice;
    }
}

