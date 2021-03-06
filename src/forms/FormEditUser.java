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

import exception.EArrayVacio;
import exception.ECamposVacios;
import exception.ECliente;
import exception.EIgualdad;
import exception.ELongitud;
import exception.ExceptionNodo;
import hotel.Administrador;
import hotel.Cliente;
import hotel.Hotel;
import hotel.Persona;
import hotel.Recursos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.Serializable;
import javax.swing.JScrollPane;

public class FormEditUser extends JFrame implements Serializable {
	private JPanel contentPane;
	private JLabel lblCocina ;
	private JTable table_1;
	private JTextField textFieldBuscar;
	private static final long serialVersionUID = 1858820207514553474L;
	private JPanel contentPane2;
	private final String backgroundcolor="#44b256";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#FFFFFF";
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private JLabel lblEditar;
	private Hotel hotel;
	private Persona p;
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
					fabio.addUser("Fabio", "Pedro", "Masculino", "xd", "6545", "Cedula", "12345678", "12345678", "Recepcion",hotel);
					fabio.addUser("Fabio12", "Pedro", "Masculino", "xd", "6545", "Cedula", "12345678", "12345678", "Recepcion",hotel);
					fabio.addUser("Fabio3213", "Pedro", "Masculino", "xd", "6545", "Cedula", "12345678", "12345678", "Recepcion",hotel);
					fabio.addUser("Fabio3213", "Pedro", "Masculino", "xd", "6545", "Cedula", "12345678", "12345678", "Cliente",hotel);
					hotel.addUser( Fabox);
					FormEditUser frame = new FormEditUser(hotel,fabio);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormEditUser(Hotel h,Persona persona) {
		hotel=h;
		this.p=persona;
		setTitle("Sign in");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 768);	
		lblEditar = new JLabel();
		if(p instanceof Cliente) 
		Editar(p);
		else
		EditarUsuario();
	
	}
	

	
	/**
	 * Create the frame.
	 * @param CEC 
	 * @param h 
	 */
	
	private void Editar(Persona CEC) {
		
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
		
		lblEditar.setBounds(336, 78, 395, 50);
		lblEditar.setFont(new Font(font, Font.BOLD, 40));
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setText("Modificar usuario\r\n");
		contentPane2.add(lblEditar);
		
		Nombre = new JTextField();
		Nombre.setToolTipText("");
		Nombre.setForeground(Color.BLACK);
		Nombre.setFont(new Font(font, Font.PLAIN, fontsize));
		Nombre.setBounds(355, 190, 300, 40);
		contentPane2.add(Nombre);
		Nombre.setColumns(100);
		Nombre.setText(CEC.getNombre());
		Nombre.setBackground(Color.decode(txtcolor1));
		Nombre.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		
		contraseña = new JPasswordField();
		contraseña.setToolTipText("");
		contraseña.setForeground(Color.BLACK);
		contraseña.setFont(new Font(font, Font.PLAIN, fontsize));
		contraseña.setColumns(100);
		contraseña.setText(CEC.getPwd());
		contraseña.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		contraseña.setBackground(Color.decode(txtcolor1));
		contraseña.setBounds(355, 418,300, 40);
		contentPane2.add(contraseña);
		
		txtapellido = new JTextField();
		txtapellido.setToolTipText("");
		txtapellido.setForeground(Color.BLACK);
		txtapellido.setFont(new Font(font, Font.PLAIN, fontsize));
		txtapellido.setColumns(100);
		txtapellido.setText(CEC.getApellido());
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
		txtncedula.setText(CEC.getId());
		txtncedula.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtncedula.setBackground(Color.decode(txtcolor1));
		txtncedula.setBounds(720, 351, 300, 40);
		contentPane2.add(txtncedula);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setForeground(Color.BLACK);
		txtemail.setFont(new Font(font, Font.PLAIN, fontsize));
		txtemail.setColumns(100);
		txtemail.setText(CEC.getCorreo());
		txtemail.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtemail.setBackground(Color.decode(txtcolor1));
		txtemail.setBounds(720, 270, 300, 40);
		contentPane2.add(txtemail);
		
		ccontraseña = new JPasswordField();
		ccontraseña.setToolTipText("");
		ccontraseña.setText(CEC.getPwd());
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
					try {
						CEC.editarUsuario(Nombre.getText().toString(),txtapellido.getText().toString(),genero.getText().toString(),txtemail.getText().toString(),
								txtncedula.getText().toString(),String.valueOf(contraseña.getPassword()),String.valueOf(ccontraseña.getPassword()), hotel, CEC);
						JOptionPane.showMessageDialog(null, "Edicion completada exitosamente");
					} catch (ECamposVacios | EIgualdad | ELongitud e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario a editar");
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
		
		JButton btnEliminarUsuario = new JButton("Eliminar ");
		if(CEC.isActivo()) {
			btnEliminarUsuario.setText("Eliminar");
		}else {
			btnEliminarUsuario.setText("Activar");
		}
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CEC.isActivo()) {
					CEC.setActivo(false);
					JOptionPane.showMessageDialog(null, "El estado de la cuenta ha sido desactivada");
					getContentPane().setVisible(false);
					EditarUsuario();
				}else {
					CEC.setActivo(true);
					JOptionPane.showMessageDialog(null, "La cuenta ha sido reactivada");
					getContentPane().setVisible(false);
					EditarUsuario();
				}
			}
		});
		btnEliminarUsuario.setForeground(Color.WHITE);
		btnEliminarUsuario.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnEliminarUsuario.setBackground(new Color(58, 136, 219));
		btnEliminarUsuario.setBounds(355, 482, 300, 40);
		contentPane2.add(btnEliminarUsuario);
		
		JLabel button = new JLabel();
		button.setText("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(p instanceof Cliente) {
					dispose();
				}
				else {	
				getContentPane().setVisible(false);	
				EditarUsuario();
				}
			}
		});
		button.setIcon(new ImageIcon("Icons"+File.separator+"back1.png"));
		button.setBounds(185, 296, 64, 64);
		contentPane2.add(button);
	}
		
		
	private void EditarUsuario() {			
			contentPane = new JPanel();
			contentPane.setBackground(Color.decode(backgroundcolor));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			lblCocina = new JLabel("Editar usuario\r\n");
			lblCocina.setForeground(Color.WHITE);
			lblCocina.setFont(new Font(font, Font.BOLD, 40));
			lblCocina.setBounds(544, 65, 300, 50);
			contentPane.add(lblCocina);
			JLabel lblInfo = new JLabel("Info");
			lblInfo.setBounds(202, 578, 100, 100);
			ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
			Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
			lblInfo.setIcon(iconoinfo);
			lblInfo.setVisible(false);
			contentPane.add(lblInfo);
			
			JLabel button = new JLabel();
			button.setText("Back");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			button.setIcon(new ImageIcon("Icons"+File.separator+"back1.png"));
			button.setBounds(185, 296, 64, 64);
			contentPane.add(button);
			
			JLabel InfoSeleccionar = new JLabel("Editar el usuario seleccionado\r\n");
			InfoSeleccionar.setFont(new Font("Century Gothic", Font.PLAIN, 25));
			InfoSeleccionar.setBounds(337, 600, 371, 40);
			InfoSeleccionar.setVisible(false);
			contentPane.add(InfoSeleccionar);
			
			JSeparator separator = new JSeparator();
			separator.setBackground(Color.decode("#c4c4c4"));
			separator.setBounds(313, 141, 763, 20);
			contentPane.add(separator);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			scrollPane.setBounds(337, 217, 720, 330);
			contentPane.add(scrollPane);
			String [] titulos = {"ID","Nombre", "Apellido","Activo"};	//crear vector con titulos de la tabla
			DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
			table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
			scrollPane.setViewportView(table_1);
			try {
				hotel.ConsultaEmpleados(modeloTable);
			} catch (EArrayVacio e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(contentPane, e.getMessage());
			}		
			JButton btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					InfoSeleccionar.setVisible(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					InfoSeleccionar.setVisible(false);
				}
			});
			
			JComboBox<String> TipoUsuario = new JComboBox<String>();
			TipoUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					hotel.limpiarMenu(modeloTable);
					String tipo=TipoUsuario.getSelectedItem().toString();
					if(tipo=="Empleado") {
							try {
								hotel.ConsultaEmpleados(modeloTable,textFieldBuscar.getText());
							} catch (EArrayVacio e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(contentPane,e.getMessage());
							}		
					}else {
						try {
							hotel.ConsultaUsuariosEdit(modeloTable);
						} catch (EArrayVacio e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane,e.getMessage());
						}
					}
				}
			});
			TipoUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 30));
			TipoUsuario.setModel(new DefaultComboBoxModel<String>(new String[] {"Empleado","Cliente"}));
			TipoUsuario.setBounds(919, 164, 138, 40);
			contentPane.add(TipoUsuario);
			
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table_1.getSelectedRow()==-1) {		
						JOptionPane.showMessageDialog(contentPane, "Seleccione un usuario para editar");
					}else {
						if(TipoUsuario.getSelectedItem().toString()=="Empleado") {
							try {
								getContentPane().setVisible(false);
								Editar(hotel.buscarEmpleado(table_1.getValueAt(table_1.getSelectedRow(),0).toString()));
							}catch (ECliente e2) {
								JOptionPane.showMessageDialog(contentPane,e2.getMessage());
							}
						}else{						
							try {
								getContentPane().setVisible(false);
								Editar(hotel.buscarCliente(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
							}catch (ExceptionNodo e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(contentPane,e1.getMessage());
							}
						}
						Recursos.WriteFileObjectEmpresa("hotel.dat", hotel);
					}
				}
			});
			btnSeleccionar.setForeground(Color.WHITE);
			btnSeleccionar.setFont(new Font("Century Gothic", Font.BOLD, 30));
			btnSeleccionar.setBackground(new Color(58, 136, 219));
			btnSeleccionar.setBounds(760, 600, 300, 40);
			contentPane.add(btnSeleccionar);
			
		
			
			textFieldBuscar = new JTextField();
			textFieldBuscar.setBounds(405, 164, 332, 40);
			textFieldBuscar.setForeground(Color.BLACK);
			textFieldBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			textFieldBuscar.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
			textFieldBuscar.setBackground(Color.WHITE);
			contentPane.add(textFieldBuscar);
			textFieldBuscar.setColumns(10);
			JButton btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					hotel.limpiarMenu(modeloTable);
					String tipo=TipoUsuario.getSelectedItem().toString();
					try {
						if(tipo=="Cliente") {
							hotel.ConsultaUsuariosEdit(modeloTable, textFieldBuscar.getText());
						}else if(tipo=="Empleado"){
							hotel.ConsultaEmpleados(modeloTable, textFieldBuscar.getText());
						}else {
							JOptionPane.showMessageDialog(contentPane, "Tipo de usuario no valido");
						}
					} catch (EArrayVacio e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				}
			});
			btnFiltrar.setForeground(Color.WHITE);
			btnFiltrar.setFont(new Font("Century Gothic", Font.BOLD, 30));
			btnFiltrar.setBackground(new Color(58, 136, 219));
			btnFiltrar.setBounds(760, 164, 150, 40);
			contentPane.add(btnFiltrar);
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setForeground(Color.WHITE);
			lblBuscar.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
			lblBuscar.setBounds(337, 164, 100, 40);
			contentPane.add(lblBuscar);
			
			
			
		}
}
