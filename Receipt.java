import java.util.Scanner;

public class Receipt {
    private boolean isVeg;    // To store if the pizza is vegetarian or not
    private boolean isPremium; // To store if the pizza is premium or regular

    // Constructor to initialize the Receipt with pizza type and quality
    public Receipt(boolean isVeg, boolean isPremium) {
        this.isVeg = isVeg;
        this.isPremium = isPremium;
    }

    // Method to calculate the base cost of the pizza based on type and premium status
    public double getCost() {
        double cost = 0;
        if (isVeg) {
            cost += 250; // Base price for Veg Pizza
        } else {
            cost += 300; // Base price for Non-Veg Pizza
        }
        if (isPremium) {
            cost += 100; // Additional cost for Premium Pizza
        }
        return cost;
    }

    // Method to add the price of toppings to the total cost
    public double addToppings(double cost, String topping) {
        if (topping.equalsIgnoreCase("cheese")) {
            cost += 20;  // Add 20 for Cheese topping
        } else if (topping.equalsIgnoreCase("chicken")) {
            cost += 50;  // Add 50 for Chicken topping
        } else if (topping.equalsIgnoreCase("onion")) {
            cost += 15;  // Add 15 for Onion topping
        }
        return cost; // Return updated cost after adding topping
    }

    // Method to calculate and add tax to the total cost (5% tax)
    public double addTax(double cost) {
        return cost + (cost * 0.05); // Adding 5% tax to the total cost
    }

    // Method to apply a discount to the total cost (percentage-based)
    public double addDiscount(double cost, double discount) {
        return cost - (cost * discount); // Subtracting discount percentage from the total cost
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to take user input
        
        // Step 1: Ask user for the type of pizza (Veg/Non-Veg)
        System.out.println("Welcome to MY Pizza Shop!");
        System.out.println("Select the pizza type:");
        System.out.println("1. Veg");
        System.out.println("2. Non-Veg");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        boolean isVeg = choice == 1;  // If choice is 1, set pizza to Veg, else Non-Veg
        
        // Step 2: Ask if the user wants a premium pizza or not
        System.out.println("Do you want a premium pizza?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");
        boolean isPremium = scanner.nextInt() == 1;  // If choice is 1, set pizza to Premium
        
        // Create a new Receipt object with the user's choices
        Receipt receipt = new Receipt(isVeg, isPremium);
        double cost = receipt.getCost();  // Calculate base cost of pizza
        
        // Step 3: Ask user if they want to add toppings
        System.out.println("Do you want to add any toppings?");
        System.out.println("1. Cheese");
        System.out.println("2. Chicken");
        System.out.println("3. Onion");
        System.out.println("4. No Toppings");
        System.out.print("Enter your choice: ");
        int toppingChoice = scanner.nextInt();  // Take the user's topping choice
        
        // Add the selected topping's price to the total cost
        switch (toppingChoice) {
            case 1:
                cost = receipt.addToppings(cost, "cheese");
                break;
            case 2:
                cost = receipt.addToppings(cost, "chicken");
                break;
            case 3:
                cost = receipt.addToppings(cost, "onion");
                break;
            default:
                System.out.println("No toppings selected.");
        }
        
        // Step 4: Ask the user if there's a discount (for online platforms like Swiggy/Zomato)
        System.out.print("Enter discount percentage (for Swiggy/Zomato orders): ");
        double discount = scanner.nextDouble() / 100; // Get the discount percentage and convert to decimal
        
        cost = receipt.addDiscount(cost, discount); // Apply the discount
        cost = receipt.addTax(cost); // Add the tax to the final cost
        
        // Step 5: Display the final bill with all charges
        System.out.printf("Your total bill is: ₹%.2f\n", cost);
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
