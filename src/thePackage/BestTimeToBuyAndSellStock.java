package thePackage;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
		int buy = 0;
		int sell = 1;
		int maxProfit = 0;
		
		while (sell < prices.length) {
			if (prices[buy] > prices[sell])
				buy = sell;
			else if (maxProfit < prices[sell] - prices[buy])
				maxProfit = prices[sell] - prices[buy];
			sell++;
		}
		
        return maxProfit;
    }
	
	public int maxProfit_tooSlow2(int[] prices) {
        int maxProfit = 0;
        int currMaxProfit;
        for (int i = 0; i < prices.length; i++) {
        	currMaxProfit = 0;
        	for (int j = i+1; j < prices.length; j++) {
        		if (currMaxProfit < prices[j] - prices[i])
        			currMaxProfit = prices[j] - prices[i];
        	}
        	if (maxProfit < currMaxProfit)
        		maxProfit = currMaxProfit;
        }
        return maxProfit;
    }

	public int maxProfit_tooSlow(int[] prices) {
        int[] maxProfits = new int[prices.length];
        int currMaxProfit;
        for (int i = 0; i < prices.length; i++) {
        	currMaxProfit = 0;
        	for (int j = i+1; j < prices.length; j++) {
        		if (currMaxProfit < prices[j] - prices[i])
        			currMaxProfit = prices[j] - prices[i];
        	}
        	maxProfits[i] = currMaxProfit;
        }
        return findMax(maxProfits);
    }
	
	private static int findMax(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
}
