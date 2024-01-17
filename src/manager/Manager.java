package src.manager;

import src.io.ProductIO;
import src.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void display() {
        System.out.println("ID, Name, Price, Quantity, Description");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // chức năng thêm mới một sản phẩm sử dụng 4 hàm: checkId, validateId, create, add để làm các công việc nhỏ
    // checkId(): kiểm tra một Id đã tồn tại hay chưa
    // validateId(): kiểm tra Id người dùng nhập vào qua hàm checkId() nếu hợp lệ sẽ trả về Id đó, nếu không sẽ báo Id đã tồn tại
    // create(): gán giá trị người dùng nhập vào cho các biến khởi tạo nên đối tượng thuộc lớp Product và trả về đối tượng
    // add(): thêm đối tượng lớp Product vào mảng products, ta sẽ truyền vào đối số là kết quả của hàm create()
    public boolean checkId(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public int validateId() {
        while (true) {
            System.out.println("enter Id");
            int id = Integer.parseInt(scanner.nextLine());
            if (checkId(id)) {
                return id;
            } else {
                System.out.println("Id existed");
            }
        }
    }

    public Product create() {
        int id = validateId();
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("enter price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("enter quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("enter description");
        String description = scanner.nextLine();
        return new Product(id, name, price, quantity, description);
    }

    public void add(Product p) {
        products.add(p);
    }

    // chức năng cập nhật sản phẩm sử dụng 3 hàm: findIndexById, create, edit
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void edit() {
        try {
            System.out.println("enter id to edit");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.set(index, create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            System.out.println("enter id to delete");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.remove(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // sort by bubles method
    public void sort() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    // find the most expensive products
    public Product findMost() {
        if (products.size() > 0) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;
        } else {
            return null;
        }
    }
    // function to read, write the file is calles from class IO
    public void read() {
        products = ProductIO.read();
    }
    public void write() {
        ProductIO.write(products);
    }
}