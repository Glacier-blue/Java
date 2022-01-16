import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestV2 {
    private String method;
    private String url;
    private String version;
    private Map<String,String> headers=new HashMap<>();
    private Map<String,String> parameters=new HashMap<>();
    public static HttpRequestV2 build(InputStream inputStream ) throws IOException {
        HttpRequestV2 request=new HttpRequestV2();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        //GET http://ehall.xidian.edu.cn/login?service=http://ehall.xidian.edu.cn/new/index.html
        //方法-网站域名-路径-查询字符串
        String firstLine=bufferedReader.readLine();
        String[] firstLineTokens=firstLine.split(" ");
        request.method=firstLineTokens[0];
        request.url=firstLineTokens[1];
        request.version=firstLineTokens[2];
        //找到这个问号，url问号后面都是查询字符串
        int pos=request.url.indexOf("?");
        if(pos!=-1){
            //键和值用=连接，每个键值对用&连接，先用&分割字符串，然后分割=写入map
            String tmp=request.url.substring(pos+1);
            String[] arr=tmp.split("&");
            for(String kv:arr){
                String[] result=kv.split("=");
                request.parameters.put(result[0],result[1]);
            }
        }
        //header部分的键值对，每行一个键值对，键值用冒号空格分开
        String line="";
        while((line=bufferedReader.readLine())!=null&&line.length()!=0){
            String[] headerTokens=line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1] );
        }
        return request;
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
    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }
}
