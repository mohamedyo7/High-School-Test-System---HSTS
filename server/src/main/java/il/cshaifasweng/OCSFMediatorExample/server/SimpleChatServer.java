package il.cshaifasweng.OCSFMediatorExample.server;

public class SimpleChatServer {

    private static SimpleServer server;

    public static void main(String[] args) throws Exception {
        server = new SimpleServer(3000);
        server.listen();
        App.main(args);
        System.out.println("server is listening");
    }
}