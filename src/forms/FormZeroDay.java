package forms;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FormZeroDay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929026323831009718L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private final String color1= "#616161";
	private final String color2= "#565656";
	private final String color3= "#3a88db";
	private final String color4="#6f6f6f";
	private final int width_txt= 250;
	private final int height_txt= 40;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtHotel;
	private JComboBox<String> comboBox_1;
	private JLabel lblSingUp;
	private JLabel lblAdministrador;
	private JLabel username;
	private JLabel pwd;
	private JLabel label_2;
	private JLabel email;
	private JLabel number;
	private JLabel cpwd;
	private JLabel genero;
	private JLabel tipoid;
	private JLabel hotel;
	private JSeparator separator_1;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormZeroDay frame = new FormZeroDay();
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
	public FormZeroDay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setForeground(Color.WHITE);
		txtUserName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtUserName.setBounds(220, 371, width_txt, height_txt);
		contentPane.add(txtUserName);
		txtUserName.setColumns(100);
		txtUserName.setBackground(Color.decode(color1));
		txtUserName.setBorder(new LineBorder(Color.decode(color2), 3, true));
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_2.setColumns(100);
		textField_2.setBorder(new LineBorder(Color.decode(color2), 3, true));
		textField_2.setBackground(Color.decode(color1));
		textField_2.setBounds(220, 524,width_txt, height_txt);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_3.setColumns(100);
		textField_3.setBorder(new LineBorder(Color.decode(color2), 3, true));
		textField_3.setBackground(Color.decode(color1));
		textField_3.setBounds(552, 371, 250, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_4.setColumns(100);
		textField_4.setBorder(new LineBorder(Color.decode(color2), 3, true));
		textField_4.setBackground(Color.decode(color1));
		textField_4.setBounds(552, 422, width_txt, height_txt);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_5.setColumns(100);
		textField_5.setBorder(new LineBorder(Color.decode(color2), 3, true));
		textField_5.setBackground(Color.decode(color1));
		textField_5.setBounds(552, 473, width_txt, height_txt);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_6.setColumns(100);
		textField_6.setBorder(new LineBorder(Color.decode(color2), 3, true));
		textField_6.setBackground(Color.decode(color1));
		textField_6.setBounds(552, 524, width_txt, height_txt);
		contentPane.add(textField_6);
		
		txtHotel = new JTextField();
		txtHotel.setToolTipText("");
		txtHotel.setForeground(Color.WHITE);
		txtHotel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtHotel.setColumns(100);
		txtHotel.setBorder(new LineBorder(Color.decode(color2), 3, true));
		txtHotel.setBackground(Color.decode(color1));
		txtHotel.setBounds(220, 244, 582, height_txt);
		contentPane.add(txtHotel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		comboBox.setBackground(Color.decode(color1));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setBounds(220, 421, width_txt, height_txt);
		comboBox.setBorder(new LineBorder(Color.decode(color2), 3, true));
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"C\u00E9dula", "Nit", "Pasaporte"}));
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox_1.setBorder(new LineBorder(Color.decode(color2), 3, true));
		comboBox_1.setBackground(new Color(97, 97, 97));
		comboBox_1.setBounds(220, 473, 250, 40);
		contentPane.add(comboBox_1);
		
		lblSingUp = new JLabel("Sing Up");
		lblSingUp.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblSingUp.setForeground(Color.decode(color4));
		lblSingUp.setBounds(173, 167, 629, 55);
		contentPane.add(lblSingUp);
		
		lblAdministrador = new JLabel("Datos del administrador");
		lblAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblAdministrador.setBounds(173, 295, 629, 55);
		lblAdministrador.setForeground(Color.decode(color4));
		contentPane.add(lblAdministrador);
		
		username = new JLabel("");
		username.setBounds(170, 371, 40, 40);
		ImageIcon iconusername =new ImageIcon("Icons\\username.png");
		Icon iconousername = new ImageIcon(iconusername.getImage().getScaledInstance(username.getWidth(),username.getHeight(), Image.SCALE_DEFAULT));
		username.setIcon(iconousername);
		contentPane.add(username);
		
		pwd = new JLabel("");
		pwd.setBounds(170, 524, 40, 40);
		ImageIcon iconpwd =new ImageIcon("Icons\\pwd.png");
		Icon iconopwd = new ImageIcon(iconpwd.getImage().getScaledInstance(pwd.getWidth(),pwd.getHeight(), Image.SCALE_DEFAULT));
		pwd.setIcon(iconopwd);
		
		contentPane.add(pwd);
		
		label_2 = new JLabel("");
		label_2.setBounds(505, 371, 40, 40);
		contentPane.add(label_2);
		
		email = new JLabel("");
		email.setBounds(505, 422, 40, 40);
		ImageIcon iconemail =new ImageIcon("Icons\\email.png");
		Icon iconoemail = new ImageIcon(iconemail.getImage().getScaledInstance(email.getWidth(),email.getHeight(), Image.SCALE_DEFAULT));
		email.setIcon(iconoemail);
		contentPane.add(email);
		
		number = new JLabel("");
		number.setBounds(505, 473, 40, 40);
		ImageIcon iconnumber =new ImageIcon("Icons\\number.png");
		Icon icononumber = new ImageIcon(iconnumber.getImage().getScaledInstance(number.getWidth(),number.getHeight(), Image.SCALE_DEFAULT));
		number.setIcon(icononumber);
		contentPane.add(number);
		
		cpwd = new JLabel("");
		cpwd.setBounds(505, 524, 40, 40);
		cpwd.setIcon(iconopwd);
		contentPane.add(cpwd);
		
		genero = new JLabel("");
		genero.setBounds(170, 422, 40, 40);
		ImageIcon icongenero =new ImageIcon("Icons\\genero.png");
		Icon iconogenero = new ImageIcon(icongenero.getImage().getScaledInstance(genero.getWidth(),genero.getHeight(), Image.SCALE_DEFAULT));
		genero.setIcon(iconogenero);
		contentPane.add(genero);
		
		tipoid = new JLabel("");
		tipoid.setBounds(170, 473, 40, 40);
		ImageIcon icontipoid =new ImageIcon("Icons\\tipoid.png");
		Icon iconotipoid = new ImageIcon(icontipoid.getImage().getScaledInstance(tipoid.getWidth(),tipoid.getHeight(), Image.SCALE_DEFAULT));
		tipoid.setIcon(iconotipoid);
		contentPane.add(tipoid);
		
		hotel = new JLabel("");
		hotel.setBounds(170, 244, 40, 40);
		contentPane.add(hotel);
		ImageIcon iconhotel =new ImageIcon("Icons\\hotel_icon1.png");
		Icon iconohotel = new ImageIcon(iconhotel.getImage().getScaledInstance(hotel.getWidth(),hotel.getHeight(), Image.SCALE_DEFAULT));
		hotel.setIcon(iconohotel);
		
		JButton singup = new JButton("Sing-up Now");
		singup.setBackground(Color.decode(color3));
		singup.setForeground(Color.WHITE);
		singup.setFont(new Font("Century Gothic", Font.BOLD, 25));
		singup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		singup.setBounds(552, 575, width_txt, height_txt);
		contentPane.add(singup);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(173, 220, 629, 20);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(196, 196, 196));
		separator_1.setBounds(173, 342, 629, 20);
		contentPane.add(separator_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("A:\\Alexis\\Documents\\Universidad\\2018-1\\Estructuras de Datos\\Hotel\\Icons\\background.jpg"));
		lblNewLabel.setBounds(0, 0, 1008, 729);
		contentPane.add(lblNewLabel);
	
	}
}
