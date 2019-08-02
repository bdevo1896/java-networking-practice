import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class View extends JFrame{
	
	private static final int TEXTBOX_LENGTH = 20;
	private JTextField userText;
	private JButton sendBtn,receiveBtn;
	private JTextArea textArea;
	

	public View(Controller c) {
		this.setTitle("ChatMe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500,500));
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		textArea = new JTextArea("Messages will be diplayed here.\n");
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainPanel.add(scroll, BorderLayout.CENTER);
		
		JPanel southPnl = new JPanel();
		southPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		receiveBtn = new JButton("Receive");
		receiveBtn.addActionListener(c);
		
		sendBtn = new JButton("Send Message");
		sendBtn.addActionListener(c);
		
		userText = new JTextField("Hi! Enter Messages Here",TEXTBOX_LENGTH);
		userText.setVisible(true);
		
		southPnl.add(receiveBtn);
		southPnl.add(sendBtn);
		southPnl.add(userText);
		mainPanel.add(southPnl,BorderLayout.SOUTH);
		
		this.getContentPane().add(mainPanel);
		this.pack();
	}
	
	public synchronized void update(){
		this.addMessage(userText.getText());
		userText.setText("");
		this.repaint();
	}
	
	public void addMessage(String data){
		String str = textArea.getText();
		str += "\n"+data;
		textArea.setText(str);
	}
	
	public String getSendText(){
		return userText.getText();
	}

}
