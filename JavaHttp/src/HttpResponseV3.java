import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpResponseV3 {
    private  String version="HTTP/1.1";
    private int status;
    private String message;
    private final Map<String,String> headers=new HashMap<>();
    private StringBuilder body=new StringBuilder();
    private OutputStream outputStream;

    public static HttpResponseV3 build(OutputStream outputStream){
        HttpResponseV3 responseV3=new HttpResponseV3();
        responseV3.outputStream=outputStream;
        return responseV3;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public void writeBody(String content) {
        body.append(content);
    }


    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //处理首行，版本号+状态码+信息
        bufferedWriter.write(version + " " + status + " " + message + "\n");
        headers.put("Content-Length", body.toString().getBytes().length + "");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
