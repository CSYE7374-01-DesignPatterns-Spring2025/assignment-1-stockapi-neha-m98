
package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }

        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public boolean removeStock(StockAPI stock) {
        return stocks.remove(stock);
    }

    public void displayAllTheStocks() {
        stocks.forEach(stock -> System.out.println(stock.toString()));
    }

    public void tradeStock(StockAPI stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock);
    }

    public void simulateBids(StockAPI stock, String[] bids) {
        for (String bid : bids) {
            tradeStock(stock, bid);
        }
    }

    public static void demo() {
        StockMarket stockMarket = StockMarket.getInstance();

        System.out.println("======= IBM Stock Bid Start ======= ");
        StockAPI stock = new StockAPI("IBM", 131.15, "IBM Common Stock");
        stockMarket.addStock(stock);
        stockMarket.simulateBids(stock, new String[] { "135", "140", "128", "125", "130", "137" });
        System.out.println("\n");

        System.out.println("======= microsoft Stock Bid Start ======= ");
        StockAPI MSFTStock = new MSFTStock(300);
        stockMarket.addStock(MSFTStock);
        stockMarket.simulateBids(MSFTStock, new String[] { "310", "320", "290", "280", "330", "340" });
        System.out.println("\n");

        System.out.println("======= Nvidia Stock Bid Start ======= ");
        StockAPI nvidiaStock = new NvidiaStock(250);
        stockMarket.addStock(nvidiaStock);
        stockMarket.simulateBids(nvidiaStock, new String[] { "245", "230", "255", "265", "275", "250" });
        System.out.println("\n");

        System.out.println("======= All Stock Information ======= ");
        StockMarket.getInstance().displayAllTheStocks();
        System.out.println("\n");
    }
}
