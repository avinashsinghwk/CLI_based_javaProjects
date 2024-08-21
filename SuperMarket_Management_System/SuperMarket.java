import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class AvailabeProduct {
    private String name;
    private double price;

    public AvailabeProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class StoreCart {
    private Map<String, AvailabeProduct> products;

    public StoreCart() {
        products = new HashMap<>();
    }

    public void addProduct(AvailabeProduct product) {
        products.put(product.getName(), product);
    }

    public AvailabeProduct getProduct(String name) {
        return products.get(name);
    }

    public void showProducts() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("╟ Product Name         | Price (Rs) ╢");
        System.out.println("╟───────────────────────────────────╢");
        for (AvailabeProduct product : products.values()) {
            System.out.printf("╟ %-20s | %6.2f Rs. ╢\n", product.getName(), product.getPrice());
        }
        System.out.println("╚═══════════════════════════════════╝");
    }

}

class CustomerCart {
    private List<AvailabeProduct> items;

    public CustomerCart() {
        items = new ArrayList<>();
    }

    public void addProduct(AvailabeProduct product) {
        items.add(product);
    }

    public List<AvailabeProduct> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (AvailabeProduct item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

class MakeBill {
    public void generateBill(CustomerCart cart) {
        List<AvailabeProduct> items = cart.getItems();
        double total = cart.calculateTotal();

        System.out.println("\n\nBill Details:");
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║ Item                      Price (Rs) ║");
        System.out.println("╟──────────────────────────────────────╢");

        for (AvailabeProduct item : items) {
            System.out.printf("║ %-25s %.2f Rs   ║%n", item.getName(), item.getPrice());
        }

        System.out.println("╟──────────────────────────────────────╢");
        System.out.printf("║ %-25s %.2f Rs  ╢%n", "TOTAL", total);
        System.out.println("╚══════════════════════════════════════╝");

    }
}

public class SuperMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreCart storecart = new StoreCart();
        CustomerCart customercart = new CustomerCart();

        storecart.addProduct(new AvailabeProduct("PULSE", 94.19));
        storecart.addProduct(new AvailabeProduct("RICE", 39.99));
        storecart.addProduct(new AvailabeProduct("CEREALS", 92.99));
        storecart.addProduct(new AvailabeProduct("COMB", 98.19));
        storecart.addProduct(new AvailabeProduct("VEGE.", 78.59));
        storecart.addProduct(new AvailabeProduct("JUICE", 11.99));
        storecart.addProduct(new AvailabeProduct("BELT", 28.89));
        storecart.addProduct(new AvailabeProduct("BALL", 68.08));
        storecart.addProduct(new AvailabeProduct("SHOE", 58.49));
        storecart.addProduct(new AvailabeProduct("WATER", 52.99));
        storecart.addProduct(new AvailabeProduct("MANGO", 29.79));
        storecart.addProduct(new AvailabeProduct("FACE WASH", 14.24));
        storecart.addProduct(new AvailabeProduct("FRUIT", 48.72));
        storecart.addProduct(new AvailabeProduct("SPICES", 41.19));

        while (true) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("╟      SMART MARKET MANAGEMENT SYSTEM      ╢");
            System.out.println("       ------------------------------       ");
            System.out.println("╟       ( By : Avinash Kumar Singh )       ╢");
            System.out.println("╚══════════════════════════════════════════╝\n");
            System.out.println("1. Show all available products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\n----------All Availabe Products ----------\n\n");
                    storecart.showProducts();
                    break;

                case 2:
                    while (true) {
                        System.out.print("\nAdd Product to cart / Type 'total' to make bill :  ");
                        String ch = scanner.nextLine();
                        if (ch.equalsIgnoreCase("TOTAL")) {
                            MakeBill bill = new MakeBill();
                            bill.generateBill(customercart);
                            break;
                        } else {
                            AvailabeProduct product = storecart.getProduct(ch.toUpperCase());
                            if (product != null) {
                                customercart.addProduct(product);
                                System.out.println(product.getName() + " added to cart.");
                            } else {
                                System.out.println("Product not found.");
                            }
                        }

                    }

                case 3:
                    System.out.println("\nExiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

}
