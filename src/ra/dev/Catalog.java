package ra.dev;

import java.util.Scanner;

public class Catalog {
    public int catalogId;
    public String catalogName;
    public int priority;
    public boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    public void inputData(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Mã danh Mục: ");
         this.catalogId=Integer.parseInt(sc.nextLine());
        System.out.print("Tên danh mục: ");
        this.catalogName=sc.nextLine();
        System.out.print("Độ ưu tiên của danh mục: ");
        this.priority=Integer.parseInt(sc.nextLine());
        System.out.print("Trạng thái danh mục: ");
        this.catalogStatus=Boolean.parseBoolean(sc.nextLine());
    }
    public void displayData(){
        System.out.printf("%-15d%-20s%-15d%-15b\n",this.catalogId,this.catalogName,this.priority,this.catalogStatus);
    }
}
