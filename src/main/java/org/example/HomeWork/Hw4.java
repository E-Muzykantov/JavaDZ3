package org.example.HomeWork;

import java.util.*;

public class Hw4 {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Максимальное " + Collections.max(array));
        System.out.println("Минимальное " + Collections.min(array));

        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        System.out.println("Среднее " + (sum / array.size()));

        Double average = array.stream().mapToInt(i -> i).average().orElse(0.0);
        System.out.println("Среднее " + average);

        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        for (int i = 0; i < array.size(); i++) {
            intSummaryStatistics.accept(array.get(i));
        }
        System.out.println("Максимальное "
                + intSummaryStatistics.getMax());
        System.out.println("Минимальное "
                + intSummaryStatistics.getMin());
        System.out.println("Среднее "
                + intSummaryStatistics.getAverage());

        IntSummaryStatistics stats = array.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats);

    }

}
