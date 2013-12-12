import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;


public class ClientSocketThread extends Thread{
	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dout;
	private int port;
	
	public ClientSocketThread(InetAddress addr,int port,String clientName){
		try{
			socket = new Socket(addr,port);
			din=new DataInputStream(socket.getInputStream());
			dout=new DataOutputStream(socket.getOutputStream());
			start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void run(){
		try{
			System.out.println(getName());
			String str;
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("link succeed");
			
			while(true){
				System.out.println("input your message:");
				str=sin.readLine();
				dout.writeUTF(str);
				dout.flush();
				if(str.trim().equals("bye"))break;
				str=din.readUTF();
				System.out.println("the message from server is:"+str);
				if(str.trim().equals("bye")) break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
