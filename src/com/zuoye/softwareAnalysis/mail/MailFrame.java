package com.zuoye.softwareAnalysis.mail;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MailFrame extends JFrame{

	private JPanel contentPane;
	private JTextField textFieldFromAddress;
	private JTextField textFieldToAddress;
	private JTextField textFieldSubject;
	private JTextField textFieldContent;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailFrame frame = new MailFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFromaddress = new JLabel("fromAddress");
		lblFromaddress.setBounds(10, 10, 66, 15);
		contentPane.add(lblFromaddress);
		
		textFieldFromAddress = new JTextField();
		textFieldFromAddress.setBounds(86, 10, 338, 21);
		contentPane.add(textFieldFromAddress);
		textFieldFromAddress.setColumns(10);
		
		JLabel lblToaddress = new JLabel("toAddress");
		lblToaddress.setBounds(10, 35, 54, 15);
		contentPane.add(lblToaddress);
		
		textFieldToAddress = new JTextField();
		textFieldToAddress.setColumns(10);
		textFieldToAddress.setBounds(86, 32, 338, 21);
		contentPane.add(textFieldToAddress);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(10, 60, 54, 15);
		contentPane.add(lblSubject);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setColumns(10);
		textFieldSubject.setBounds(86, 57, 338, 23);
		contentPane.add(textFieldSubject);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(10, 85, 54, 15);
		contentPane.add(lblContent);
		
		textFieldContent = new JTextField();
		textFieldContent.setBounds(10, 110, 424, 102);
		contentPane.add(textFieldContent);
		textFieldContent.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.setBounds(10, 228, 93, 23);
		contentPane.add(btnSend);
		
		JLabel lblUserpassword = new JLabel("UserPassword");
		lblUserpassword.setBounds(113, 230, 86, 19);
		contentPane.add(lblUserpassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(207, 229, 217, 22);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnSend.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print("yes");
				String fromAddress = textFieldFromAddress.getText();
				String toAddress = textFieldToAddress.getText();
				String subject = textFieldSubject.getText();
				String content = textFieldContent.getText();
				String fromPassword = textFieldPassword.getText();
				try {
					MailUtil.sendMail(fromAddress, toAddress, fromPassword, subject, content);
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}


}
