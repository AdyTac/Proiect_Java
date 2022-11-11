import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PieseAuto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PieseAuto frame = new PieseAuto();
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
	public PieseAuto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Editare_button = new JPanel();
		Editare_button.setBounds(10, 11, 245, 460);
		Editare_button.setBackground(SystemColor.info);
		contentPane.add(Editare_button);
		Editare_button.setLayout(null);
		
		JLabel ID_label = new JLabel("ID");
		ID_label.setBounds(10, 65, 46, 14);
		Editare_button.add(ID_label);
		
		JLabel lblNewLabel = new JLabel("Piesa");
		lblNewLabel.setBounds(10, 100, 46, 14);
		Editare_button.add(lblNewLabel);
		
		JLabel Prod_label = new JLabel("Producator");
		Prod_label.setBounds(10, 135, 64, 14);
		Editare_button.add(Prod_label);
		
		JLabel Pret_label = new JLabel("Pret");
		Pret_label.setBounds(10, 174, 46, 14);
		Editare_button.add(Pret_label);
		
		textField = new JTextField();
		textField.setBounds(76, 62, 133, 20);
		Editare_button.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 97, 133, 20);
		Editare_button.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 132, 133, 20);
		Editare_button.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(76, 171, 133, 20);
		Editare_button.add(textField_3);
		
		JButton Adaug_Button = new JButton("Adauga");
		Adaug_Button.setBounds(10, 232, 89, 23);
		Editare_button.add(Adaug_Button);
		
		JButton btnNewButton_1 = new JButton("Editare");
		btnNewButton_1.setBounds(10, 266, 89, 23);
		Editare_button.add(btnNewButton_1);
		
		JButton Clear_Button = new JButton("Clear");
		Clear_Button.setBounds(10, 300, 89, 23);
		Editare_button.add(Clear_Button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(265, 11, 384, 460);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 460, -398, -459);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBounds(396, 457, -398, -450);
		panel_1.add(table);
	}

}
