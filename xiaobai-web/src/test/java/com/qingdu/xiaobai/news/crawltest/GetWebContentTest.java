package com.qingdu.xiaobai.news.crawltest;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * jsoup 获取百度国内.即时新闻内容约十条 http://news.baidu.com/guonei
 * return 标题和链接
 * Created by q on 2020/1/17.
 */
public class GetWebContentTest {
    //从URL获取HTML来解析demo
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("http://news.baidu.com/guonei").get();
        System.out.println(doc.title());

        Elements links = doc.select("div#instant-news");
        if(CollectionUtils.isNotEmpty(links)){
            System.out.println(links.size());
            Elements children = links.get(0).children();
            if(CollectionUtils.isNotEmpty(children)){
                Elements lis = children.get(0).select("li");
                System.out.println(lis.size());
                for(Element e:lis){
                    System.out.println(e.text());
                    Elements as = e.select("a[href]");
                    System.out.println(as.get(0).attr("href"));
                }
            }
        }
    }
}
