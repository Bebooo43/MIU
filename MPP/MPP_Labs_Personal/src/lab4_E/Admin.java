package lab4_E;

import java.util.List;

public class Admin {
	private static double updatedBalanceSum;
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		updatedBalanceSum = 0.0;
		list.stream().forEach((e) ->{
			updatedBalanceSum += e.computeUpdatedBalanceSum();
		});
		return updatedBalanceSum;
	}
}
