package il.cshaifasweng.OCSFMediatorExample.server;

public class SimpleChatServer {

    private static SimpleServer server;

    public static void main(String[] args) throws Exception {
        server = new SimpleServer(3000);
        server.listen();
        System.out.println("App main end111111111111");

        App.main(args);

        System.out.println("App main end11111111111122222");
        System.out.println("server is listening");
    }
}