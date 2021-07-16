package com.blackapple.downloadmodule.model;

import javax.persistence.*;

@Entity
@Table(name = "item", schema = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String price;
    private String merchant;
    private String describer;


    public Item() {
    }

    public Item(String title, String price, String merchant, String describer) {
        this.title = title;
        this.price = price;
        this.merchant = merchant;
        this.describer = describer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
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

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
