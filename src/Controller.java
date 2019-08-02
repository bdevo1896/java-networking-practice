import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Controller implements ActionListener{
	private View myView;
	
	public Controller() {
		myView = new View(this);
		//Server.send("Hello Bryce");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton btn = (JButton) arg0.getSource();
		
		if(btn.getText().equals("Send Message")){
			//Server.send(myView.getSendText());
			myView.update();
		}
		
		if(btn.getText().equals("Recieve")){
			//Client.recieve();
		}
	}
	
	public static void main(String[] args){
		Controller c = new Controller();
	}

}
