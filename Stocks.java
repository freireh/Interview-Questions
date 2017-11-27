import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stocks {
    public static void main(String[] args) {
        System.out.println(
                "Please introduce the stock prices array in a single string, where each price is separated by comma (eg. 10,7,5,8,11,9): ");

        Scanner in = new Scanner(System.in);
        String yesterdayPrices = in.next();

        int[] stockPriceYesterday = Arrays.stream(yesterdayPrices.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();

        System.out.println("Max profit --> " + calculateMaxProfits(stockPriceYesterday));
    }

    private static int calculateMaxProfits(int[] stockPriceYesterday) {
        int currentMin = stockPriceYesterday[0];
        int currentMax = stockPriceYesterday[0];

        List<Integer> profits = new ArrayList<>();

        for (int i = 0; i < stockPriceYesterday.length; i++) {
            if (i + 1 < stockPriceYesterday.length && stockPriceYesterday[i + 1] > stockPriceYesterday[i]) {
                currentMax = stockPriceYesterday[i + 1];
            }

            if (i + 1 < stockPriceYesterday.length && stockPriceYesterday[i + 1] < stockPriceYesterday[i]) {
                profits.add(currentMax - currentMin);

                // re-position
                currentMin = stockPriceYesterday[i + 1];
                currentMax = stockPriceYesterday[i + 1];
            }

            if (i == stockPriceYesterday.length - 1) {
                profits.add(currentMax - currentMin);
            }
        }

        return profits.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }
}
