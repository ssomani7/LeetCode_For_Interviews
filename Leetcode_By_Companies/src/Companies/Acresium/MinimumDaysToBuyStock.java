package Companies.Acresium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * A person wants to the buy the shares at price m$/share. The shares has the following behaviour
 * a)The price of the share remains same through out the date
 * b)At the end of the day the share price either reduces by 1$ or become double
 * calculate the minimum number of days after which he will be able to buy the shares of company give the 
 * price of the share on Day 0 is n$/share
 * 
 * input format:
 * the input consists of 2 lines each containing an integer. First line denotes n, intial price of the stock 
 * and next line denotes m the price at which the person wants to buy the stock.
 * 
 * constraints 0<n,m<=10000
 * 
 * sample test cases:
 * input1:
 * 10
 * 1
 * output
 * 9
 * 
 * input2:
 * 3
 * 4
 * output2:
 * 2
 */

public class MinimumDaysToBuyStock {

	private static int solve(int n1, int n2) {
		int days = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n1);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				if(cur == n2)
					return days;
				queue.offer(cur - 1);
				queue.offer(2 * cur);
			}
			days++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int n1 = 10, n2 = 1;
		int n3 = 3, n4 = 4;
		System.out.println(solve(n1, n2));
		System.out.println(solve(n3, n4));
	}

}
