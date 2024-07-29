import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SecretMessagesGU extends JFrame {
	private JTextField txtKey;
	private JTextArea txtIn;
	private JTextArea txtout;
	private JSlider slider;


	public SecretMessagesGU() {
		getContentPane().setBackground(new Color(255, 228, 196));
		setAutoRequestFocus(false);
		getContentPane().setBounds(new Rectangle(598, 0, 600, 600));
		setTitle("Maksat Secrect Messages app");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		txtIn = new JTextArea();
		txtIn.setWrapStyleWord(true);
		txtIn.setLineWrap(true);
		txtIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIn.setBounds(10, 10, 794, 225);
		getContentPane().add(txtIn);

		txtout = new JTextArea();
		txtout.setWrapStyleWord(true);
		txtout.setLineWrap(true);
		txtout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtout.setBounds(10, 267, 794, 225);
		getContentPane().add(txtout);
		
		JButton btnNewButton = new JButton("Encode/Decode");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String message=txtIn.getText();
				int keyVal=Integer.parseInt(txtKey.getText());
				String output=encode(message,keyVal);
				txtout.setText(output);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Please enter a whole number value for the encryption key.");
					txtKey.requestFocus();
					txtKey.selectAll();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(505, 237, 164, 27);
		getContentPane().add(btnNewButton);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtKey.setHorizontalAlignment(SwingConstants.LEFT);
		txtKey.setText("3");
		txtKey.setBounds(399, 237, 56, 27);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("    Key:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(344, 237, 56, 31);
		getContentPane().add(lblNewLabel);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtKey.setText(""+slider.getValue());
				String message=txtIn.getText();
				int keyVal=Integer.parseInt(txtKey.getText());
				String output=encode(message,keyVal);
				txtout.setText(output);
				
			}
		});
		slider.setValue(3);
		slider.setFont(new Font("Times New Roman", Font.BOLD, 16));
		slider.setMajorTickSpacing(13);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setBackground(new Color(255, 255, 255));
		slider.setPaintLabels(true);
		slider.setBounds(131, 234, 200, 30);
		getContentPane().add(slider);
	}

	public String encode(String message, int keyVal) {
		String output = "";
		char key = (char) keyVal;
		for (int x = 0; x < message.length(); x++) {
			char input = message.charAt(x);
			if (input >= 'A' && input <= 'Z') {				
				input += key;
			if (input > 'Z')
				input -= 26;
			if (input < 'A')
				input += 26;
			}
			else if (input >= 'a' && input <= 'z') {				
				input += key;
			if (input > 'z')
				input -= 26;
			if (input < 'a')
				input += 26;
			}
			else if (input >= '0' && input <= '9') {
				input += (keyVal % 10);
			if (input > '9')
				input -= 10;
			if (input < '0')
				input += 10;
			}
			output += input;
		}
		return output;
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecretMessagesGU theApp = new SecretMessagesGU();
		theApp.setSize(new java.awt.Dimension(830,540));
		theApp.setVisible(true);

	}
}
