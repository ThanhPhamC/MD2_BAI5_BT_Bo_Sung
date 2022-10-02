package ra.dev;

import java.util.Scanner;

public class Menu {
    static Catalog[] listCatalog = new Catalog[100];
    static int indexCatalog = 0;
    static Product[] listProduct = new Product[1000];
    static int indexProduct = 0;
    static Scanner sc = new Scanner(System.in);

    //****************************QUẢN LÝ DANH MỤC******************************
    public static void displayMenu1() {
        do {
            System.out.println("********************QUẢN LÝ DANH MỤC*****************");
            System.out.println("1. Nhập thông tin n danh mục");
            System.out.println("2. Hiển thị thông tin danh mục theo độ ưu tiên");
            System.out.println("3. Cập nhật thông tin danh mục theo mã danh mục");
            System.out.println("4. Thoát (Trở lại menu Quản lý cửa hàng)");
            System.out.print("Lựa chọn của bạn là: ");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog) {
                case 1:
                    addCatalog(sc);
                    break;
                case 2:
                    showListCatalog();
                    break;
                case 3:
                    editListCatalog();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    // ---------------------thêm danh mục-------------------
    public static void addCatalog(Scanner sc) {
        System.out.print("Nhập số lượng muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Danh mục thứ: " + (i + 1));
            listCatalog[indexCatalog] = new Catalog();
            listCatalog[indexCatalog].inputData();
            indexCatalog++;
        }
    }

    //-------------------sắp xếp theo mức độ ưu tiên----------------------
    public static void showListCatalog() {
        Catalog temp;
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = i + 1; j < indexCatalog; j++) {
                if (listCatalog[i].getPriority() > listCatalog[j].getPriority()) {
                    temp = listCatalog[i];
                    listCatalog[i] = listCatalog[j];
                    listCatalog[j] = temp;
                }
            }
        }
        System.out.printf("%-15s%-20s%-15s%-15s\n", "CatalogId", "CatalogName", "Priority", "CatalogStatus");
        for (int i = 0; i < indexCatalog; i++) {
            listCatalog[i].displayData();
        }
    }

    //-----------------------Cập nhập thông tin theo mã danh mục---------------------
    public static void editListCatalog() {
        System.out.print("Nhập mã danh mục muốn cập nhập: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < indexCatalog; i++) {
            if (listCatalog[i].getCatalogId() == n) {
                System.out.print("Tên cũ: (" + listCatalog[i].getCatalogName() + "); Tên mới là: ");
                listCatalog[i].setCatalogName(sc.nextLine());
                System.out.print("Mức độ ưu tiên cũ: (" + listCatalog[i].getPriority() + "); Mức độ mới là: ");
                listCatalog[i].setPriority(Integer.parseInt(sc.nextLine()));
                System.out.print("Trạng thái cũ: (" + listCatalog[i].isCatalogStatus() + "); Trạng thái mới là: ");
                listCatalog[i].setCatalogStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.println("Cập nhập thành công");
            }
        }
    }

    //********************QUẢN LÝ SẢN PHẨM*****************
    public static void displayMenu2() {
        do {
            System.out.println("********************QUẢN LÝ SẢN PHẨM*****************");
            System.out.println("1. Nhập thông tin cho n sản phẩm");
            System.out.println("2. Tính giá bán cho tất cả sản phẩm");
            System.out.println("3. Hiển thị thông tin các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng (quantity<=5)");
            System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("8. Thoát (Trở lại menu Quản lý cửa hàng)");
            int choiceCase2 = Integer.parseInt(sc.nextLine());
            switch (choiceCase2) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    calExportPriceListProduct();
                    break;
                case 3:
                    showListproduct();
                    break;
                case 4:
                    sortlistProduct();
                    break;
                case 5:
                    searchListproduct();
                    break;
                case 6:
                    countlistProduct();
                    break;
                case 7:
                    updateProductStatus();
                    break;
                case 8:
                    return;
            }
        } while (true);
    }

    //---------------------- add them san pham vao list----------------------
    public static void addProduct(Scanner sc) {
        System.out.println("Nhập ID của catalog muốn thêm sản phẩm: ");
        int idinput = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < indexCatalog; i++) {
            if (listCatalog[i].getCatalogId() == idinput) {
                System.out.println("Nhập số lượng sản phẩm muốn thêm vào danh mục " + listCatalog[i].getCatalogName());
                int count = Integer.parseInt(sc.nextLine());
                for (int j = 0; j < count; j++) {
                    listProduct[indexProduct] = new Product();
                    listProduct[indexProduct].inputData();
                    listProduct[indexProduct].setCatalog(listCatalog[i]);
                    indexProduct++;
                }
            }
        }
    }

    //-----------------------tinh gia cho cac san pham-------------------------
    public static void calExportPriceListProduct() {
        for (int i = 0; i < indexProduct; i++) {
            listProduct[i].calExportPrice();
        }
        System.out.println("Đã tính xong giá cho các sản phẩm");
    }


    //------------------------hien thi cac san pham---------------------------------
    public static void showListproduct() {
        System.out.printf("%-15s%-20s%-15s%-15s%-15s%-10s%-20s%-15s%-15s\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            listProduct[i].displayData();
        }
    }

    //--------------------sap xep theo gia ban tang dan---------------------------------
    public static void sortlistProduct() {
        Product temp;
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (listProduct[i].getExportPrice() > listProduct[j].getExportPrice()) {
                    temp = listProduct[i];
                    listProduct[i] = listProduct[j];
                    listProduct[j] = temp;
                }
            }
        }
    }

    //--------------Tìm kiếm sản phẩm theo tên sản phẩm------------------------------------
    public static void searchListproduct() {
        System.out.print("Nhập tên sản phẩm muốn tìm kiếm: ");
        String inputSearch = sc.nextLine();
        System.out.printf("%-15s%-20s%-15s%-15s%-15s%-10s%-20s%-15s%-15s\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getProductName().startsWith(inputSearch)) {
                listProduct[i].displayData();
            }
        }
    }
    //------------------Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng (quantity<=5)-------------
    public static void countlistProduct(){
        int count=0;
        System.out.printf("%-15s%-20s%-15s%-15s%-15s%-10s%-20s%-15s%-15s\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getQuantity()<=5){
                listProduct[i].displayData();
                count++;
            }
        }
        System.out.println(" số lượng sản phẩm sắp hết hàng là: "+count );
    }
    //---------------Cập nhật trạng thái của sản phẩm theo mã sản phẩm--------------------------
    public static void updateProductStatus(){
        System.out.println("Nhập Id sản phẩm muốn update: ");
        String inputID=sc.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getProductId().equals(inputID)){
                listProduct[i].setProductStatus(!listProduct[i].isProductStatus());
            }
        }
        System.out.println("Đã cập nhập trạng thái thành công !");
    }
}
