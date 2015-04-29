package ck.generatePic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class MainFrame {
	
	private GeneratePic gp = new GeneratePic();

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("文本");
		lblNewLabel.setBounds(10, 14, 61, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(41, 10, 331, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenerate = new JButton("生成");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, textField.getText());
				
			}
		});
		btnGenerate.setBounds(372, 10, 62, 23);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnSave = new JButton("保存");
		btnSave.setBounds(372, 229, 62, 23);
		frame.getContentPane().add(btnSave);
	}
	
	private void generate(JLabel container, String text){
		BufferedImage bi = gp.generate(text);
		
	}
}
