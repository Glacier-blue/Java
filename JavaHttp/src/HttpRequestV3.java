import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestV3 {
    private String method;
    private String url;
    private String version;
    private String body;
    private final Map<String,String> cookies=new HashMap<>();
    private final Map<String,String> parameters=new HashMap<>();
    private final Map<String,String> headers=new HashMap<>();


    public static HttpRequestV3 build(InputStream inputStream) throws IOException {
        HttpRequestV3 requestV3=new HttpRequestV3();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        //处理首行
        String firstLine=bufferedReader.readLine();
        String[] firstLineToken=firstLine.split(" ");
        requestV3.method=firstLineToken[0];
        requestV3.url=firstLineToken[1];
        requestV3.version=firstLineToken[2];
        //处理url
        //url键值对之间用&分开，每个键值对的键值用=分开
        int pos=requestV3.url.indexOf("?");
        if(pos!=-1){
            String arr=requestV3.url.substring(pos+1);
            parseKV(arr,requestV3.parameters);
        }
        //处理header，每个键值对占一行，键值用=分开
        String line="";
        while((line=bufferedReader.readLine())!=null&&line.length()!=0){
            String[] result=line.split("=");
            requestV3.headers.put(result[0],result[1]);
        }
        //处理cookie,cookie是放在header中的，cookie用分号空格分开，键值用=分开
        String cookie=requestV3.headers.get("Cookie");
        if(cookie!=null) {
            parseCookie(cookie,requestV3.cookies);
        }
        if ("POST".equalsIgnoreCase(requestV3.method)
                || "PUT".equalsIgnoreCase(requestV3.method)){
            int conentLength=Integer.parseInt(requestV3.headers.get("Content-Length"));
            char[] buffer=new char[conentLength];
            int len=bufferedReader.read(buffer);
            requestV3.body=new String(buffer,0,len);
            parseKV(requestV3.body,requestV3.parameters);
        }
        return requestV3;
    }

    private static void parseCookie(String arr, Map<String, String> cookie) {
        String[] kvToken=arr.split("; ");
        for(String kv:kvToken){
            String[] result=kv.split("=");
            cookie.put(result[0],result[1] );
        }
    }

    private static void parseKV(String arr, Map<String, String> parameters) {
        String[] kvToken=arr.split("&");
        for(String kv:kvToken){
            String[] result=kv.split("=");
            parameters.put(result[0],result[1] );
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }
    public String getParameter(String key) {
        return parameters.get(key);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }
}
