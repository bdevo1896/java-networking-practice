import java.lang.*;
import java.io.*;
import java.net.*;
class Client {
	private String name;
	
	public Client(String name){
		this.name = name;
	}
	
//	public static void recieve(){
//		try {
//			Socket skt = new Socket("localhost", 60534);
//			BufferedReader in = new BufferedReader(new
//					InputStreamReader(skt.getInputStream()));
//			System.out.print("Received string: '");
//			while (!in.ready()) {}
//			System.out.println(in.readLine()); // Read one line and output it
//			System.out.print("'\n");
//			in.close();
//		}
//		catch(Exception e) {
//			System.out.print("Whoops! It didn't work!\n");
//		}
//	}
	
	public static void main(String args[]) {
		String response = "BACK_AT_YA BRYCE\nBROSKI\n\n";
		String data = "";
	      try {
	         Socket skt = new Socket("localhost", 60534);
	         BufferedReader in = new BufferedReader(new
	            InputStreamReader(skt.getInputStream()));
	         System.out.print("Received string: ");

	         while (!in.ready()) {}
	         data = in.readLine();
	         System.out.print(data+"\n");
	         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
	         switch(data){
	         case "HI_THERE BRYCE":
	        	 out.print(response);
		         out.flush();
		         break;
	         default:
	        	response = "ERROR_BAD_HANDSHAKE\n\n";
	        	 out.print(response);
	         }
	         in.close();
	      
	         System.out.print( response + "\n");
	         out.close();
	         skt.close();
	         
	         //System.out.println(response);
	      }
	      catch(Exception e) {
	         System.out.print("Whoops! It didn't work!\n");
	      }
	   }
	
//	   public static void main(String args[]) {
//		      try {
//		         Socket skt = new Socket("localhost", 1234);
//		         BufferedReader in = new BufferedReader(new
//		            InputStreamReader(skt.getInputStream()));
//		         System.out.print("Received string: '");
//
//		         while (!in.ready()) {}
//		         System.out.println(in.readLine()); // Read one line and output it
//
//		         System.out.print("'\n");
//		         in.close();
//		      }
//		      catch(Exception e) {
//		         System.out.print("Whoops! It didn't work!\n");
//		      }
//		   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}