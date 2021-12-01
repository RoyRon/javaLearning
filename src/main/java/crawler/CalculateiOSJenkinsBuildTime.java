package crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author 江映锋
 * Created on 2021/12/1
 */
public class CalculateiOSJenkinsBuildTime {


    public static void main(String[] args) {
        String url = "https://jksclient.lizhi.fm/job/iOSLizhiFM-debug-develop/";
        {
            try {
                //获取的源码和网页不一致
                //    Document document = Jsoup.connect("https://jksclient.lizhi.fm/job/iOSLizhiFM-debug-develop/").get();

                //尝试添加请求头,未解决
//                Document document = Jsoup.connect("https://jksclient.lizhi.fm/job/iOSLizhiFM-debug-develop/").header("User-Agent",
//                        "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0").get();

                //网上查获取内容有大小为1024k的限制，增加不限制内容大小,未解决
//                    Document document = Jsoup.connect("https://jksclient.lizhi.fm/job/iOSLizhiFM-debug-develop/").timeout(50000000).maxBodySize(0).ignoreContentType(true).get();

                //改用parse的方式解析，未解决
//                    Document document = Jsoup.parse(new URL("https://jksclient.lizhi.fm/job/iOSLizhiFM-debug-develop/"),100000000);

               //使用htmlunit方式,解决获取不要动态加载的内容
                WebClient browser = new WebClient();
                browser.getOptions().setCssEnabled(false);
                browser.getOptions().setJavaScriptEnabled(true);
                browser.getOptions().setThrowExceptionOnScriptError(false);

                //获取页面
                HtmlPage htmlPage = browser.getPage(url);
                //设置等待js的加载时间
                browser.waitForBackgroundJavaScript(3000);

                //使用xml的方式解析获取到jsoup的document对象
                Document document = Jsoup.parse(htmlPage.asXml());

//                System.out.println(document);
                Element element = document.getElementsByClass("duration").get(4);
//                System.out.println(element);
                String timeString=element.text();
//                System.out.println(timeString);
                String min=timeString.substring(0,timeString.indexOf('m'));
//                System.out.println(min);
                String second=timeString.substring(timeString.indexOf(' ')+1,timeString.indexOf(' ')+3);
//                System.out.println(second);
                int buildTime=Integer.valueOf(min)*60+Integer.valueOf(second);
                System.out.println(buildTime);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
