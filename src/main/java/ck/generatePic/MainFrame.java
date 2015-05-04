package ck.generatePic;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class MainFrame {

	private GeneratePic gp = new GeneratePic();
	BufferedImage bi = null;

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

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 39, 414, 189);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		final JLabel lblPic = new JLabel("");
		panel.add(lblPic, BorderLayout.CENTER);

		JButton btnGenerate = new JButton("生成");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bi = gp.generate(textField.getText());
				ImageIcon icon = new ImageIcon(bi);
				lblPic.setIcon(icon);
			}
		});
		btnGenerate.setBounds(372, 10, 62, 23);
		frame.getContentPane().add(btnGenerate);

		JButton btnSave = new JButton("保存");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (bi != null) {
					try {
						JFileChooser save = new JFileChooser();
						save.setFileFilter(new FileNameExtensionFilter("GIF文件", "gif"));						
						if (JFileChooser.APPROVE_OPTION == save
								.showSaveDialog(frame)) {							
							ImageIO.write(bi, "gif", new File(save.getSelectedFile().getPath()+".gif"));
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnSave.setBounds(372, 229, 62, 23);
		frame.getContentPane().add(btnSave);
	}

}
