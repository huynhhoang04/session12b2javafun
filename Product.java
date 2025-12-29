package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product {
    private static int nextId = 1; 

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
        this.productId = nextId++;
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner, List<Product> existingProducts) {
        while (true) {
            System.out.print("Nhập tên: ");
            String inputName = scanner.nextLine().trim();

            if (inputName.length() >= 10 && inputName.length() <= 50) {
                boolean isDuplicate = false;
                for (Product p : existingProducts) {
                    if (p.getProductId() != this.productId && p.getProductName().equalsIgnoreCase(inputName)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    this.productName = inputName;
                    break;
                } else {
                    System.err.println("đã tồn tại");
                }
            } else {
                System.err.println("10 đến 50");
            }
        }

        while (true) {
            System.out.print("Nhập giá: ");
            try {
                float inputPrice = Float.parseFloat(scanner.nextLine());
                if (inputPrice > 0) {
                    this.price = inputPrice;
                    break;
                } else {
                    System.err.println("phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("nhập số");
            }
        }
        while (true) {
            System.out.print("Nhập loại: ");
            String inputCat = scanner.nextLine().trim();
            if (inputCat.length() <= 200) {
                this.category = inputCat;
                break;
            } else {
                System.err.println("quá dài");
            }
        }

        while (true) {
            System.out.print("sstock: ");
            try {
                int inputQty = Integer.parseInt(scanner.nextLine());
                if (inputQty >= 0) {
                    this.quantity = inputQty;
                    break;
                } else {
                    System.err.println(" lớn hơn hoặc bằng 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("không hợp lệ");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Tên: %-20s | Giá: %-10.1f | Loại: %-15s | SL: %-5d",
                productId, productName, price, category, quantity);
    }
}
