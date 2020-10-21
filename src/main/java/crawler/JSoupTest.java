package crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 光影风
 * @description: TODO 爬虫练习
 * @date 2019/4/18 0:55
 */
public class JSoupTest {

    @Test
    public void getBaidu() throws IOException {
        Connection conn = Jsoup.connect("https://www.baidu.com/");
        Document document = conn.get();
        //获取id为“u1”的div元素
        Element element = document.getElementById("u1");
//        System.out.println(element);
        //获取上面div下的所有a标签
        Elements a = element.getElementsByTag("a");
//        System.out.println(a);
        for (Element element1 : a) {
            //获取a标签下所有href属性的值
            String link = element1.attr("href");
            //获取所有a标签的文本
            String text = element1.text();
            /*
            打印结果为：
            新闻:http://news.baidu.com
            hao123:https://www.hao123.com
           地图:http://map.baidu.com
           视频:http://v.baidu.com
           贴吧:http://tieba.baidu.com
           登录:http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1
          更多产品://www.baidu.com/more/
            * */
            System.out.println(text + ":" + link);
        }
    }

    @Test
    public void getBokeyuan() throws IOException {
        Document document = Jsoup.connect("https://www.cnblogs.com/").get();
        Elements posts = document.getElementById("post_list").getElementsByClass("post_item");
        for (Element post : posts) {
            String title = post.getElementsByClass("post_item_body").get(0).getElementsByTag("h3").text();
            String summay = post.getElementsByClass("post_item_body").get(0).getElementsByTag("p").text();

            System.out.println(title);
            System.out.println(summay);
            System.out.println();
        }
    }

    @Test
    public void getBokeyuanWithSelect() throws IOException {
        Document document = Jsoup.connect("https://www.cnblogs.com/").get();
        Elements posts = document.getElementById("post_list").getElementsByClass("post_item");
        for (Element post : posts) {
            String title = post.select(".post_item_body h3").text();
            String summay = post.select(".post_item_body p").text();

            System.out.println(title);
            System.out.println(summay);
            System.out.println();
        }
    }

    @Test
    public void getImg() throws Exception{
        Document document=Jsoup.connect("https://www.cnblogs.com/").get();
        Elements imgs=document.select("img");
        for (Element img:imgs){
          String src=  img.attr("abs:src");
          System.out.println(src);
        }
    }
}
