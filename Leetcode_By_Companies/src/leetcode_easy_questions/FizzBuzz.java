package leetcode_easy_questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(1)
 */

/*
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output 
 * “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 * Example:
 * n = 15,
 * Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 */

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        
        if(n <= 0)
            return resultList;
        
        for(int num = 1; num <= n; num++){
            boolean multipleOfThree = num % 3 == 0 ? true : false;
            boolean multipleOfFive = num % 5 == 0 ? true : false;
            
            if(multipleOfThree && multipleOfFive){
                resultList.add("FizzBuzz");
                continue;
            }else if(multipleOfThree){
                resultList.add("Fizz");
                continue;
            }else if(multipleOfFive){
                resultList.add("Buzz");
                continue;
            }else
                resultList.add(String.valueOf(num));
        }
        
        return resultList;
    }
	
	public static void main(String[] args) {
		int n = 15;
		List<String> resultList = fizzBuzz(n);
		
		for(String str : resultList)
			System.out.println(str);
	}

}
