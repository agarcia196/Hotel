package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.ECliente;
import exception.ExceptionNodo;
import hotel.Administrador;
import hotel.Cliente;
import hotel.Empleado;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Persona;
import hotel.Recepcion;
import hotel.Recursos;
import hotel.Reserva;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormMenuPrincipal extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5192578394103176449L;
	private JPanel contentPane;
	private final String backgroundcolor="#44b256";
	private final String font= "Century Gothic";
	private final int fontsize=40;
	private final int lbtnwidth= 256;
	private final int lbtnheight=256;
	private Hotel h;
	private Persona p;
	private	JTextArea textArea;
	private JLabel lblInfo;
	JLabel lblLogin;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel("Trivago");
					try {					
						Cliente a = new Cliente("a", "a", "Sin especificar", "DD", "1234", "CC", "123");
						Habitacion ha = new Habitacion ("VIP", "VIP", 150000);
						h.addHabitacion (ha);
						a.addReserva (LocalDate.of(2018, Month.MAY, 20), LocalDate.of (2018, Month.MAY, 21), "VIP", h);
						Cliente b = new Cliente("b", "b", "Sin especificar", "DD", "abc", "CC", "123");
						Cliente g = new Cliente("g", "c", "Sin especificar", "DD", "def", "CC", "123");
						Cliente d = new Cliente("d", "d", "Sin especificar", "DD", "ghi", "CC", "123");
						Cliente e = new Cliente("e", "e", "Sin especificar", "DD", "jkl", "CC", "123");
						Cliente f = new Cliente("f", "f", "Sin especificar", "DD", "mno", "CC", "123");
						h.addUser(a);
						h.addUser(b);
						h.addUser(g);
						h.addUser(d);
						h.addUser(e);
						h.addUser(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				//	Persona Fabox= new Cliente("Fabio","Anaya","Masculino","fabeac", "1212","Cedula","123");
					Persona Fabox1= new Administrador("Fabio","Anaya","Masculino","fabeac", "1212","Cedula","123");
					FormMenuPrincipal frame = new FormMenuPrincipal(h, Fabox1);
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
	public FormMenuPrincipal(Hotel hotel, Persona persona) {
		this.h = hotel;
		this.p= persona;
		setTitle("Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons"+File.separator+"oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);	

		lblLogin = new JLabel();
		lblLogin.setBounds(310, 69, 780, 75);
		lblLogin.setFont(new Font(font, Font.BOLD, fontsize+20));
		lblLogin.setForeground(Color.WHITE);
		lblInfo = new JLabel("Info");
		lblInfo.setBounds(200, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons"+File.separator+"information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		textArea = new JTextArea();
		textArea.setBounds(310, 578, 766, 100);
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(4);
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font(font, Font.ITALIC, fontsize-20));
		textArea.setEditable(false);
		textArea.setBackground(new Color(68, 178, 86));
		vistaPrincipal();
		//vistaHotel();
		//vistaUsers();
		//vistaCheckOut ();		
	}
	private void vistaHotel() {
		JPanel Menu = new JPanel();
		Menu.setBackground(Color.decode(backgroundcolor));
		Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Menu);
		Menu.setLayout(null);
		lblLogin.setText("Men\u00fa Hotel");
		Menu.add(lblLogin);
		Menu.add(lblInfo);
		Menu.add(textArea);
		JLabel lblBack = new JLabel("back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons"+File.separator+"back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaPrincipal();
			}
		});
		Menu.add(lblBack);
		JLabel lblRecepcion = new JLabel("Recepcion");
		lblRecepcion.setBounds(600, 200, lbtnwidth, lbtnheight);
		lblRecepcion.setIcon(new ImageIcon("Icons"+File.separator+"reception.png"));
		lblRecepcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("TEXTPPPPP");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		Menu.add(lblRecepcion);

		JLabel lblRecepcion_1 = new JLabel("Recepci\u00F3n");
		lblRecepcion_1.setForeground(Color.WHITE);
		lblRecepcion_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblRecepcion_1.setBounds(600, 467, 256, 60);
		Menu.add(lblRecepcion_1);
		if(p instanceof Empleado) {
		JLabel lblCheckin = new JLabel("Checkin");
		lblCheckin.setBounds(295, 200, lbtnwidth, lbtnheight);
		lblCheckin.setIcon(new ImageIcon("Icons"+File.separator+"stair.png"));
		lblCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getContentPane().setVisible(false);
				vistaCheckIn();
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Realizar check-in a un cliente antes de que pueda pasar a su habitación");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		Menu.add(lblCheckin);
	
		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setBounds(905, 200, lbtnwidth, lbtnheight);
		lblCheckout.setIcon(new ImageIcon("Icons"+File.separator+"stairs.png"));
		lblCheckout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getContentPane ().setVisible (false);
				vistaCheckOut ();
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Realizar check-Out a un cliente sobre una reserva.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		Menu.add(lblCheckout);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setForeground(Color.WHITE);
		lblCheckOut.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblCheckOut.setBounds(905, 467, 256, 60);
		Menu.add(lblCheckOut);
		
		JLabel lblCheckIn = new JLabel("Check In");
		lblCheckIn.setForeground(Color.WHITE);
		lblCheckIn.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblCheckIn.setBounds(295, 467, 256, 60);
		Menu.add(lblCheckIn);
		}
	}
	
	private void vistaPrincipal() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLogin.setText("Bienvenido a "+h.getNombre());
		contentPane.add(lblLogin);
		contentPane.add(lblInfo);
		contentPane.add(textArea);
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setBounds(310, 200, lbtnwidth, lbtnheight);
		lblHotel.setIcon(new ImageIcon("Icons"+File.separator+"hotel.png"));	
		lblHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaHotel();
			}
			public void mouseEntered(MouseEvent arg0) {
				if(p instanceof Cliente)
					textArea.setText("Aqu"+File.separator+"u00ed puedes realizar, editar y cancelar las reservaciones.");
				if(p instanceof Recepcion)	
					textArea.setText("Aqu"+File.separator+"u00ed puedes realizar, editar y cancelar las reservaciones, registrar clientes.");
				if(p instanceof Administrador)
					textArea.setText("Aqu"+File.separator+"u00ed puedes realizar, editar y cancelar las reservaciones, registrar clientes,registrar habitaciones");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentPane.add(lblHotel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(820, 200, 256, 256);
		ImageIcon iconUsuario =new ImageIcon("Icons"+File.separator+"userlogin.png");
		Icon iconoUsuario = new ImageIcon(iconUsuario.getImage().getScaledInstance(lblUsuario.getWidth(),lblUsuario.getHeight(), Image.SCALE_DEFAULT));
		lblUsuario.setIcon(iconoUsuario);
		lblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(p instanceof Cliente) {
				FormEditUser editar = new FormEditUser(h, p);
				editar.setVisible(true);
				}
				if(p instanceof Recepcion || p instanceof Administrador) {
					getContentPane().setVisible(false);;
					vistaUsers();				
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				if(p instanceof Cliente)
					textArea.setText("Aqu\\u00ed puedes editar t"+File.separator+"u00fa informaci"+File.separator+"u00f3n personal");
				if(p instanceof Recepcion || p instanceof Administrador)
					textArea.setText("Aqu"+File.separator+"u00ed  puedes editar informaci"+File.separator+"u00f3n para de los usuarios");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentPane.add(lblUsuario);
		
		JLabel lblHotel_1 = new JLabel("Hotel");
		lblHotel_1.setForeground(Color.WHITE);
		lblHotel_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblHotel_1.setBounds(384, 450, 182, 60);
		contentPane.add(lblHotel_1);
		
		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setForeground(Color.WHITE);
		lblUsuario_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblUsuario_1.setBounds(881, 450, 189, 60);
		contentPane.add(lblUsuario_1);
		
	
		if(p instanceof Administrador) {
			JLabel lblCocina = new JLabel("Cocina");
			lblCocina.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FormCocina cocina = new FormCocina(h, (Empleado)p);
					cocina.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					textArea.setText("Acceso directo a la Cocina");
					lblInfo.setVisible(true);
				}		
				@Override
				public void mouseExited(MouseEvent arg0) {
					textArea.setText("");
					lblInfo.setVisible(false);
				}
			});
			lblCocina.setBounds(570, 200, 256, 256);
			contentPane.add(lblCocina);
			lblHotel.setBounds(250, 200, lbtnwidth, lbtnheight);
			lblUsuario.setBounds(870, 200, 256, 256);
			lblHotel_1.setBounds(324, 450, 182, 60);
			lblUsuario_1.setBounds(937, 450, 189, 60);
			
			JLabel lblCocina_1 = new JLabel("Cocina");
			lblCocina_1.setForeground(Color.WHITE);
			lblCocina_1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 40));
			lblCocina_1.setBounds(637, 450, 189, 60);
			lblCocina.setIcon(new ImageIcon("Icons"+File.separator+"chef1.png"));
			contentPane.add(lblCocina_1);
			
			
		}
		JLabel lblExit = new JLabel("Exit");
		lblExit.setIcon(new ImageIcon("Icons\\exit.png"));
		lblExit.setBounds(1130, 296, 64, 64);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int validar = JOptionPane.showConfirmDialog(contentPane,
						"Desea Cerrar Sesion?");
				if(validar==0) {
					Recursos.WriteFileObjectEmpresa("hotel.dat", h);
					dispose();
					FormLogin login = new FormLogin(h);
					login.setVisible(true);
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Cerrar Sesion.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentPane.add(lblExit);
	}
	private void vistaUsers() {
		JPanel contentVistaUsuarios = new JPanel();
		contentVistaUsuarios.setBackground(Color.decode(backgroundcolor));
		contentVistaUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentVistaUsuarios);
		contentVistaUsuarios.setLayout(null);
		contentVistaUsuarios.setLayout(null);
		lblLogin.setText("Usuarios");
		contentVistaUsuarios.add(lblLogin);
		contentVistaUsuarios.add(lblInfo);
		contentVistaUsuarios.add(textArea);
					
		JLabel lblServicio = new JLabel("Agregar");
		lblServicio.setBounds(310, 200, 256, 256);
		lblServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FormAddUser agregar = new FormAddUser(h, (Empleado)p);
				agregar.setVisible(true);
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Agregar Clientes"+(p instanceof Administrador) != null?"Administradores":""+"y Empleados");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		Icon iconoservicio = new ImageIcon("Icons"+File.separator+"add-user.png");
		lblServicio.setIcon(iconoservicio);	
		contentVistaUsuarios.add(lblServicio);
		
		JLabel lblMenu = new JLabel("Editar");
		lblMenu.setBounds(820, 200, 256, 256);
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FormEditUser editar = new FormEditUser(h, (Empleado)p);
				editar.setVisible(true);
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Editar, elimina y busca Usuarios.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		Icon iconomenu = new ImageIcon("Icons"+File.separator+"edit-user.png");
		lblMenu.setIcon(iconomenu);	
		contentVistaUsuarios.add(lblMenu);
		
		JLabel lblServicio_1 = new JLabel("Agregar Usuario");
		lblServicio_1.setBounds(283, 467, 314, 60);
		lblServicio_1.setForeground(Color.WHITE);
		lblServicio_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		contentVistaUsuarios.add(lblServicio_1);
		
		JLabel lblMen = new JLabel("Editar Usuario");
		lblMen.setBounds(820, 467, 273, 60);
		lblMen.setForeground(Color.WHITE);
		lblMen.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		contentVistaUsuarios.add(lblMen);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaPrincipal();
			}
		});
		contentVistaUsuarios.add(lblBack);
	}
	
	private void vistaCheckIn() {
		lblInfo.setVisible(false);
		textArea.setText("");
		JPanel contentCheckIn = new JPanel();
		contentCheckIn.setBackground(Color.decode(backgroundcolor));
		contentCheckIn.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentCheckIn);
		contentCheckIn.setLayout(null);
		contentCheckIn.setLayout(null);
		lblLogin.setText("Check-In");
		contentCheckIn.add(lblLogin);
		contentCheckIn.add(lblInfo);
		contentCheckIn.add(textArea);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons" + File.separator + "back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaHotel();
			}
		});
		contentCheckIn.add(lblBack);
		
		JLabel lblCdulaCliente = new JLabel("Cédula cliente:");
		lblCdulaCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCdulaCliente.setForeground (Color.WHITE);
		lblCdulaCliente.setBounds(436, 296, 157, 41);
		contentCheckIn.add(lblCdulaCliente);
		
		JTextField textField = new JTextField();
		textField.setBounds(627, 296, 313, 41);
		contentCheckIn.add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				new FormBuscarUsuario (h, textField).setVisible(true);
			}
		});
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(575, 399, 135, 53);
		contentCheckIn.add(btnComprobar);
		
		btnComprobar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					
					((Empleado)p).checkIn (textField.getText (), h);
					

					JOptionPane.showMessageDialog(null, "Check-In realizado con éxito", "Completo", JOptionPane.INFORMATION_MESSAGE);
					
					
				} catch (ExceptionNodo | ECliente e) {

					JOptionPane.showMessageDialog(null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Busca un usuario asociado a la cédula introducida y luego mira si tiene una reserva"
						+ " hecha para el día actual.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
		
	}
	
	private void vistaCheckOut() {
		lblInfo.setVisible(false);
		textArea.setText("");
		JPanel contentCheckOut = new JPanel();
		contentCheckOut.setBackground(Color.decode(backgroundcolor));
		contentCheckOut.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentCheckOut);
		contentCheckOut.setLayout(null);
		contentCheckOut.setLayout(null);
		lblLogin.setText("Check-Out");
		contentCheckOut.add(lblLogin);
		contentCheckOut.add(lblInfo);
		contentCheckOut.add(textArea);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons" + File.separator + "back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaHotel();
			}
		});
		contentCheckOut.add(lblBack);
		
		JLabel lblCdulaCliente = new JLabel("Cédula cliente:");
		lblCdulaCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCdulaCliente.setForeground (Color.WHITE);
		lblCdulaCliente.setBounds(436, 296, 157, 41);
		contentCheckOut.add(lblCdulaCliente);
		
		JTextField textField = new JTextField();
		textField.setBounds(627, 296, 313, 41);
		contentCheckOut.add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				new FormBuscarUsuario (h, textField).setVisible(true);
			}
		});
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(577, 465, 135, 53);
		contentCheckOut.add(btnComprobar);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(627, 349, 313, 41);
		contentCheckOut.add(textField_1);
		
		JLabel lblIdDeLa = new JLabel("ID de la reserva:");
		lblIdDeLa.setForeground(Color.WHITE);
		lblIdDeLa.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIdDeLa.setBounds(436, 349, 157, 41);
		contentCheckOut.add(lblIdDeLa);
		
		btnComprobar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					
					double tarifa = ((Empleado)p).checkOut (textField.getText (), textField_1.getText (), h);
					

					JOptionPane.showMessageDialog(null, "Check-Out realizado con éxito\n\nTarifa a pagar: " + tarifa, "Completo", JOptionPane.INFORMATION_MESSAGE);
					textField.setText ("");
					textField_1.setText ("");
					
				} catch (ExceptionNodo | ECliente e) {

					JOptionPane.showMessageDialog(null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Busca un usuario con la cédula introducida, busca la reserva asociada a este usuario y verifica "
						+ "si hay que aplicar recargo por noches que se haya quedado adicionales a las que estaban facturadas inicialmente.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
				lblInfo.setVisible(false);
			}
		});
	}
}
