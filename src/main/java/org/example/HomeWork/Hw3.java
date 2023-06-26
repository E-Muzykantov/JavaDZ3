package org.example.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Hw3 {
    public static void main(String[] args) {
        Book book = new Book("Легенда", "Геммел", 1000, 1999, 607);
        Book book1 = new Book("Хроники Амбера", "Желязны", 1500, 2003, 1213);
        Book book2 = new Book("Я, робот", "Азимов", 2000, 2015, 472);
        Book book3 = new Book("Змей Уроборос", "Эддисон", 2500, 2000, 478);
        Book book4 = new Book("Конан Разрушитель", "Джордан", 1500, 2010, 653);
        Book book5 = new Book("Волкодав", "Семенова", 1700, 2012, 479);

        List<Book> productList = new ArrayList<>();
        productList.add(book);
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(book4);
        productList.add(book5);
        System.out.println("productList = " + productList);

        String searchChar = "А";
        System.out.println("Названия книг: " + setTargetList(productList, searchChar));
    }

    /**
     * @param productList исходный список
     * @param searchChar  критерий условия
     * @return список с названием книг
     * @apiNote Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и
     * год издания после 2010 г, включительно.
     */
    private static List<String> setTargetList(List<Book> productList, String searchChar) {
        List<String> targetList = new ArrayList<>();
        for (Book prod : productList) {
            if (prod.getAuthor().toLowerCase().contains(searchChar.toLowerCase()) &&
                    isSimplePages(prod.getPages()) && prod.getYear() >= 2010) {
                targetList.add(prod.getName());
            }
        }
        return targetList;
    }

    /**
     * @param number входящее число
     * @return Простое число или нет
     * @apiNote Проверка на простое число
     */
    public static boolean isSimplePages(int number) {
        if (number == 1) return false;
        else if (number < 0) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0 & number > 0) return false;
        }
        return true;
    }
}
