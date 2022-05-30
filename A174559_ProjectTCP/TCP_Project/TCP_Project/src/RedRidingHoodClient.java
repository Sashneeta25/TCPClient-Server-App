import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javazoom.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;

public class RedRidingHoodClient extends JFrame implements ActionListener{
	JTextField Client_input_textField;
	JTextField Server_output_textField;
	JLabel background;
	JButton btnNewButton;
	
	//TCP component
   	int port = 8081;
   	String host = "localhost";
       Socket nisSocket = null;
       PrintWriter out = null;
       BufferedReader in = null;

      
	public RedRidingHoodClient() throws IOException{
		this.setTitle("Red Riding Hood");
		this.setBounds(100, 100, 515, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(345, 249, 92, 39);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		Client_input_textField = new JTextField();
		Client_input_textField.setBackground(new Color(204, 255, 204));
		Client_input_textField.setBounds(10, 20, 263, 39);
		getContentPane().add(Client_input_textField);
		Client_input_textField.setColumns(10);
		
		Server_output_textField = new JTextField();
		Server_output_textField.setEditable(false);
		Server_output_textField.setColumns(10);
		Server_output_textField.setBackground(new Color(255, 255, 204));
		Server_output_textField.setBounds(10, 402, 481, 39);
		getContentPane().add(Server_output_textField);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(RedRidingHoodClient.class.getResource("/resources/knocking_door.jpg")));
		background.setBounds(0, 10, 499, 461);
		getContentPane().add(background);
		
		this.setVisible(true);
		
		 try {
	           nisSocket = new Socket(host, port);
	           out = new PrintWriter(nisSocket.getOutputStream(), true);
	           in = new BufferedReader(new InputStreamReader(nisSocket.getInputStream()));
	       } catch (UnknownHostException e) {
	           System.out.println(e.toString() + " :Don't know about " + host);
	           System.exit(1);
	       } catch (IOException e) {
	           System.out.println(e.toString() + " :Couldn't get I/O for the connection to " + host);
	           System.exit(1);
	       }
		 String fromServer, fromUser;        
	       fromServer = in.readLine();
          
	       Server_output_textField.setText(fromServer);
          //System.out.println("Server: " + fromServer);
          if (fromServer.equalsIgnoreCase("BYE RED RIDING HOOD!")) {
       	   System.exit(1);
          }
         
          
	}
	
	public static void main(String[] args) throws IOException {
		new RedRidingHoodClient();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 if (e.getSource().equals(btnNewButton)) {
	            try {
	                //TCP();
	            	 //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	     	       String fromServer, fromUser;        
	     	       //fromServer = in.readLine();
	                
	                //fromUser = stdIn.readLine();
	                fromUser = Client_input_textField.getText();
	                System.out.println(fromUser);
	                if (fromUser != null) {
	                	//System.out.println("\nClient: " + fromUser);
	                    out.println(fromUser); 
	                    if(Client_input_textField.getText().equalsIgnoreCase("Tok tok")) {
	       					try {
	       					FileInputStream fileInputStream = new FileInputStream("TCP_Project/src/knocking_door.mp3");
	       					Player player = new Player(fileInputStream);
	       					player.play();
	       					}catch(FileNotFoundException error) {
	       						error.printStackTrace();
	       					}
	       				catch(JavaLayerException error) {
	       					error.printStackTrace();
	       				}
	       			}
	       				if(Client_input_textField.getText().equalsIgnoreCase("Hello grandmother! I brought you some cake!")) {
	       					try {
	       					FileInputStream fileInputStream = new FileInputStream("TCP_Project/src/door_open.mp3");
	       					Player player1 = new Player(fileInputStream);
	       					player1.play();
	       					}catch(FileNotFoundException error) {
	       						error.printStackTrace();
	       					}
	       				catch(JavaLayerException error) {
	       					error.printStackTrace();
	       				}
	       			}
	       				
	       				if(Client_input_textField.getText().equalsIgnoreCase("Ahhhhhhhhhhhh!!!")) {
	       					try {
	       					FileInputStream fileInputStream = new FileInputStream("TCP_Project/src/wolfattack.mp3");
	       					Player player2 = new Player(fileInputStream);
	       					player2.play();
	       					}catch(FileNotFoundException error) {
	       						error.printStackTrace();
	       					}
	       				catch(JavaLayerException error) {
	       					error.printStackTrace();
	       				}
	       			}
	       				
	       				if(Client_input_textField.getText().equalsIgnoreCase("Ahhhhhhhhhhhh!!!")) {
	       					try {
	       					FileInputStream fileInputStream = new FileInputStream("TCP_Project/src/scream.mp3");
	       					Player player3 = new Player(fileInputStream);
	       					player3.play();
	       					}catch(FileNotFoundException error) {
	       						error.printStackTrace();
	       					}
	       				catch(JavaLayerException error) {
	       					error.printStackTrace();
	       				}
	       			}
	                    Client_input_textField.setText("");
	                }
	                TCP();
	              
	     	       	                
	            } catch (UnknownHostException e1) {
	                e1.printStackTrace();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	            
	            
   				//Grandmother dear, what big teeth you have!
   				
   				//Server_output_textField.setText(server);
   				
   				if(Server_output_textField.getText().equalsIgnoreCase("It's your grandmother Red Riding Hood! I'm waiting for you...")) {
   					
   					background.setIcon(new ImageIcon(RedRidingHoodClient.class.getResource("/resources/knocking_door.jpg")));
   					background.setBounds(0, 10, 499, 461);
   					getContentPane().add(background);
   					repaint();
   					
   			        }
   				
   				if(Server_output_textField.getText().equalsIgnoreCase("Put the cake on the counter and come close to me.")) {
   					
   					background.setIcon(new ImageIcon(RedRidingHoodClient.class.getResource("/resources/big.jpg")));
   					background.setBounds(0, 10, 499, 461);
   					getContentPane().add(background);
   					repaint();
   					
   				}
   				
   				if(Server_output_textField.getText().equalsIgnoreCase("The better to eat you with!")) {
   					
   					background.setIcon(new ImageIcon(RedRidingHoodClient.class.getResource("/resources/to_eat.jpg")));
   					background.setBounds(0, 10, 499, 461);
   					getContentPane().add(background);
   					repaint();
   					
   			        }

	            
	            
	        }
	}
	
	public void TCP() throws IOException{
	 	

	       //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	       String fromServer, fromUser;        
	       fromServer = in.readLine();
	       Server_output_textField.setText(fromServer);
           //System.out.println("Server: " + fromServer);
           if (fromServer.equalsIgnoreCase("BYE RED RIDING HOOD!")) {
        	   System.exit(1);
           }
           
           //fromUser = stdIn.readLine();
        
	          
	       
	       
	           
	}
	




}
