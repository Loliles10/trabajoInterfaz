package Experimentos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pwdContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        // Crea una instancia de ImageIcon con la ubicación de tu imagen
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Asus\\Downloads\\logo.jpeg"); // Reemplaza con la ubicación real de tu imagen

        
        

	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(324, 156, 100, 22);
		contentPane.add(textField);
		
		JButton btnInicioSesion = new JButton("Iniciar sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInicioSesion.setBounds(324, 215, 100, 23);
		contentPane.add(btnInicioSesion);
		
		pwdContrasea = new JPasswordField();
		pwdContrasea.setToolTipText("");
		pwdContrasea.setBounds(324, 184, 100, 20);
		contentPane.add(pwdContrasea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Asus\\Downloads\\logo3.jpg"));
		lblNewLabel.setBounds(96, 103, 184, 190);
		contentPane.add(lblNewLabel);
	}
}