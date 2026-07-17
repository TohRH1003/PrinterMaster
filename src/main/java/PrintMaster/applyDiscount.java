package PrintMaster;

// Calculate total discount amount (for print charge) to print order
// {Multiple discounts are cumulative and applied sequentially - Assumption}
// Compounding: each discount applies to balance remaining after previous discount, not flat sum
public class applyDiscount {
	
	// Constant Discount Rate Values and Thresholds
	private static final double STUDENT_DR = 0.10;
	private static final double CORPORATE_DR = 0.15;
	private static final double ORDER_DR = 0.05;
	private static final double LOYALTY_DR = 0.05;
	// Order subtotal exceeds RM300
	private static final double ORDER_THRESHOLD = 300.00;
	// More than 20 previous orders for customer
	private static final int LOYALTY_THRESHOLD = 20;
	
	/**
	 * @param customerType			"STUDENT", "CORPORATE", "REGULAR"
	 * @param hasValidStudentId		true: valid student ID
	 * @param subtotal				Order subtotal after service charges
	 * @param isExistingCustomer	true: if customer registered
	 * @param previousOrderCount	number of previous completed orders (0 == new)
	 * 
	 * @return the total discount amt (subtotal - discounted subtotal)
	 */
	
	public double calculateDiscountAmount(String customerType, boolean hasValidStudentId, 
											double subtotal, boolean isExistingCustomer, 
											int previousOrderCount) {
		if (subtotal < 0) {
			throw new IllegalArgumentException("Subtotal cannot be negative");
		}
		if (previousOrderCount < 0) {
			throw new IllegalArgumentException("Previous order count cannot be negative");
		}
		
		double currentBalance = subtotal;
		
		boolean hasHighValueDiscount = subtotal > ORDER_THRESHOLD;
		
		if ("STUDENT".equalsIgnoreCase(customerType) && hasValidStudentId) {
			currentBalance = applyPercentageDiscount(currentBalance, STUDENT_DR);
		} else if ("CORPORATE".equalsIgnoreCase(customerType)) {
			currentBalance = applyPercentageDiscount(currentBalance, CORPORATE_DR);
		}
		
		if (hasHighValueDiscount) {
			currentBalance = applyPercentageDiscount(currentBalance, ORDER_DR);
		}
		
		if (isExistingCustomer && previousOrderCount > LOYALTY_THRESHOLD) {
			currentBalance = applyPercentageDiscount(currentBalance, LOYALTY_DR);
		}
		
		double totalDiscountAmount = subtotal - currentBalance;

		return roundOff(totalDiscountAmount);
	}
	
	private double applyPercentageDiscount(double amt, double rate) {
		return amt * (1 - rate);
	}
	
	private double roundOff(double num) {
		return Math.round(num * 100.0) / 100.0;
	}
}
