package fullstackplan.InternetProgram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        URL realUrl = null;
        try {
            realUrl = new URL(urlName);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0(compatible;MISE 6.0;Windows NT 5.1;SV1)");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "---->" + map.get(key));
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "---------------------\n" + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String sendPost(String url, String param) {
        String result = "";
        URL realUrl = null;
        try {
            realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            PrintWriter out=new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "---------------------\n" + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[]args){
       System.out.println(sendGet("https://www.baidu.com/s?" ,
               "ie=utf-8&f=8&rsv_bp=1&ch=15&tn=56060048_4_pg&wd=Array%20reference%20expected&oq=qq&rsv_pq=e3513b680003e9af&rsv_t=dfefpESmGlJNhA8AkQrCtoFaakQFnNIkCcrlZuD65oJWcuCutn0kyPUGYqnEIOwn0tqvvg&rqlang=cn&rsv_enter=0&rsv_n=2&rsv_sug3=1&inputT=1362&rsv_sug4=1362"));
   System.out.println(sendPost("http://stackoverflow.com/questions/49456234/array-reference-expected-java",""));
    }
}
