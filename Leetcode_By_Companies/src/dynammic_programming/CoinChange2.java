package dynammic_programming;

/* Main Point is that we are asked COMBINATIONS and NOT permutations.
 * So 1+2+2 and 2+1+2 is 1 combination and 2 permutations.
 * This is the key difference in this problem from Combination Sum.
 * 
 * Time complexity: O(N×amount), where N is a length of coins array.
 * Space complexity: O(amount) to keep dp array.
 */

/*
 * We need to rotated over the given "Coins" array and our index on the amountRange will start from the coins
 * given in coins array.
 */

public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        //Dynammic Programming
        //Step 1 : Declare an array of size amount + 1. The indexes of this array will represent
        //different amounts.
        //Make the first element of this array as 1. This is because we need a starting point for coin
        //1.
        int[] amountCombination = new int[amount + 1];
        amountCombination[0] = 1; //important step
        
        //Step 2 : We only need to look for the amount in the amountCombination array from the coin
        //we are iterating. This makes up the condition amount in the amountCombination array is >=
        //coin.
        //If this condition is true, we need to include all the combinations from the previous coins
        //into this coin.
        //With Dynammic Programming we will store the combinations for that amount (index) at that
        //index. So going forward, if the amount >= coin, we will include all the combinations before
        //that which will form the subset for that amount.
        
        for(int coin : coins){
            for(int index = coin; index < amountCombination.length; index++)
                amountCombination[index] += amountCombination[index - coin];
        }
        
        return amountCombination[amount];
    }
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		
		System.out.println("Combinations to make up amount " + amount + " = " + change(amount, coins));
	}

}
