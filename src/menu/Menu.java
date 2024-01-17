package src.menu;

import src.io.ProductIO;
import src.manager.Manager;
import src.model.Product;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            int choice = 0;
            while (true) {
                try {
                    System.out.println("Chọn chức năng: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {

                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn chức năng xem danh sách");
                    manager.display();
                    break;
                case 2:
                    System.out.println("Ban đã chọn chức năng thêm mới sản phẩm");
                    manager.add(manager.create());
                    System.out.println("Them moi thanh cong");
                    break;
                case 3:
                    System.out.println("Bạn đã chọn chức năng cập nhật sản phẩm");
                    manager.edit();
                    break;
                case 4:
                    System.out.println("Bạn đã chọn chức năng xoá sản phẩm");
                    manager.delete();
                    break;
                case 5:
                    System.out.println("Bạn đã chọn chức năng sắp xếp sản phẩm");
                    manager.sort();
                    break;
                case 6:
                    System.out.println("Bạn đã chọn chức năng tìm sản phẩm giá cao nhất");
                    manager.findMost();
                    break;
                case 7:
                    System.out.println("Bạn đã chọn chức năng đọc từ file");
                    manager.read();
                    break;
                case 8:
                    System.out.println("Bạn đã chọn chức năng ghi vào file");
                    manager.write();
                    break;
                case 9:
                    return;


            }
        }
    }
}
