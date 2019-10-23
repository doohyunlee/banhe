package com.banhe.crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class NaverCrawler {


    public static void main(String[] args) {

        try {


            for(int i = 0; i < 10; i++) {
                Thread.sleep(1000); //1초 대기
                String listUrl = "https://search.shopping.naver.com/search/all.nhn?origQuery=강아지%20샴푸&pagingIndex="+i+"&pagingSize=40&productSet=model&viewType=list&sort=rel&frm=NVSHMDL&query=강아지%20샴푸";

                Document ListDocument = Jsoup.connect(listUrl)
                        .timeout(5000)
                        .get();

                Elements urls = ListDocument.select("div.img_area>a");
                List<String> detailUrl = urls.stream().map(x -> x.attr("abs:href")).collect(Collectors.toList());
                detailUrl.forEach(url -> {

                    try {
                        Thread.sleep(1000); //1초 대기

                        Document document = Jsoup.connect(url)
                                .timeout(5000)
                                .get();

                        Elements title = document.select("div.h_area>h2:not(.blind)");
                        Elements price = document.select("em.num");
                        Elements brand = document.select("div.info_inner>span:first-child>em");
                        Elements category = document.select("span.s_nowrap a");

                        System.out.println(category.text() + "," + title.text() + "," + price.text().replace(",","") + "," +brand.text());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (InterruptedException ie){

                    }

                });
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException i){

        }
    }


}
