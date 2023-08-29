import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpSampleServer {
    public static void main(String[] args) {
        try {
            // create http server to bind 8080
            HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080), 0);
            // bind path
            server.createContext("/", new MyHandler());
            server.start();
            System.out.println("Http Sever started on port 8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements HttpHandler {
        // 设置响应头c
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello from the local HTTP server!";
            exchange.sendResponseHeaders(200, response.getBytes().length);

            // 获取输出流并写入响应内容
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
