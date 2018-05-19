package forms;

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
import exception.ExceptionNodo;
import hotel.Administrador;
import hotel.Cliente;
import hotel.Empleado;
import hotel.Hotel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class FormEditUser extends JFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel hotel= new Hotel();
					Cliente Fabox= new Cliente("Fabio","Anaya","Masculino","fabeac", "1212","Cedula","123");
					Administrador fabio= new Administrador("Fabio","Anaya","Masculino","fabeac", "1212","Cedula","123");
					FormEditUser frame = new FormEditUser(hotel, Fabox);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormEditUser(Hotel h,Cliente persona) {

		hotel=h;
		this.p=persona;
		setTitle("Sign in");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);	
		lblLogin = new JLabel();
	
		Editar(p);
		EditarUsuario();
		//EditarUsuario();
	}
	private static final long serialVersionUID = 1858820207514553474L;
	private JPanel contentPane2;
	private final String backgroundcolor="#44b256";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#FFFFFF";
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private JLabel lblLogin;
	private Hotel hotel;
	private Cliente p;

	
	/**
	 * Create the frame.
	 * @param CEC 
	 */
	
	private void Editar(Cliente CEC) {
		
		JPasswordField contraseña,ccontraseña;
		JTextField txtapellido,txtncedula,txtemail,Nombre;
		JComboBox<String> cbtipodedocumento;
		JLabel username,pwd, email,number,cpwd,genero,tipoid;
		JLabel lblNombre,Genero,lblTipoDeDocumento,lblPassword,Apellido,Email,lblNmeroDeDocumento,lblConfirmarContrasea;
		
		contentPane2 = new JPanel();
		contentPane2.setBackground(Color.decode(backgroundcolor));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		lblLogin.setBounds(336, 78, 395, 50);
		lblLogin.setFont(new Font(font, Font.BOLD, 40));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setText("Modificar usuario\r\n");
		contentPane2.add(lblLogin);
		
		Nombre = new JTextField();
		Nombre.setToolTipText("");
		Nombre.setForeground(Color.BLACK);
		Nombre.setFont(new Font(font, Font.PLAIN, fontsize));
		Nombre.setBounds(355, 190, 300, 40);
		contentPane2.add(Nombre);
		Nombre.setColumns(100);
		Nombre.setBackground(Color.decode(txtcolor1));
		Nombre.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		
		contraseña = new JPasswordField();
		contraseña.setToolTipText("");
		contraseña.setForeground(Color.BLACK);
		contraseña.setFont(new Font(font, Font.PLAIN, fontsize));
		contraseña.setColumns(100);
		contraseña.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		contraseña.setBackground(Color.decode(txtcolor1));
		contraseña.setBounds(355, 418,300, 40);
		contentPane2.add(contraseña);
		
		txtapellido = new JTextField();
		txtapellido.setToolTipText("");
		txtapellido.setForeground(Color.BLACK);
		txtapellido.setFont(new Font(font, Font.PLAIN, fontsize));
		txtapellido.setColumns(100);
		txtapellido.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtapellido.setBackground(Color.decode(txtcolor1));
		txtapellido.setBounds(720, 190, 300, 40);
		contentPane2.add(txtapellido);
		
		txtncedula = new JTextField();
		txtncedula.setEditable(false);
		txtncedula.setEnabled(false);
		txtncedula.setToolTipText("");
		txtncedula.setForeground(Color.BLACK);
		txtncedula.setFont(new Font(font, Font.PLAIN, fontsize));
		txtncedula.setColumns(100);
		txtncedula.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtncedula.setBackground(Color.decode(txtcolor1));
		txtncedula.setBounds(720, 351, 300, 40);
		contentPane2.add(txtncedula);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setForeground(Color.BLACK);
		txtemail.setFont(new Font(font, Font.PLAIN, fontsize));
		txtemail.setColumns(100);
		txtemail.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtemail.setBackground(Color.decode(txtcolor1));
		txtemail.setBounds(720, 270, 300, 40);
		contentPane2.add(txtemail);
		
		ccontraseña = new JPasswordField();
		ccontraseña.setToolTipText("");
		ccontraseña.setForeground(Color.BLACK);
		ccontraseña.setFont(new Font(font, Font.PLAIN, fontsize));
		ccontraseña.setColumns(100);
		ccontraseña.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		ccontraseña.setBackground(Color.decode(txtcolor1));
		ccontraseña.setBounds(720, 418, 300, 40);
		contentPane2.add(ccontraseña);
		
		JComboBox<String> cbgenero = new JComboBox<String>();
		cbgenero.setEnabled(false);
		cbgenero.setModel(new DefaultComboBoxModel<String>(new String[] {CEC.getGenero()}));
		cbgenero.setBackground(Color.decode(txtcolor1));
		cbgenero.setForeground(Color.BLACK);
		cbgenero.setFont(new Font(font, Font.PLAIN, fontsize));
		cbgenero.setBounds(355, 270, 300, 40);
		cbgenero.setBorder(null);
		contentPane2.add(cbgenero);
		
		cbtipodedocumento = new JComboBox<String>();
		cbtipodedocumento.setEnabled(false);
		cbtipodedocumento.setModel(new DefaultComboBoxModel<String>(new String[] {"C\u00E9dula", "Nit", "Pasaporte"}));
		cbtipodedocumento.setForeground(Color.BLACK);
		cbtipodedocumento.setFont(new Font(font, Font.PLAIN, fontsize));
		cbtipodedocumento.setBorder(null);
		cbtipodedocumento.setBackground(Color.decode(txtcolor1));
		cbtipodedocumento.setBounds(355, 350, 300, 40);
		contentPane2.add(cbtipodedocumento);
		
		username = new JLabel("");
		username.setBounds(310, 190, 40, 40);
		ImageIcon iconusername =new ImageIcon("Icons\\username.png");
		Icon iconousername = new ImageIcon(iconusername.getImage().getScaledInstance(username.getWidth(),username.getHeight(), Image.SCALE_DEFAULT));
		username.setIcon(iconousername);
		contentPane2.add(username);
		
		pwd = new JLabel("");
		pwd.setBounds(310, 415, 40, 40);
		ImageIcon iconpwd =new ImageIcon("Icons\\pwd.png");
		Icon iconopwd = new ImageIcon(iconpwd.getImage().getScaledInstance(pwd.getWidth(),pwd.getHeight(), Image.SCALE_DEFAULT));
		pwd.setIcon(iconopwd);
		
		contentPane2.add(pwd);
		
		email = new JLabel("");
		email.setBounds(670, 274, 40, 40);
		ImageIcon iconemail =new ImageIcon("Icons\\email.png");
		Icon iconoemail = new ImageIcon(iconemail.getImage().getScaledInstance(email.getWidth(),email.getHeight(), Image.SCALE_DEFAULT));
		email.setIcon(iconoemail);
		contentPane2.add(email);
		
		number = new JLabel("");
		number.setBounds(670, 351, 40, 40);
		ImageIcon iconnumber =new ImageIcon("Icons\\number.png");
		Icon icononumber = new ImageIcon(iconnumber.getImage().getScaledInstance(number.getWidth(),number.getHeight(), Image.SCALE_DEFAULT));
		number.setIcon(icononumber);
		contentPane2.add(number);
		
		cpwd = new JLabel("");
		cpwd.setBounds(670, 415, 40, 40);
		cpwd.setIcon(iconopwd);
		contentPane2.add(cpwd);
		
		genero = new JLabel("");
		genero.setBounds(310, 270, 40, 40);
		ImageIcon icongenero =new ImageIcon("Icons\\genero.png");
		Icon iconogenero = new ImageIcon(icongenero.getImage().getScaledInstance(genero.getWidth(),genero.getHeight(), Image.SCALE_DEFAULT));
		genero.setIcon(iconogenero);
		contentPane2.add(genero);
		
		tipoid = new JLabel("");
		tipoid.setBounds(310, 351, 40, 40);
		ImageIcon icontipoid =new ImageIcon("Icons\\tipoid.png");
		Icon iconotipoid = new ImageIcon(icontipoid.getImage().getScaledInstance(tipoid.getWidth(),tipoid.getHeight(), Image.SCALE_DEFAULT));
		tipoid.setIcon(iconotipoid);
		contentPane2.add(tipoid);
		
		JButton signup = new JButton("Finalizar edicion");
		signup.setBackground(Color.decode(btncolor1));
		signup.setForeground(Color.WHITE);
		signup.setFont(new Font("Century Gothic", Font.BOLD, 25));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int validar = JOptionPane.showConfirmDialog(contentPane2,
						"¿Está seguro de las modificaciones realizadas?");
				if (validar == 0) {
					if(contraseña.equals(ccontraseña)) {
					Cliente c;
					try {
						c = hotel.buscarCliente(CEC.getId());
					} catch (ExceptionNodo e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 c=new Cliente(Nombre.getText().toString(),txtapellido.getText().toString(),CEC.getGenero(),txtemail.getText().toString(),txtncedula.getText().toString(),
							cbtipodedocumento.getSelectedItem().toString(),contraseña.toString());
					}else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					}
				}
			}
			
		});
		signup.setBounds(720, 482, 300, 40);
		contentPane2.add(signup);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 725, 20);
		contentPane2.add(separator);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.decode(txtcolor1));
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(355, 170, 240, 15);
		contentPane2.add(lblNombre);
		
		Genero = new JLabel("Genero");
		Genero.setForeground(Color.decode(txtcolor1));
		Genero.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Genero.setBounds(355, 248, 240, 15);
		contentPane2.add(Genero);
		
		lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setForeground(Color.decode(txtcolor1));
		lblTipoDeDocumento.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblTipoDeDocumento.setBounds(355, 330, 240, 15);
		contentPane2.add(lblTipoDeDocumento);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.decode(txtcolor1));
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(355, 401, 240, 15);
		contentPane2.add(lblPassword);
		
		Apellido = new JLabel("Apellido");
		Apellido.setForeground(Color.decode(txtcolor1));
		Apellido.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Apellido.setBounds(720, 170, 252, 15);
		contentPane2.add(Apellido);
		
		Email = new JLabel("Email");
		Email.setForeground(Color.decode(txtcolor1));
		Email.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Email.setBounds(720, 248, 250, 15);
		contentPane2.add(Email);
		
		lblNmeroDeDocumento = new JLabel("N\u00FAmero de documento");
		lblNmeroDeDocumento.setForeground(Color.decode(txtcolor1));
		lblNmeroDeDocumento.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNmeroDeDocumento.setBounds(720, 325, 240, 15);
		contentPane2.add(lblNmeroDeDocumento);
	
		
		lblConfirmarContrasea = new JLabel("Confirm Password");
		lblConfirmarContrasea.setForeground(Color.decode(txtcolor1));
		lblConfirmarContrasea.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblConfirmarContrasea.setBounds(720, 401, 240, 15);
		contentPane2.add(lblConfirmarContrasea);
		JButton btnback = new JButton("back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane2,"Aqui iria hacia donde regresa");
				//contentPane2.setVisible(false);
				//vistaLogin();
			}
			
		});
	}
		
		
	private void EditarUsuario() {
		JTextField DocMod;
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
		
		DocMod = new JTextField();
		DocMod.setToolTipText("");
		DocMod.setForeground(Color.BLACK);
		DocMod.setFont(new Font(font, Font.PLAIN, fontsize));
		DocMod.setColumns(100);
		DocMod.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		DocMod.setBackground(Color.decode(txtcolor1));
		DocMod.setBounds(310, 190, 300, 40);
		contentPane2.add(DocMod);
		
		username = new JLabel("");
		username.setBounds(310, 190, 40, 40);
		ImageIcon iconusername =new ImageIcon("Icons\\username.png");
		Icon iconousername = new ImageIcon(iconusername.getImage().getScaledInstance(username.getWidth(),username.getHeight(), Image.SCALE_DEFAULT));
		username.setIcon(iconousername);
		contentPane2.add(username);
	
		
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
		
		DefaultTableModel modelo= new DefaultTableModel();
		JTable table= new JTable(modelo);
		table.setEnabled(false);
	
		table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "APELLIDOS", "CORREO", "GENERO", "DOCUMENTO"},
			},
			new String[] {
				"NOMBRE", "APELLIDOS", "CORREO", "GENERO", "DOCUMENTO"
			}
		));
		table.setBounds(310, 277, 820, 361);
		contentPane2.add(table);
		
		ArrayList<Cliente> us=hotel.getUsuarios().inOrdenA();
		for(int i=0;i<us.size();i++) {
			String[] fila=us.get(i).imprimirPersonaTabla();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
		
		for(int i=0;i<hotel.getPersonal().size();i++) {
			String[] fila= hotel.getPersonal().get(i).imprimirPersonaTabla();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
		
		
		JLabel lblActualizarTablaDe = new JLabel("Actualizar tabla de usuarios");
		lblActualizarTablaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarTablaDe.setBounds(342, 668, 779, 40);
		contentPane2.add(lblActualizarTablaDe);
		lblActualizarTablaDe.setVisible(false);
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Cliente> us=hotel.getUsuarios().inOrdenA();
				for(int i=0;i<us.size();i++) {
					String[] fila=us.get(i).imprimirPersonaTabla();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
				
				for(int i=0;i<hotel.getPersonal().size();i++) {
					String[] fila= hotel.getPersonal().get(i).imprimirPersonaTabla();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblActualizarTablaDe.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblActualizarTablaDe.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\MSI-PC\\Desktop\\Proyecto\\Hotel\\Icons\\user.png"));
		button.setBounds(1151, 340, 145, 163);
		contentPane2.add(button);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1109, 305, 21, 48);
		contentPane2.add(scrollBar);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente CEC=hotel.buscarCliente(DocMod.getText().toString());
					if(CEC!=null) {
						Editar(CEC);
					}
				} catch (ExceptionNodo e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon("Icons\\LapizPeque\u00F1o.png"));
		button_1.setSelectedIcon(new ImageIcon("Icons\\LapizPeque\u00F1o.png"));
		button_1.setBounds(622, 189, 51, 41);
		contentPane2.add(button_1);
		
		
	}
}
