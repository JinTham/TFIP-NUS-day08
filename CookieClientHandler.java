import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CookieClientHandler implements Runnable {
    private Socket sConn;
    private Cookie cookie;
    //Constructor
    public CookieClientHandler(Socket sConn, Cookie cookie){
        this.sConn = sConn;
        this.cookie = cookie;
    }
    //Method
    @Override
    public void run(){ 
        System.out.println(Thread.currentThread().getName());
        try {
            InputStream is = sConn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String msgReceived = "";
            try {
                OutputStream os = sConn.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);
                while (!msgReceived.equals("close")){
                    msgReceived = dis.readUTF();
                    if (msgReceived.equalsIgnoreCase("get-cookie")){
                        String cookieValue = cookie.returnCookie();
                        System.out.println(cookieValue);
                        dos.writeUTF(cookieValue);
                        dos.flush();
                    }
                }
                dos.close();
                bos.close();
                os.close();
            } catch (EOFException ex){
                ex.printStackTrace();
            }
            dis.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
