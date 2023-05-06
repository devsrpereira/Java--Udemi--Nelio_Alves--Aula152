package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime moment = LocalDateTime.now();

        System.out.println();
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (dd/mm/yyyy): ");
        LocalDate clientBirthDay = LocalDate.parse(sc.next(), dtf1);

        Client client = new Client(clientName, clientEmail, clientBirthDay);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();

        Order order = new Order(moment, OrderStatus.valueOf(status), client);

        System.out.println();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" +(1+i)+ " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(name, price);
            OrderItem item = new OrderItem(quantity, price, name, product);

            order.addItem(item);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + dtf2.format(moment));
        System.out.println("Order status: " + OrderStatus.valueOf(status));
        System.out.println(client);
        System.out.println(order);
    }
}
