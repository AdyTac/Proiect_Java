import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginServiceAuto extends JFrame {

	private JPanel contentPane;
	private JTextField textUtilizator;
	private JPasswordField passwordParola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginServiceAuto frame = new LoginServiceAuto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginServiceAuto() {
		setResizable(false);
		setForeground(SystemColor.activeCaption);
		setTitle("Login Service Auto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 199);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Autentificare");
		btnNewButton.setBounds(141, 114, 149, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Utilizator");
		lblNewLabel.setBounds(48, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setBounds(48, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textUtilizator = new JTextField();
		textUtilizator.setBounds(105, 32, 222, 20);
		contentPane.add(textUtilizator);
		textUtilizator.setColumns(10);
		
		passwordParola = new JPasswordField();
		passwordParola.setBounds(104, 57, 223, 20);
		contentPane.add(passwordParola);
		
		JLabel Label_2Message = new JLabel(".");
		Label_2Message.setFont(new Font("Tahoma", Font.BOLD, 17));
		Label_2Message.setBounds(89, 79, 236, 23);
		contentPane.add(Label_2Message);
	}
}
