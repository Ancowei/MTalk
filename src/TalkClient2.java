import java.net.InetAddress;


public class TalkClient2 {
	public static void main(String[] args) {
		try{
			new ClientSocketThread(InetAddress.getLocalHost(),2000,"client2");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
