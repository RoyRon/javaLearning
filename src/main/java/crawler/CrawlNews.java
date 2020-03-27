package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 江映锋
 * Create on 2019/05/14
 */
public class CrawlNews {
    /**
     * 将爬取url的信息存到本地文件中
     *
     * @param url
     */
    public static void saveHtml(String url) {
        File file = new File("html/sinaNews.html");
        FileOutputStream fileOutputStream;

        {
            try {
                fileOutputStream = new FileOutputStream(file);
                InputStream inputStream;
                URL url1 = new URL(url);
//                URLConnection urlConnection = url1.openConnection();
//                urlConnection.setRequestProperty("User-Agent",
//                        "Mozilla/5.0 "
//                                + "(iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
//                                + "AppleWebKit/533.17.9"
//                                + " (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");

                //获取url输入流
                inputStream = url1.openStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int length;
                byte[] bytes = new byte[1024];
                while ((length = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                    //将url输入流读取到的信息写入文件
                    bufferedOutputStream.write(bytes, 0, bytes.length);
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                fileOutputStream.close();
                inputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取新浪新闻列表网站的所有新闻标题和正文链接
     */
    public static void getTileAndContentURL() {
        String title;
        String contentUrl;
        File localHtml = new File("html/sinaNews.html");
        try {
//            Document doc=Jsoup.parse(localHtml,"UTF-8");
            //爬取网址的源文件信息
            Document doc = Jsoup.connect("http://news.sina.com.cn/hotnews/?q_kkhha").get();
//            System.out.println(doc);
            //获取所有classname是ConsTi的td标签信息
            Elements tds = doc.getElementsByClass("ConsTi");
//            System.out.println(tds);
            for (Element td : tds) {
                //获取每个td标签下的a标签信息
                Elements as = td.getElementsByTag("a");
                for (Element a : as) {
                    //获取a标签的文本信息
                    title = a.text();
                    //获取a标签href的值
                    contentUrl = a.attr("href");
//                    System.out.println(title);
//                    System.out.println(contentUrl);
                    saveInFile(title, contentUrl);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将获取的标题和正文链接存到本地文件
     *
     * @param title
     * @param contentUrl
     * @throws IOException
     */
    public static void saveInFile(String title, String contentUrl) throws IOException {
        File result = new File("html/result.txt");
        //一开始用了FileOutputStream(result)这个构造函数，每次写入数据都会覆盖原有数据，改成FileOutputStream(result, true)后新数据才不覆盖旧数据
        FileOutputStream fileOutputStream = new FileOutputStream(result, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(title + "  ");
        outputStreamWriter.write(contentUrl + "\r");
        outputStreamWriter.flush();
        fileOutputStream.close();
        outputStreamWriter.close();
    }

    @Test
    public void testSaveHtml() {
        saveHtml("http://news.sina.com.cn/hotnews/?q_kkhha");
    }

    @Test
    public void testGetTitleAndContentURL() {
        getTileAndContentURL();
    }

    @Test
    public void testSaveInFile() throws IOException {
        saveInFile("1", "aaaa");
        saveInFile("2", "bbbb");
    }

    @Test
    public void testWriteTitleAndContentURLIntoResultFile() {
        saveHtml("http://news.sina.com.cn/hotnews/?q_kkhha");
        getTileAndContentURL();
    }
}
