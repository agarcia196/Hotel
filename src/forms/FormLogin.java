package forms;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hotel.Administrador;
import hotel.Hotel;
import hotel.Persona;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1858820207514553474L;
	private JPanel contentPane;
	private JPanel contentPane1;
	private final String backgroundcolor="#44b256";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#FFFFFF";
	private final String txtcolor2= "#000000";
	private final int width_txt = 250;
	private final int height_txt= 40;
	private final int btnwidth= 250;
	private final int btnheight= 40;
	private final int btnsize= 30;
	private final String font= "Century Gothic";
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblLogin;
	private String tipodeuser;
	private Hotel hotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					Persona p= new Administrador("nombre"," apellido", "genero", "correo", "id", "tipoId", "pwd");
					FormLogin frame = new FormLogin(h,p);
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
	public FormLogin(Hotel h, Persona p) {
		hotel=h;
		setTitle("Sign in");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		lblLogin = new JLabel("Login as");
		lblLogin.setBounds(600, 68, 159, 50);
		lblLogin.setFont(new Font(font, Font.BOLD, 40));
		lblLogin.setForeground(Color.WHITE);
		contentPane.add(lblLogin);
		
		vistaPrincipal();
				

	}
	
	private void vistaPrincipal() {
		JButton btnVisitante = new JButton("Visitante");
		btnVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipodeuser="Visitante";
				contentPane.setVisible(false);
				vistaLogin();
			}
		});
		btnVisitante.setBounds(250, 500, btnwidth, btnheight);
		btnVisitante.setBackground(Color.decode(btncolor1));
		btnVisitante.setForeground(Color.WHITE);
		btnVisitante.setFont(new Font(font, Font.BOLD, btnsize));
		contentPane.add(btnVisitante);
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipodeuser="Empleado";
				vistaLogin();
			}
		});
		btnEmpleado.setBounds(850, 500, btnwidth, btnheight);
		btnEmpleado.setBackground(Color.decode(btncolor1));
		btnEmpleado.setForeground(Color.WHITE);
		btnEmpleado.setFont(new Font(font, Font.BOLD, btnsize));
		contentPane.add(btnEmpleado);
		
		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(250, 200, 250, 250);
		ImageIcon iconvisitante =new ImageIcon("Icons\\user.png");
		Icon iconovisitante = new ImageIcon(iconvisitante.getImage().getScaledInstance(lblVisitante.getWidth(),lblVisitante.getHeight(), Image.SCALE_DEFAULT));
		lblVisitante.setIcon(iconovisitante);
		contentPane.add(lblVisitante);
		
		JLabel lblEmpreado = new JLabel("Empleado");
		lblEmpreado.setBounds(850, 200, 250, 250);
		ImageIcon iconempleado =new ImageIcon("Icons\\empleado.png");
		Icon iconoempleado = new ImageIcon(iconempleado.getImage().getScaledInstance(lblEmpreado.getWidth(),lblEmpreado.getHeight(), Image.SCALE_DEFAULT));
		lblEmpreado.setIcon(iconoempleado);
		contentPane.add(lblEmpreado);
		
		
		
	}
	
	private void vistaLogin() {
		contentPane1 = new JPanel();
		contentPane1.setBackground(Color.decode(backgroundcolor));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);		
		//hotel.addEmpleado(e);
		contentPane1.add(lblLogin);
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(550, 500, btnwidth, btnheight);
		btnSignIn.setBackground(Color.decode(btncolor1));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font(font, Font.BOLD, btnsize));
		contentPane1.add(btnSignIn);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font(font, Font.BOLD, 20));
		passwordField.setBounds(550, 402, width_txt, height_txt);
		passwordField.setColumns(100);
		passwordField.setBackground(Color.decode(txtcolor1));
		passwordField.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		contentPane1.add(passwordField);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font(font, Font.BOLD, 20));
		textField.setBounds(550, 321, width_txt, height_txt);
		textField.setColumns(100);
		textField.setBackground(Color.decode(txtcolor1));
		textField.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		contentPane1.add(textField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.decode(txtcolor1));
		lblPassword.setFont(new Font(font, Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(550, 378, 250, 20);
		contentPane1.add(lblPassword);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setForeground(Color.decode(txtcolor1));
		lblUser.setFont(new Font(font, Font.BOLD | Font.ITALIC, 20));
		lblUser.setBounds(550, 296, 250, 20);
		contentPane1.add(lblUser);
		
		JLabel lblUserIcon = new JLabel("UserIcon");
		lblUserIcon.setBounds(600, 135, 150, 150);
		ImageIcon iconusericon =new ImageIcon("Icons\\userlogin.png");
		Icon iconousericon = new ImageIcon(iconusericon.getImage().getScaledInstance(lblUserIcon.getWidth(),lblUserIcon.getHeight(), Image.SCALE_DEFAULT));
		lblUserIcon.setIcon(iconousericon);
		contentPane1.add(lblUserIcon);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(470, 60, 80, 80);
		ImageIcon iconback =new ImageIcon("Icons\\back.png");
		Icon iconoback = new ImageIcon(iconback.getImage().getScaledInstance(lblBack.getWidth(),lblBack.getHeight(), Image.SCALE_DEFAULT));
		lblBack.setIcon(iconoback);
		contentPane1.add(lblBack);
	}
}
