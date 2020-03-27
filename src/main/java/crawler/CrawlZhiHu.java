package crawler;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * @author 江映锋
 * Create on 2019/08/09
 */
public class CrawlZhiHu {
    public String doPost(String url, Map<String, Object> map, String charset) {
        HttpClient httpClient;
        HttpPost httpPost;
        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        String result = null;
        try {
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost(url);

            List<NameValuePair> paraList = new ArrayList<>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                paraList.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
            }
            if (paraList.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(paraList, charset));
                httpResponse = httpClient.execute(httpPost);
            }

            if (httpResponse != null) {
                httpEntity = httpResponse.getEntity();
            }
            if (httpEntity != null) {
                result = EntityUtils.toString(httpEntity, charset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void crawl(String url, int offset) {
        String charSet = "utf-8";
        Map<String, Object> postMap = new HashMap<>();
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("limit", 20);
        paraMap.put("offset", offset);
        Gson gson = new Gson();
        String paraString = gson.toJson(paraMap);
        postMap.put("method", "next");
        postMap.put("params", paraString);
        String resultString = doPost(url, postMap, charSet);
        Map resultMap = gson.fromJson(resultString, Map.class);
        String html = resultMap.get("msg").toString();
//       System.out.println(html); //打印返回的html文本
        Document homePageDoc = Jsoup.parse(html);
//        System.out.println(homePageDoc.html()); //打印解析后的html的所有子元素
        Elements questions = homePageDoc.getElementsByClass("zm-item");
//        System.out.println(questions.outerHtml());//打印类名为"zm-item"的元素及其子元素
        for (Element question : questions) {
            Element h2 = question.getElementsByTag("h2").get(0); //getElementsByTag("h2").get(0)这一句返回的是h2标签  get(0)表示第一个h2标签
            Element a = h2.getElementsByTag("a").get(0);

//                        System.out.println(a.outerHtml()); //打印类名为"zm-item"的元素下的第一个h2子元素下的第一个a子元素及其子元素
            String questUrl = a.attr("href"); //返回上述a元素href属性的值

            //判断url是否有http://wwww.zhihu.com前缀，无则加上
            if (!questUrl.contains("https://")) {
                questUrl = "http://www.zhihu.com" + questUrl;
            }

            System.out.println(questUrl); //打印所有问题url
            try {
                File file=new File("html//zhihu.txt");
                FileWriter fileWriter=new FileWriter(file,true );
                Document detailDoc = Jsoup.connect(questUrl).get();
//                System.out.println(detailDoc.outerHtml());
                Element title = detailDoc.select("title").first();
                System.out.println(title.text());
                fileWriter.write("Title:"+title.text()+"\r\n");
                fileWriter.flush();
                Element content = null;
                if (!detailDoc.select("div.Post-RichTextContainer").isEmpty()) {
                    System.out.println("111111111111111111111111111111111111");
                    content = detailDoc.select("div.Post-RichTextContainer").first();
                } else if (!detailDoc.select("div.RichContent-inner").isEmpty()) {
                    content = detailDoc.select("div.RichContent-inner").first();
                    System.out.println("222222222222222222222222222222222222");
                }


                String contentString = content.text()+"\r\n";

//                System.out.println(contentString);
                System.out.println("333"+content.text()+"\r\n");
                fileWriter.write("答案："+contentString+"\r\n");
                fileWriter.write("\r\n"+"----------------------------------------------------------------------------------------------"+"\r\n");
                //一开始没加fileWriter.flush();和fileWriter.close();导致写入文件的文本不全（写入文件的文本比控制台打印出来的少），fileWriter.write（）只是把内容写到缓冲区，要缓冲区满了才会写入文件。
                // 缓冲区还没满，就执行for循环，又重新创建了一个fileWriter对象，导致上一个循环的部分内容没写入文件。每次执行write方法都调用fileWriter.flush();强制写入文件，就不会出现文件内写入的文本不全的问题了
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        crawl("https://www.zhihu.com/node/ExploreRecommendListV2", 2);

    }
}
