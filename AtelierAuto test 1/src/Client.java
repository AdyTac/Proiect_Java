import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton Adauga_Button;
	private JButton Editare_Button;
	private JButton Curata_Button;
	private JPanel panel_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setResizable(false);
		setTitle("Meniu - Service Auto Zarnesti ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(34, 40, 384, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ID_Lable = new JLabel("ID");
		ID_Lable.setBounds(10, 35, 46, 14);
		panel.add(ID_Lable);
		
		JLabel Nume_Label = new JLabel("Nume\\Prenume");
		Nume_Label.setBounds(10, 71, 89, 14);
		panel.add(Nume_Label);
		
		JLabel Telef_Label = new JLabel("Telefon");
		Telef_Label.setBounds(10, 103, 46, 14);
		panel.add(Telef_Label);
		
		JLabel Model_Label = new JLabel("Model ");
		Model_Label.setBounds(10, 136, 46, 14);
		panel.add(Model_Label);
		
		JLabel Defecte_label = new JLabel("Defecte");
		Defecte_label.setBounds(10, 201, 46, 14);
		panel.add(Defecte_label);
		
		textField = new JTextField();
		textField.setBounds(120, 32, 236, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 68, 236, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 100, 236, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 136, 236, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 182, 236, 52);
		panel.add(textField_4);
		
		Adauga_Button = new JButton("Adauga");
		Adauga_Button.setBounds(24, 288, 96, 36);
		panel.add(Adauga_Button);
		
		Editare_Button = new JButton("Editare");
		Editare_Button.setBounds(140, 288, 96, 36);
		panel.add(Editare_Button);
		
		Curata_Button = new JButton("Clear");
		Curata_Button.setBounds(260, 288, 96, 36);
		panel.add(Curata_Button);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(451, 40, 485, 434);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 485, 434);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setForeground(SystemColor.inactiveCaption);
		table.setBackground(SystemColor.activeCaption);
		scrollPane.setViewportView(table);
	}
}
