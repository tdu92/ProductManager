package src.validate;

import src.model.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    static Scanner scanner = new Scanner(System.in);
    public static int quantity(){
        while (true) {
            try {
                System.out.println("enter quantity");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                System.out.println("wrong enter");
            }
        }
    }
    // code to set the id of product to increase automatically
    public static int id(List<Product> products){
        int idMax = 0;
        for(Product p : products) {
            if (p.getId()>idMax){
                idMax = p.getId();
            }
        }
        return idMax+1;
    }
    // kills exceptions when enter the price
public static double price() {
    while (true) {
        try {
            System.out.println("enter price");
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("wrong enter");
        }
    }
}
public static String name (List<Product> products) {
        while (true) {
            System.out.println("enter name");
            String name = scanner.nextLine();
            boolean check = true;
            for (Product p : products) {
                if (p.getName().equals(name)) {
                    System.err.println("name duplicated");
                    check=false;
                    break;
                }
            }
            if (check) {
                return name;
            }
        }
}
}
