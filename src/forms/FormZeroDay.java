package forms;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import hotel.Administrador;
import hotel.Empleado;
import hotel.Hotel;
import hotel.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class FormZeroDay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929026323831009718L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private final String color1= "#FFFFFF";
	private final String color2= "#FFFFFF";
	private final String color3= "#3a88db";
	private final String backgroundcolor="#44b256";
	private final int fontsize=20;
	//private final String color4="#6f6f6f";
	private final String color5="#FFFFFF";
	private final int width_txt= 250;
	private final int height_txt= 40;
	private JPasswordField contrasena;
	private JTextField txtapellido;
	private JTextField txtncedula; 
	private JTextField txtemail;   
	private JPasswordField ccontrasena;
	private JTextField txtHotel;
	private JComboBox<String> cbtipodedocumento;
	private JLabel lblSignUp;
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
	private JLabel lblNombre;
	private JLabel Genero;
	private JLabel lblTipoDeDocumento;
	private JLabel lblPassword;
	private JLabel Apellido;
	private JLabel Email;
	private JLabel lblNmeroDeDocumento;
	private JLabel lblConfirmarContrasea;
	private JLabel lblNombreDeHotel;
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
		setTitle("Registro");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		//setAlwaysOnTop(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768); 
	//	Toolkit tk = Toolkit.getDefaultToolkit();
	//	int xsize = (int) tk.getScreenSize().getWidth();
	//s	int ysize = (int) tk.getScreenSize().getHeight();
		//setSize(xsize, ysize);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setForeground(Color.BLACK);
		txtUserName.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		txtUserName.setBounds(360, 300, width_txt, height_txt);
		contentPane.add(txtUserName);
		txtUserName.setColumns(100);
		txtUserName.setBackground(Color.decode(color1));
		txtUserName.setBorder(new LineBorder(Color.decode(color2), 3, true));
		
		contrasena = new JPasswordField();
		contrasena.setToolTipText("");
		contrasena.setForeground(Color.BLACK);
		contrasena.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		contrasena.setColumns(100);
		contrasena.setBorder(new LineBorder(Color.decode(color2), 3, true));
		contrasena.setBackground(Color.decode(color1));
		contrasena.setBounds(360, 540,width_txt, height_txt);
		contentPane.add(contrasena);
		
		txtapellido = new JTextField();
		txtapellido.setToolTipText("");
		txtapellido.setForeground(Color.BLACK);
		txtapellido.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		txtapellido.setColumns(100);
		txtapellido.setBorder(new LineBorder(Color.decode(color2), 3, true));
		txtapellido.setBackground(Color.decode(color1));
		txtapellido.setBounds(692, 300, 250, 40);
		contentPane.add(txtapellido);
		
		txtncedula = new JTextField();
		txtncedula.setToolTipText("");
		txtncedula.setForeground(Color.BLACK);
		txtncedula.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		txtncedula.setColumns(100);
		txtncedula.setBorder(new LineBorder(Color.decode(color2), 3, true));
		txtncedula.setBackground(Color.decode(color1));
		txtncedula.setBounds(692, 460, width_txt, height_txt);
		contentPane.add(txtncedula);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setForeground(Color.BLACK);
		txtemail.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		txtemail.setColumns(100);
		txtemail.setBorder(new LineBorder(Color.decode(color2), 3, true));
		txtemail.setBackground(Color.decode(color1));
		txtemail.setBounds(692, 380, width_txt, height_txt);
		contentPane.add(txtemail);
		
		ccontrasena = new JPasswordField();
		ccontrasena.setToolTipText("");
		ccontrasena.setForeground(Color.BLACK);
		ccontrasena.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		ccontrasena.setColumns(100);
		ccontrasena.setBorder(new LineBorder(Color.decode(color2), 3, true));
		ccontrasena.setBackground(Color.decode(color1));
		ccontrasena.setBounds(692, 540, width_txt, height_txt);
		contentPane.add(ccontrasena);
		
		txtHotel = new JTextField();
		txtHotel.setToolTipText("");
		txtHotel.setForeground(Color.BLACK);
		txtHotel.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		txtHotel.setColumns(100);
		txtHotel.setBorder(new LineBorder(Color.decode(color2), 3, true));
		txtHotel.setBackground(Color.decode(color1));
		txtHotel.setBounds(360, 172, 582, height_txt);
		contentPane.add(txtHotel);
		
		JComboBox<String> cbgenero = new JComboBox<String>();
		cbgenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		cbgenero.setBackground(Color.decode(color1));
		cbgenero.setForeground(Color.BLACK);
		cbgenero.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		cbgenero.setBounds(360, 379, width_txt, height_txt);
		cbgenero.setBorder(null);
		contentPane.add(cbgenero);
		
		cbtipodedocumento = new JComboBox<String>();
		cbtipodedocumento.setModel(new DefaultComboBoxModel<String>(new String[] {"C\u00E9dula", "Nit", "Pasaporte"}));
		cbtipodedocumento.setForeground(Color.BLACK);
		cbtipodedocumento.setFont(new Font("Century Gothic", Font.PLAIN, fontsize));
		cbtipodedocumento.setBorder(null);
		cbtipodedocumento.setBackground(Color.decode(color1));
		cbtipodedocumento.setBounds(360, 459, 250, 40);
		contentPane.add(cbtipodedocumento);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblSignUp.setForeground(Color.decode(color5));
		lblSignUp.setBounds(325, 89, 629, 55);
		contentPane.add(lblSignUp);
		
		lblAdministrador = new JLabel("Datos del administrador");
		lblAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblAdministrador.setBounds(325, 223, 629, 40);
		lblAdministrador.setForeground(Color.decode(color5));
		contentPane.add(lblAdministrador);
		
		username = new JLabel("");
		username.setBounds(310, 300, 40, 40);
		ImageIcon iconusername =new ImageIcon("Icons\\username.png");
		Icon iconousername = new ImageIcon(iconusername.getImage().getScaledInstance(username.getWidth(),username.getHeight(), Image.SCALE_DEFAULT));
		username.setIcon(iconousername);
		contentPane.add(username);
		
		pwd = new JLabel("");
		pwd.setBounds(310, 540, 40, 40);
		ImageIcon iconpwd =new ImageIcon("Icons\\pwd.png");
		Icon iconopwd = new ImageIcon(iconpwd.getImage().getScaledInstance(pwd.getWidth(),pwd.getHeight(), Image.SCALE_DEFAULT));
		pwd.setIcon(iconopwd);
		
		contentPane.add(pwd);
		
		label_2 = new JLabel("");
		label_2.setBounds(642, 300, 40, 40);
		contentPane.add(label_2);
		
		email = new JLabel("");
		email.setBounds(642, 380, 40, 40);
		ImageIcon iconemail =new ImageIcon("Icons\\email.png");
		Icon iconoemail = new ImageIcon(iconemail.getImage().getScaledInstance(email.getWidth(),email.getHeight(), Image.SCALE_DEFAULT));
		email.setIcon(iconoemail);
		contentPane.add(email);
		
		number = new JLabel("");
		number.setBounds(642, 460, 40, 40);
		ImageIcon iconnumber =new ImageIcon("Icons\\number.png");
		Icon icononumber = new ImageIcon(iconnumber.getImage().getScaledInstance(number.getWidth(),number.getHeight(), Image.SCALE_DEFAULT));
		number.setIcon(icononumber);
		contentPane.add(number);
		
		cpwd = new JLabel("");
		cpwd.setBounds(642, 540, 40, 40);
		cpwd.setIcon(iconopwd);
		contentPane.add(cpwd);
		
		genero = new JLabel("");
		genero.setBounds(310, 380, 40, 40);
		ImageIcon icongenero =new ImageIcon("Icons\\genero.png");
		Icon iconogenero = new ImageIcon(icongenero.getImage().getScaledInstance(genero.getWidth(),genero.getHeight(), Image.SCALE_DEFAULT));
		genero.setIcon(iconogenero);
		contentPane.add(genero);
		
		tipoid = new JLabel("");
		tipoid.setBounds(310, 460, 40, 40);
		ImageIcon icontipoid =new ImageIcon("Icons\\tipoid.png");
		Icon iconotipoid = new ImageIcon(icontipoid.getImage().getScaledInstance(tipoid.getWidth(),tipoid.getHeight(), Image.SCALE_DEFAULT));
		tipoid.setIcon(iconotipoid);
		contentPane.add(tipoid);
		
		hotel = new JLabel("");
		hotel.setBounds(310, 172, 40, 40);
		contentPane.add(hotel);
		ImageIcon iconhotel =new ImageIcon("Icons\\hotel_icon1.png");
		Icon iconohotel = new ImageIcon(iconhotel.getImage().getScaledInstance(hotel.getWidth(),hotel.getHeight(), Image.SCALE_DEFAULT));
		hotel.setIcon(iconohotel);
		
		JButton signup = new JButton("Sign-up Now");
		signup.setBackground(Color.decode(color3));
		signup.setForeground(Color.WHITE);
		signup.setFont(new Font("Century Gothic", Font.BOLD, 25));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int validar = JOptionPane.showConfirmDialog(contentPane,
						"�Est� seguro de que la informaci�n es correcta?");
				if (validar == 0) {
							try {
								Recursos.validarCamposVaciosU(txtUserName.getText(), txtapellido.getText(), 
										cbgenero.getSelectedItem().toString(), txtemail.getText(),txtncedula.getText(), 
										cbtipodedocumento.getSelectedItem().toString(), String.valueOf(contrasena.getPassword()), 
										String.valueOf(ccontrasena.getPassword()), txtHotel.getText());
								Recursos.validarLongitudPwd(String.valueOf(contrasena.getPassword()));
								Recursos.validarIgualdadPwd(String.valueOf(contrasena.getPassword()), String.valueOf(ccontrasena.getPassword()));
								Hotel h = new Hotel(txtHotel.getText());
								Empleado e = new Administrador(txtUserName.getText(), txtapellido.getText(), 
										cbgenero.getSelectedItem().toString(), txtemail.getText(),txtncedula.getText(), 
										cbtipodedocumento.getSelectedItem().toString(), String.valueOf(contrasena.getPassword()));
								h.addEmpleado(e);
								dispose();
								Recursos.WriteFileObjectEmpresa("hotel.dat", h);
								FormLogin login = new FormLogin(h);
								login.setVisible(true);
							} catch (ECamposVacios | EIgualdad | ELongitud e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(contentPane, e.getMessage());
							}
						}	
						/*FormLogin login = new FormLogin(empresa);
						login.setVisible(true);	}		*/					
				}
			
		});
		signup.setBounds(692, 602, width_txt, height_txt);
		contentPane.add(signup);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 629, 20);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(196, 196, 196));
		separator_1.setBounds(313, 262, 629, 8);
		contentPane.add(separator_1);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.decode(color5));
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(365, 282, 240, 15);
		contentPane.add(lblNombre);
		
		Genero = new JLabel("Genero");
		Genero.setForeground(Color.decode(color5));
		Genero.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Genero.setBounds(370, 363, 240, 15);
		contentPane.add(Genero);
		
		lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setForeground(Color.decode(color5));
		lblTipoDeDocumento.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblTipoDeDocumento.setBounds(370, 441, 240, 15);
		contentPane.add(lblTipoDeDocumento);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.decode(color5));
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(370, 523, 240, 15);
		contentPane.add(lblPassword);
		
		Apellido = new JLabel("Apellido");
		Apellido.setForeground(Color.decode(color5));
		Apellido.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Apellido.setBounds(702, 282, 240, 15);
		contentPane.add(Apellido);
		
		Email = new JLabel("Email");
		Email.setForeground(Color.decode(color5));
		Email.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Email.setBounds(702, 363, 240, 15);
		contentPane.add(Email);
		
		lblNmeroDeDocumento = new JLabel("N\u00FAmero de documento");
		lblNmeroDeDocumento.setForeground(Color.decode(color5));
		lblNmeroDeDocumento.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNmeroDeDocumento.setBounds(702, 441, 240, 15);
		contentPane.add(lblNmeroDeDocumento);
		
		lblConfirmarContrasea = new JLabel("Confirm Password");
		lblConfirmarContrasea.setForeground(Color.decode(color5));
		lblConfirmarContrasea.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblConfirmarContrasea.setBounds(702, 523, 240, 15);
		contentPane.add(lblConfirmarContrasea);
		
		lblNombreDeHotel = new JLabel("Nombre de Hotel");
		lblNombreDeHotel.setForeground(Color.decode(color5));
		lblNombreDeHotel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombreDeHotel.setBounds(365, 155, 240, 15);
		contentPane.add(lblNombreDeHotel);
	
	}
}
