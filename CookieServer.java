import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CookieServer {
    public static void main(String[] args) throws IOException{
        //Setup directory
        String dirPath = ".";
        String fileName = "cookie.txt";
        if (args.length>1){
            fileName = args[0];
        }
        File directory = new File(dirPath);
        if (directory.exists()){
            System.out.println("Directory already created");
        } else {
            directory.mkdir();
            System.out.println(fileName+" is now created");
        }
        //Create cookie
        Cookie cookie = new Cookie(dirPath,fileName);
        cookie.readCookieFile();
        //cookie.showCookies();
        //Setup port
        int port = 3000;
        if (args.length>0){
            port = Integer.parseInt(args[0]);
        }
        System.out.printf("Starting server on port %d\n",port);
        ServerSocket server = new ServerSocket(port);
        
        while (true){
            //Wait for a connection
            System.out.println("Waiting for incoming connection");
            Socket sConn = server.accept();
            System.out.println("Got a connection");
            //Get the input stream from the client
            //Run thread
            Thread thread1 = new Thread(new CookieClientHandler(sConn,cookie));
            // {
            //     @Override
            //     public void run(){
            //         handler.run();
            //     }    
            // });
            thread1.start();

            // sConn.close();
            // server.close();
        }
    }
}
