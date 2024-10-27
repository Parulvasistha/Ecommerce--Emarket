package projects;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

class User {
    private String userName;
    private int pwd;
    private Cart cart;

    User(String userName, int pwd) {
        this.userName = userName;
        this.pwd = pwd;
        this.cart = new Cart();
    }

    public String getUserName() {
        return userName;
    }

    public int getPwd() {
        return pwd;
    }

    public Cart getCart() {
        return cart;
    }

}

class Product {
    public String name;
    public double price;
    public int qty;

    Product(String n, double p, int q) {
        name = n;
        price = p;
        qty = q;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}

class Cart {
    private List<Product> products;
    private double calcTotalPrice = 0;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public double calcTotalPrice() {
        for (Product product : products) {
            System.out.println(product);
            calcTotalPrice += product.getPrice();
        }
        return calcTotalPrice;
    }

}

class Order {

    private int id;
    private List<Product> products;
    private double calcTotalPrice = 0;

    public Order(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double calcTotalPrice() {

        for (Product product : products) {
            System.out.println(product);
            calcTotalPrice += product.getPrice();
        }
        return calcTotalPrice;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

}

class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

}

public class ECommerce {
    public static void main(String args[]) {
        System.out.println("User's Detail:--");
        User u = new User("Parul", 123);
        u.getUserName();
        u.getPwd();
        // u.getCart();
        System.out.println("User name: " + u.getUserName() + " " + "& " + "User's password: " + u.getPwd());

        System.out.println("product details:---- ");
        Product p1 = new Product("Puma Shoes", 900.0, 10);
        Product p2 = new Product("Earphone", 300.5, 13);
        Product p3 = new Product("Acer Extensa", 36650, 5);
        Product p4 = new Product("Campus", 1300, 8);
        Product p5 = new Product("Philips", 850, 9);

        System.out.println("Inventory:---- ");

        Inventory i = new Inventory();

        i.addProduct(p1);
        i.addProduct(p2);
        i.addProduct(p3);
        i.addProduct(p4);
        i.addProduct(p5);

        for (Product prod : i.getProducts()) {
            System.out.println(prod.getName());
            System.out.println(prod.getPrice());
            System.out.println(prod.getQty());
        }

        System.out.println("Cart:---- ");
        Cart ct = u.getCart();
        ct.addProduct(p1);
        ct.addProduct(p2);

        for (Product prod : ct.getProducts()) {
            System.out.println(prod.getName());
            System.out.println(prod.getPrice());
            System.out.println(prod.getQty());

        }
        System.out.println("Total Price: " + ct.calcTotalPrice());

        System.out.println("Order:---- ");
        Order o = new Order(ct.getProducts());
        o.addProduct(p1);

        for (Product pro : o.getProducts()) {
            System.out.println(pro.getName());
            System.out.println(pro.getQty());
            System.out.println(pro.getPrice());
        }

        System.out.println("Total price: " + o.calcTotalPrice());

    }
}
