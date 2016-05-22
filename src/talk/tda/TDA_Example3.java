package talk.tda;

import java.util.Arrays;
import java.util.List;

public class TDA_Example3 {

    private class StockManager {
        public List<String> getStockPurchased() {
            return Arrays.asList("sku-1", "sku-2"); // some db query result
        }

        public List<String> getStockSold() {
            return Arrays.asList("sku-1", "sku-1"); // some db query result
        }
    }

    private class DisplayManager {
        public int display(StockManager stockManager) {
            List<String> stockPurchased = stockManager.getStockPurchased();
            List<String> stockSold = stockManager.getStockSold();

            return stockPurchased.size() - stockSold.size();
        }
    }
}
