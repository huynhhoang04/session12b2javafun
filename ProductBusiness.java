package ra.business;

import ra.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductBusiness {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        System.out.println("--- THÊM SẢN PHẨM MỚI ---");
        Product product = new Product();
        product.inputData(scanner, products);
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public static void displayProducts() {
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        if (products.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Product p : products) {
                System.out.println(p.toString());
            }
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("--- CẬP NHẬT SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Product foundProduct = findById(id);

            if (foundProduct != null) {
                System.out.println("Tìm thấy sản phẩm: " + foundProduct.getProductName());
                System.out.println("Nhập thông tin mới (ID giữ nguyên):");
                foundProduct.inputData(scanner, products);
                System.out.println("Cập nhật thành công!");
            } else {
                System.err.println("Không tìm thấy mã sản phẩm: " + id);
            }
        } catch (NumberFormatException e) {
            System.err.println("Mã sản phẩm phải là số nguyên.");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("--- XÓA SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Product foundProduct = findById(id);

            if (foundProduct != null) {
                products.remove(foundProduct);
                System.out.println("Đã xóa sản phẩm có mã: " + id);
            } else {
                System.err.println("Không tìm thấy mã sản phẩm: " + id);
            }
        } catch (NumberFormatException e) {
            System.err.println("Mã sản phẩm phải là số nguyên.");
        }
    }

    public static void searchByName(Scanner scanner) {
        System.out.println("--- TÌM KIẾM SẢN PHẨM ---");
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Product p : products) {
            if (p.getProductName().toLowerCase().contains(keyword)) {
                System.out.println(p.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào chứa từ khóa: " + keyword);
        }
    }

    public static void sortByPriceAsc() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống, không thể sắp xếp.");
            return;
        }
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Float.compare(p1.getPrice(), p2.getPrice());
            }
        });
        System.out.println("Đã sắp xếp theo giá tăng dần:");
        displayProducts();
    }

    public static void sortByQuantityDesc() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống, không thể sắp xếp.");
            return;
        }
        Collections.sort(products, (p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
        System.out.println("Đã sắp xếp theo số lượng giảm dần:");
        displayProducts();
    }

    private static Product findById(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
}
