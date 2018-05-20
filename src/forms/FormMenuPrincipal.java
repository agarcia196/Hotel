package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.Administrador;
import hotel.Cliente;
import hotel.Empleado;
import hotel.Hotel;
import hotel.Persona;
import hotel.Recepcion;

import javax.swing.JTextArea;

public class FormMenuPrincipal extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel("Trivago");
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
		 h = hotel;
		 p = persona;
		setTitle("Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons"+File.separator+"oficcial.png"));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);	

		lblLogin = new JLabel();
		lblLogin.setFont(new Font(font, Font.BOLD, fontsize));
		lblLogin.setForeground(Color.WHITE);
		lblInfo = new JLabel("Info");
		lblInfo.setBounds(200, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons"+File.separator+"information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(4);
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font(font, Font.ITALIC, fontsize-20));
		textArea.setEditable(false);
		textArea.setBackground(new Color(68, 178, 86));
		textArea.setBounds(310, 578, 766, 100);
		//vistaPrincipal();
		vistaHotel();
				
	}
	private void vistaHotel() {
		JPanel Menu = new JPanel();
		Menu.setBackground(Color.decode(backgroundcolor));
		Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Menu);
		Menu.setLayout(null);
		lblLogin.setBounds(600, 67, 470, 50);
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
		Menu.add(lblCheckin);
	
		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setBounds(905, 200, lbtnwidth, lbtnheight);
		lblCheckout.setIcon(new ImageIcon("Icons"+File.separator+"stairs.png"));
		lblCheckout.addMouseListener(new MouseAdapter() {
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
		lblLogin.setBounds(520, 67, 550, 50);
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
				FormEditUser editar = new FormEditUser(h, p);
				editar.setVisible(true);
			}
			public void mouseEntered(MouseEvent arg0) {
				if(p instanceof Cliente || p instanceof Recepcion )
					textArea.setText("Aqu"+File.separator+"u00ed puedes editar t"+File.separator+"u00fa informaci"+File.separator+"u00f3n personal");
				if(p instanceof Administrador)
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
	}
}
