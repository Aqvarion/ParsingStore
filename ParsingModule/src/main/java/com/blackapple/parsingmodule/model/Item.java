package com.blackapple.parsingmodule.model;

public class Item {

    private String title;
    private String price;
    private String merchant;
    private String describer;


    public Item(String title, String price, String merchant, String describer) {
        this.title = title;
        this.price = price;
        this.merchant = merchant;
        this.describer = describer;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getDescriber() {
        return describer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", merchant='" + merchant + '\'' +
                ", describer='" + describer + '\'' +
                '}';
    }
}
