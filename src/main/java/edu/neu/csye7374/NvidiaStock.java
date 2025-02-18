package edu.neu.csye7374;

import java.util.Collections;

public class NvidiaStock extends StockAPI {

    public NvidiaStock(double price) {
        super("Nvidia", price, "Nvidia Common Stock");
    }

    @Override
    public int getMetric() {
        if (bids.size() <= 1) {
            return 0;
        }
        double minBid = Collections.min(bids);
        double maxBid = Collections.max(bids);

        double volatility = maxBid - minBid;
        double priceChange = bids.get(bids.size() - 1) - bids.get(0);

        double currentPrice = getPrice();

        return (int) Math.round((volatility * currentPrice) / priceChange);
    }
}
