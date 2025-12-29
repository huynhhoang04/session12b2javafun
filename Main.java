package ra.presentation;

import ra.business.ProductBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n**************** QUẢN LÝ SẢN PHẨM ****************");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Sắp xếp sản phẩm theo số lượng giảm dần");
            System.out.println("8. Thoát");
            System.out.println("**************************************************");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    ProductBusiness.addProduct(scanner);
                    break;
                case 2:
                    ProductBusiness.displayProducts();
                    break;
                case 3:
                    ProductBusiness.updateProduct(scanner);
                    break;
                case 4:
                    ProductBusiness.deleteProduct(scanner);
                    break;
                case 5:
                    ProductBusiness.searchByName(scanner);
                    break;
                case 6:
                    ProductBusiness.sortByPriceAsc();
                    break;
                case 7:
                    ProductBusiness.sortByQuantityDesc();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 8.");
            }

        } while (choice != 8);
    }
}
