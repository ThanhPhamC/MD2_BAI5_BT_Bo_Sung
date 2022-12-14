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
        System.out.println("M?? s???n ph???m:");
        this.productId = sc.nextLine();
        while (this.productId.trim().length() == 0) {
                System.err.println("Kh??ng ???????c ????? tr???ng ID, m???i nh???p l???i: ");
                this.productId = sc.nextLine();
        }
        if (Menu.indexProduct != 0) {
            boolean checkpoint = true;
            while (checkpoint) {
                for (int i = 0; i < Menu.indexProduct; i++) {
                    if (Menu.listProduct[i].getProductId().equals(this.productId ) || this.productId.trim().length() == 0 ) {
                        System.err.println("Id ???? t???n t???i ho???c ????? tr???ng, h??y nh???p Id m???i: ");
                        this.productId = sc.nextLine();
                        break;
                    } else {
                        checkpoint = false;
                    }
                }
            }
        }
        System.out.println("T??n s???n ph???m:");
        this.productName=sc.nextLine();
        while (this.productName.trim().length() == 0) {
                System.err.println("Kh??ng ???????c ????? tr???ng Name, m???i nh???p l???i: ");
                this.productName = sc.nextLine();
        }
        if (Menu.indexProduct != 0) {
            boolean checkpoint = true;
            while (checkpoint) {
                for (int i = 0; i < Menu.indexProduct; i++) {
                    if (Menu.listProduct[i].getProductName().equals(this.productName)||this.productName.trim().length() == 0 ) {
                        System.err.println("T??n s???n ph???m ???? t???n t???i, h??y nh???p t??n m???i: ");
                        this.productName = sc.nextLine();
                        break;
                    } else {
                        checkpoint = false;
                    }
                }
            }
        }
        System.out.println("Ti??u ?????:");
        this.title = sc.nextLine();
        System.out.println("Gi?? s???n ph???m:");
        String inputPrice = sc.nextLine();
        boolean checkPrice = true;
        while (checkPrice) {
            if (inputPrice.trim().length() == 0 || Float.parseFloat(inputPrice) == 0) {
                System.err.println("Kh??ng ???????c ????? tr???ng v?? gi?? ph???i kh??c \"0\",h??y nh???p l???i: ");
                inputPrice = sc.nextLine();
            } else {
                checkPrice = false;
            }
        }
        this.importPrice = Float.parseFloat(inputPrice);
        System.out.println("S??? l?????ng:");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("M?? t???:");
        this.descriptions = sc.nextLine();
        System.out.println("Tr???ng th??i s???n ph???m:");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice * 1.2F;
    }

    public void displayData() {
        System.out.printf("|   %-12s|     %-15s|     %-10s|  %-13s|  %-13s| %-9s|    %-16s| %-14s|    %-11s|\n", this.productId, this.productName, this.title, this.importPrice,
                this.exportPrice, this.quantity, this.descriptions, this.productStatus, this.catalog.catalogName);
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+\n");
    }
}


