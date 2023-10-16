package com.right2vote;

import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Right2voteAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Right2voteAssignmentApplication.class, args);
		List<Integer> currentCombList=new ArrayList<>();
		double initBudget=600.00;
		findCombinations(initBudget,currentCombList , 0, 0, 0);
	}
	
	static double tshirtPrice = 50.00;
    static double jeansPrice = 80.00;
    static double jacketPrice = 100.00;
    
    public static void findCombinations(double remainingBudget, List<Integer> currentCombination, int tshirtCount, int jeansCount, int jacketCount) {
        if (tshirtCount > 0 && jeansCount > 0 && jacketCount > 0) {
            System.out.println("T-shirts: " + tshirtCount + ", Jeans: " + jeansCount + ", Jackets: " + jacketCount);
        }

        if (remainingBudget < tshirtPrice) {
            return;
        }

        // Try adding a T-shirt
        if (remainingBudget >= tshirtPrice) {
            currentCombination.add(0);
            findCombinations(remainingBudget - tshirtPrice, currentCombination, tshirtCount + 1, jeansCount, jacketCount);
            currentCombination.remove(currentCombination.size() - 1);
        }

        // Try adding a pair of jeans
        if (remainingBudget >= jeansPrice) {
            currentCombination.add(1);
            findCombinations(remainingBudget - jeansPrice, currentCombination, tshirtCount, jeansCount + 1, jacketCount);
            currentCombination.remove(currentCombination.size() - 1);
        }

        // Try adding a jacket
        if (remainingBudget >= jacketPrice) {
            currentCombination.add(2);
            findCombinations(remainingBudget - jacketPrice, currentCombination, tshirtCount, jeansCount, jacketCount + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
