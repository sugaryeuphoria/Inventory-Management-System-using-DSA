import java.util.HashMap; // We import a tool to help us store data conveniently.
import java.util.Map; // Another tool for mapping one thing to another.
import java.util.Scanner; // A tool to take input from the user.

public class InventoryManagementSystem { // This is our program named InventoryManagementSystem.
    private Map<String, Integer> inventory; // We create a storage space (Map) to keep track of products and quantities.

    public InventoryManagementSystem() { // This is a special method that runs when we create a new
                                         // InventoryManagementSystem.
        this.inventory = new HashMap<>(); // We set up our storage space (HashMap) when the program starts.
    }

    public void addProduct(String productName, int quantity) { // This method adds a product to our storage space.
        inventory.put(productName, quantity); // We put the product and its quantity into our storage space.
        System.out.println(productName + " added to inventory with quantity: " + quantity); // We tell the user what we
                                                                                            // did.
    }

    public void updateQuantity(String productName, int newQuantity) { // This method updates the quantity of a product.
        if (inventory.containsKey(productName)) { // If the product is already in our storage space...
            inventory.put(productName, newQuantity); // ...we change its quantity to the new quantity.
            System.out.println("Quantity of " + productName + " updated to: " + newQuantity); // We tell the user what
                                                                                              // we did.
        } else {
            System.out.println("Product " + productName + " not found in inventory."); // If the product is not in our
                                                                                       // storage space, we tell the
                                                                                       // user.
        }
    }

    public void generateReport() { // This method creates a report of all products and their quantities.
        System.out.println("\nInventory Report:"); // We tell the user that we're showing them a report.
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) { // For each product and quantity in our storage
                                                                        // space...
            System.out.println(entry.getKey() + ": " + entry.getValue()); // ...we show the product and its quantity.
        }
        System.out.println("---------------\n"); // We add some lines to make the report look nice.
    }

    public static void main(String[] args) { // This is the main part of our program that runs when we start it.
        InventoryManagementSystem ims = new InventoryManagementSystem(); // We create a new InventoryManagementSystem.

        Scanner scanner = new Scanner(System.in); // We create a tool to take input from the user.

        while (true) { // We start a loop that keeps running until we decide to stop.
            System.out.println("1. Add Product"); // We show the user some options.
            System.out.println("2. Update Quantity");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: "); // We ask the user to choose an option.
            int choice = scanner.nextInt(); // We read the user's choice.

            switch (choice) { // We check what the user chose.
                case 1: // If the user chose 1...
                    System.out.print("Enter product name: "); // ...we ask for the product name.
                    String productName = scanner.next(); // We read the product name.
                    System.out.print("Enter quantity: "); // ...and ask for the quantity.
                    int quantity = scanner.nextInt(); // We read the quantity.
                    ims.addProduct(productName, quantity); // We add the product to our storage space.
                    break; // We finish dealing with this choice.

                case 2: // If the user chose 2...
                    System.out.print("Enter product name: "); // ...we ask for the product name to update.
                    String productNameUpdate = scanner.next(); // We read the product name.
                    System.out.print("Enter new quantity: "); // ...and ask for the new quantity.
                    int newQuantity = scanner.nextInt(); // We read the new quantity.
                    ims.updateQuantity(productNameUpdate, newQuantity); // We update the product's quantity.
                    break; // We finish dealing with this choice.

                case 3: // If the user chose 3...
                    ims.generateReport(); // ...we show the report of all products and quantities.
                    break; // We finish dealing with this choice.

                case 4: // If the user chose 4...
                    System.out.println("Exiting Inventory Management System."); // ...we tell the user we're exiting.
                    System.exit(0); // We stop the program.
                    break; // We finish dealing with this choice.

                default: // If the user chose something else...
                    System.out.println("Invalid choice. Please enter a valid option."); // ...we tell the user they made
                                                                                        // an invalid choice.
            }
        }
    }
}
