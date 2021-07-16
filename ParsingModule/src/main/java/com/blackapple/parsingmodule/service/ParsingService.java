package com.blackapple.parsingmodule.service;

import com.blackapple.parsingmodule.kafka.ItemProducer;
import com.blackapple.parsingmodule.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParsingService {


    private ItemProducer itemProducer;

    @Autowired
    public ParsingService(ItemProducer itemProducer) {
        this.itemProducer = itemProducer;
    }

    public void parsinger() {

        Document mainPage = null;

        try {
            mainPage = Jsoup.connect("https://www.pepper.ru").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements webItems = mainPage.select("a.cept-tt");

        for (Element el : webItems) {
            System.out.println(el.attr("href"));
            parsePageItem(el.attr("href"));
        }
    }

    public void parsePageItem(String address) {
        Document page = null;

        try {
            page = Jsoup.connect(address).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element titleEl = page.select("span.thread-title--item").first();
        Element priceEl = page.select("span.thread-price").first();
        Element merchantEl = page.select("span.cept-merchant-name").first();
        Element describerEl = page.select("div.cept-description-container").first();

        String title, price, merchant, describer;
        if (titleEl != null) title = titleEl.text();
        else title = "";
        if (priceEl != null) price = priceEl.text();
        else price = "";
        if (merchantEl != null) merchant = merchantEl.text();
        else merchant = "";
        if (describerEl != null) describer = describerEl.text();
        else describer = "";

        Item item = new Item(title, price, merchant, describer);

        System.out.println(item);
        itemProducer.sendItem("ssr", item);

    }
}