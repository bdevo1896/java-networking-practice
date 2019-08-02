import java.io.*;
import java.net.*;
import java.lang.*;

class Server {
	private String name;
	
	public Server(String name){
		this.name = name;
	}
	
//	public static void send(String sendData){
//		String data = sendData;
//		try {
//			ServerSocket srvr = new ServerSocket(60534);
//			Socket skt = srvr.accept();
//			System.out.print("Server has connected!\n");
//			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
//			System.out.print("Sending string: '" + data + "'\n");
//			out.print(data);
//			out.close();
//			skt.close();
//			srvr.close();
//		}
//		catch(Exception e) {
//			System.out.print("Whoops! It didn't work!\n");
//		}
//	}
	
	public static void main(String args[]) {
	      String data = "HI_THERE BRYCE\n\n";
	      try {
	         ServerSocket srvr = new ServerSocket(60534);
	         Socket skt = srvr.accept();
	         BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	         System.out.print("Server has connected!\n");
	         
	         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
	         System.out.print("Sending: "+data + "\n");
	         out.print(data);
	         out.flush();
	         while(!in.ready()){}
	         System.out.println(in.readLine());
	         
	         out.close();
	         skt.close();
	         srvr.close();
	      }
	      catch(Exception e) {
	         System.out.print("Whoops! It didn't work!\n");
	      }
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}