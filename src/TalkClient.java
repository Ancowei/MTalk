import java.net.InetAddress;


public class TalkClient {
	public static void main(String[] args) {
		try{
			new ClientSocketThread(InetAddress.getLocalHost(),2000,"client1");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
