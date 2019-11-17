package com.banhe.system.crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class NaverCrawler {


    public static void main(String[] args) {


        Arrays.asList("강아지샴푸","강아지미스트").forEach(x->getCrawler(x));


    }

    public static void getCrawler(String keyword){

        try {

//            String keyword = "강아지샴푸";
//            String keyword = "강아지미스트";
//            String keyword = "고양이샴푸";
//            String keyword = "고양이미스트";


            for(int i = 0; i < 10; i++) {
                Thread.sleep(1000); //1초 대기
                String listUrl = "https://search.shopping.naver.com/search/all.nhn?origQuery=강아지%20샴푸&pagingIndex="+i+"&pagingSize=40&productSet=model&viewType=list&sort=rel&frm=NVSHMDL&query="+keyword;

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

                        String optionValue = OptionSplit.getOption(title.text());
                        String stringTitle = title.text().replace(brand.text(),"");

                        stringTitle = stringTitle.replace(optionValue,"");

                        System.out.println(category.text()
                                +","
                                +stringTitle
                                +","
                                + price.text().replace(",","")
                                +","
                                +brand.text()
                                +","
                                +optionValue
                                +","
                                +title.text());

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
