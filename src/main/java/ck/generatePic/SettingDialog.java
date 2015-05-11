package ck.generatePic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingDialog extends JDialog {

	private GeneratePic gp = new GeneratePic();
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtWidth;
	private JTextField txtHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SettingDialog dialog = new SettingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public GeneratePic getGP(){		
		return gp;
	}

	/**
	 * Create the dialog.
	 */
	public SettingDialog() {		
	
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("高度：");
			lblNewLabel.setBounds(23, 13, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBounds(66, 10, 103, 21);
			contentPanel.add(txtHeight);
			txtHeight.setColumns(10);
		}
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		txtWidth.setBounds(252, 10, 103, 21);
		contentPanel.add(txtWidth);
		
		JLabel label = new JLabel("宽度：");
		label.setBounds(212, 13, 54, 15);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						gp.setHeight(Integer.parseInt(txtHeight.getText()));
						gp.setWidth(Integer.parseInt(txtWidth.getText()));
						setVisible(false);								
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);			
				
			}
		}
	}
}
