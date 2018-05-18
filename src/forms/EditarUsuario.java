package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
import hotel.Administrador;
import hotel.Cliente;
import hotel.Empleado;
import hotel.Hotel;
import hotel.Recursos;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditarUsuario extends JFrame {
	public EditarUsuario(Hotel h,Empleado persona) {

		hotel=h;
		this.p=persona;
		setTitle("Sign in");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);	
		lblLogin = new JLabel();
		EditarUsuario();
	}

	private JPanel contentPane;
	private static final long serialVersionUID = 1858820207514553474L;
	private JPanel contentPane2;
	private final String backgroundcolor="#44b256";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#FFFFFF";
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private JLabel lblLogin;
	private Hotel hotel;
	private Empleado p;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel hotel= new Hotel();
					Administrador fabio= new Administrador("Fabio","Anaya","Masculino","fabeac", "1212","Cedula","123");
					EditarUsuario frame = new EditarUsuario(hotel, fabio);
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
	private void EditarUsuario() {
		JTextField txtncedula;
		JLabel username;
		JLabel lblConfirmarContrasea;
		
		contentPane2 = new JPanel();
		contentPane2.setBackground(Color.decode(backgroundcolor));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		lblLogin.setBounds(522, 78, 300, 50);
		lblLogin.setFont(new Font(font, Font.BOLD, 40));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setText("Editar usuario\r\n");
		contentPane2.add(lblLogin);
		
		txtncedula = new JTextField();
		txtncedula.setToolTipText("");
		txtncedula.setForeground(Color.BLACK);
		txtncedula.setFont(new Font(font, Font.PLAIN, fontsize));
		txtncedula.setColumns(100);
		txtncedula.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtncedula.setBackground(Color.decode(txtcolor1));
		txtncedula.setBounds(310, 190, 300, 40);
		contentPane2.add(txtncedula);
		
		username = new JLabel("");
		username.setBounds(310, 190, 40, 40);
		ImageIcon iconusername =new ImageIcon("Icons\\username.png");
		Icon iconousername = new ImageIcon(iconusername.getImage().getScaledInstance(username.getWidth(),username.getHeight(), Image.SCALE_DEFAULT));
		username.setIcon(iconousername);
		contentPane2.add(username);
		ImageIcon iconpwd =new ImageIcon("Icons\\pwd.png");
		ImageIcon iconemail =new ImageIcon("Icons\\email.png");
		ImageIcon iconnumber =new ImageIcon("Icons\\number.png");
		ImageIcon icongenero =new ImageIcon("Icons\\genero.png");
		ImageIcon icontipoid =new ImageIcon("Icons\\tipoid.png");
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 725, 20);
		contentPane2.add(separator);
	
		
		lblConfirmarContrasea = new JLabel("Numero de documento\r\n");
		lblConfirmarContrasea.setForeground(Color.decode(txtcolor1));
		lblConfirmarContrasea.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblConfirmarContrasea.setBounds(323, 162, 240, 15);
		contentPane2.add(lblConfirmarContrasea);
		JButton btnback = new JButton("back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane2,"Aqui iria hacia donde regresa");
				//contentPane2.setVisible(false);
				//vistaLogin();
			}
			
		});
		btnback.setForeground(Color.decode(txtcolor1));
		btnback.setFont(new Font(font, Font.PLAIN, 11));
		btnback.setBackground(Color.decode(backgroundcolor));
		btnback.setBounds(222, 50, 80, 80);
		btnback.setBorderPainted(false);
		ImageIcon iconback =new ImageIcon("Icons\\back.png");
		Icon iconoback = new ImageIcon(iconback.getImage().getScaledInstance(btnback.getWidth(),btnback.getHeight(), Image.SCALE_DEFAULT));
		btnback.setIcon(iconoback);
		contentPane2.add(btnback);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "APELLIDO", "SEXO", "CORREO", "TIPO ID", "DOCUMENTO"},
			},
			new String[] {
				"Nombre", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.addRowSelectionInterval(0, 1);
		table.setBounds(310, 291, 820, 361);
		contentPane2.add(table);
		
		
	}
}
