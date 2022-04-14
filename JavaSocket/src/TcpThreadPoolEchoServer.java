import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TcpThreadPoolEchoServer {
    private ServerSocket socket=null;
    public TcpThreadPoolEchoServer(int num) throws IOException {
        socket=new ServerSocket(num);
    }
    public void start() throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket=socket.accept();
            executorService.execute(new Runnable(){
                @Override
                public void run(){
                    processConnection(clientSocket);
                }
            });
        }
    }
    public void processConnection(Socket clientSocket){
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            while(true){
                String request=bufferedReader.readLine();
                String response=process(request);
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer tcpThreadPoolEchoServer=new TcpThreadPoolEchoServer(1234);
        tcpThreadPoolEchoServer.start();
    }
}
