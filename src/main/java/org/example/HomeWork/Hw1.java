package org.example.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Hw1 {
    public static void main(String[] args) {
        ProductHw1 product = new ProductHw1("Мука пшеничная Макфа Высший сорт", 36, 1);
        ProductHw1 product1 = new ProductHw1("Чай зеленый Лунцзин", 57, 2);
        ProductHw1 product2 = new ProductHw1("Чай черный Цейлонский высший сорт", 59, 2);
        ProductHw1 product3 = new ProductHw1("Мука пшеничная Предпортовая высший сорт", 33, 3);
        ProductHw1 product4 = new ProductHw1("Соль поваренная", 67, 2);
        ProductHw1 product5 = new ProductHw1("Сахар рафинад", 43, 1);

        List<ProductHw1> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        System.out.println("productList = " + productList);

        List<ProductHw1> targetList = new ArrayList<>();
        String searchName = "высший";
        setTargetList(productList, targetList, searchName);
        System.out.println("targetList = " + targetList);
        System.out.println(findMaxPrice(targetList));
    }

    /**
     * @param targetList входящий список
     * @return строка с ценой и товаром
     * @apiNote Найти наибольшую цену товаров 1го или 2-го сорта среди товаров, название которых содержит «высший»
     */
    private static String findMaxPrice(List<ProductHw1> targetList) {
        String maxPrice = "";
        for (int i = 1; i < targetList.size(); i++) {
            if (targetList.get(i).getPrice() > targetList.get(i - 1).getPrice()) {
                maxPrice = String.format("Максимальная цена %s у товара %s, сорт %s.", targetList.get(i).getPrice(),
                        targetList.get(i).getName(), targetList.get(i).getVariety());
            }
        }
        return maxPrice;
    }

    /**
     * @param productList исходный список
     * @param targetList  формируемый список
     * @param searchName  критерий условия
     * @apiNote Формируем список по условию
     */
    private static void setTargetList(List<ProductHw1> productList, List<ProductHw1> targetList, String searchName) {
        for (ProductHw1 prod : productList) {
            if (prod.getName().toLowerCase().contains(searchName) && (prod.getVariety() == 1 || prod.getVariety() == 2)) {
                targetList.add(prod);
            }
        }
    }
}
