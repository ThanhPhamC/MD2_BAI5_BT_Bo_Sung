package ra.dev;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private boolean productStatus;
    private Catalog catalog;

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice,
                   float exportPrice, int quantity, String descriptions, boolean productStatus, Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mã sản phẩm:");
        this.productId = sc.nextLine();
        for (int i = 0; i < Menu.indexProduct; i++) {
            if (Menu.listProduct[i].getProductId().equals(this.productId)) {
                System.err.println("Id đã tồn tại, hãy nhập Id mới: ");
                this.productId = sc.nextLine();
            }
        }
        System.out.println("Tên sản phẩm:");
        this.productName = sc.nextLine();
        for (int i = 0; i < Menu.indexProduct; i++) {
            if (Menu.listProduct[i].getProductName().equals(this.productName)) {
                System.err.println("Tên sản phẩm đã tồn tại, hãy nhập tên mới: ");
                this.productName = sc.nextLine();
            }
        }
        System.out.println("Tiêu đề:");
        this.title = sc.nextLine();
        System.out.println("Giá sản phẩm:");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Số lượng:");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Mô tả:");
        this.descriptions = sc.nextLine();
        System.out.println("Trạng thái sản phẩm:");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice * 1.2F;
    }

    public void displayData() {

        System.out.printf("%-15s%-20s%-15s%-15f%-15f%-10d%-20s%-15b%-15s\n", this.productId, this.productName, this.title, this.importPrice,
                this.exportPrice, this.quantity, this.descriptions, this.productStatus, this.catalog.catalogName);
    }
}


