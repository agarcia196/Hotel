/*
 * @author Alexis Garc�a Ram�rez
 */
package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import hotel.Hotel;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormCocina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2456662259109038683L;
	private JPanel contentPane;
	private JPanel contentServicios;
	private JPanel contentPedido;
	private JPanel contentConsulta;
	private JPanel contentMenu;
	private Hotel hotel;
	private final String backgroundcolor="#44b256";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#FFFFFF";
	private final String btncolor2= "#F22613";
	private final int width_txt = 300;
	private final int height_txt= 40;
	private final int btnwidth= 250;
	private final int btnheight= 40;
	private final int btnsize= 30;
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private JLabel lblCocina ;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					FormCocina frame = new FormCocina(h);
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
	public FormCocina(Hotel h) {
		hotel=h;
		setForeground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setFont(new Font(font, Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cocina");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setBounds(0, 0, 1366, 768);
		lblCocina = new JLabel();
	//	vistaPrincipal();
	//	vistaServicios();
	//	vistaPedido();
	//	vistaConsulta();
	//	vistaMenu();
		vistaCrearPlato();
	}
	
	private void vistaCrearPlato() {
		// TODO Auto-generated method stub
		
	}

	private void vistaMenu() {
		// TODO Auto-generated method stub
		contentMenu = new JPanel();
		contentMenu.setBackground(Color.decode(backgroundcolor));
		contentMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentMenu);
		contentMenu.setLayout(null);
		
		lblCocina.setText("Men�");
		lblCocina.setForeground(Color.WHITE);
		lblCocina.setFont(new Font(font, Font.BOLD, 40));
		lblCocina.setBounds(644, 65, 200, 50);
		contentMenu.add(lblCocina);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(200, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentMenu.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(310, 578, 766, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentMenu.add(textMensaje);
			
		JLabel lblCrearPlato_1 = new JLabel("CrearPlato");
		lblCrearPlato_1.setBounds(310, 200, 256, 256);
		lblCrearPlato_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaPedido();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Agregar un nuevo plato al men�.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
	
		lblCrearPlato_1.setIcon(new ImageIcon("Icons\\coffee-maker.png"));	
		contentMenu.add(lblCrearPlato_1);
		
		JLabel lblEliminar_1 = new JLabel("Eliminar");
		lblEliminar_1.setBounds(600, 200, 256, 256);
		lblEliminar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaConsulta();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Eliminar plato del men�.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
 
		lblEliminar_1.setIcon(new ImageIcon("Icons\\knife.png"));	
		contentMenu.add(lblEliminar_1);
		
		JLabel lblCrearPlato = new JLabel("Crear Plato");
		lblCrearPlato.setForeground(Color.WHITE);
		lblCrearPlato.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblCrearPlato.setBounds(320, 467, 249, 60);
		contentMenu.add(lblCrearPlato);
		
		JLabel lblEliminar = new JLabel("Eliminar Plato");
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblEliminar.setBounds(590, 467, 274, 60);
		contentMenu.add(lblEliminar);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaPrincipal();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a cocina");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentMenu.add(lblBack);
		
		JLabel lblConsultar_1 = new JLabel("Consultar");
		lblConsultar_1.setBounds(890, 200, 256, 256);
		lblConsultar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentServicios.setVisible(false);
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Ver men�.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		lblConsultar_1.setIcon(new ImageIcon("Icons\\recipes.png"));	
		contentMenu.add(lblConsultar_1);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblConsultar.setBounds(926, 467, 220, 60);		
		contentMenu.add(lblConsultar);
	}

	private void vistaPrincipal() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCocina.setText("Cocina");
		lblCocina.setForeground(Color.WHITE);
		lblCocina.setFont(new Font(font, Font.BOLD, 40));
		lblCocina.setBounds(600, 68, 150, 50);
		contentPane.add(lblCocina);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(200, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentPane.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(310, 578, 766, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPane.add(textMensaje);
			
		JLabel lblServicio = new JLabel("Servicio");
		lblServicio.setBounds(310, 200, 256, 256);
		lblServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaServicios();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Realiza pedidos de los usuarios, consultar prioridad de preparaci�n de alimentos,"
						+ "despachar los pedidos y...");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		Icon iconoservicio = new ImageIcon("Icons\\dish.png");
		lblServicio.setIcon(iconoservicio);	
		contentPane.add(lblServicio);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(820, 200, 256, 256);
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaMenu();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Crea, elimina y busca platos del men�.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		Icon iconomenu = new ImageIcon("Icons\\chef.png");
		lblMenu.setIcon(iconomenu);	
		contentPane.add(lblMenu);
		
		JLabel lblServicio_1 = new JLabel("Servicio");
		lblServicio_1.setForeground(Color.WHITE);
		lblServicio_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblServicio_1.setBounds(350, 467, 200, 60);
		contentPane.add(lblServicio_1);
		
		JLabel lblMen = new JLabel("Men\u00FA");
		lblMen.setForeground(Color.WHITE);
		lblMen.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblMen.setBounds(899, 467, 200, 60);
		contentPane.add(lblMen);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.add(lblBack);
	}
	private void vistaServicios() {
		contentServicios = new JPanel();
		contentServicios.setBackground(Color.decode(backgroundcolor));
		contentServicios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentServicios);
		contentServicios.setLayout(null);
		
		lblCocina.setText("Servicio");
		lblCocina.setForeground(Color.WHITE);
		lblCocina.setFont(new Font(font, Font.BOLD, 40));
		lblCocina.setBounds(644, 65, 200, 50);
		contentServicios.add(lblCocina);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(200, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentServicios.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(310, 578, 766, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentServicios.add(textMensaje);
			
		JLabel lblPedido = new JLabel("Pedido");
		lblPedido.setBounds(310, 200, 256, 256);
		lblPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaPedido();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Realizar pedido del men� disponible.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
	
		lblPedido.setIcon(new ImageIcon("Icons\\mitten.png"));	
		contentServicios.add(lblPedido);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setBounds(600, 200, 256, 256);
		lblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaConsulta();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Ver Cola de pedidos.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
 
		lblConsulta.setIcon(new ImageIcon("Icons\\scale.png"));	
		contentServicios.add(lblConsulta);
		
		JLabel lblPedido_1 = new JLabel("Pedido");
		lblPedido_1.setForeground(Color.WHITE);
		lblPedido_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblPedido_1.setBounds(350, 467, 200, 60);
		contentServicios.add(lblPedido_1);
		
		JLabel lblConsulta_1 = new JLabel("Consulta");
		lblConsulta_1.setForeground(Color.WHITE);
		lblConsulta_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblConsulta_1.setBounds(644, 467, 200, 60);
		contentServicios.add(lblConsulta_1);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaPrincipal();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a cocina");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentServicios.add(lblBack);
		
		JLabel lblDespachar = new JLabel("Despachar");
		lblDespachar.setBounds(890, 200, 256, 256);
		lblDespachar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Agregar producto a factura del cliente y dar por terminada la preparaci�n del plato.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		lblDespachar.setIcon(new ImageIcon("Icons\\restaurant.png"));	
		contentServicios.add(lblDespachar);
		
		JLabel lblDespachar_1 = new JLabel("Despachar");
		lblDespachar_1.setForeground(Color.WHITE);
		lblDespachar_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblDespachar_1.setBounds(900, 467, 233, 60);		
		contentServicios.add(lblDespachar_1);
	}
	private void vistaPedido() {
		JTextField txtplato,txtUserName;
		JLabel lblNombre,Plato;
		
		contentPedido = new JPanel();
		contentPedido.setBackground(Color.decode(backgroundcolor));
		contentPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPedido);
		contentPedido.setLayout(null);
		
		lblCocina.setText("Servicio : pedido");
		lblCocina.setForeground(Color.WHITE);
		lblCocina.setFont(new Font(font, Font.BOLD, 40));
		lblCocina.setBounds(520, 66, 339, 50);
		contentPedido.add(lblCocina);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(245, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentPedido.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(355, 578, 340, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPedido.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaServicios();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a servicio");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentPedido.add(lblBack);
		
		txtUserName = new JTextField();
		txtUserName.setEditable(false);
		txtUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Click para buscar usuario.");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		txtUserName.setToolTipText("");
		txtUserName.setForeground(Color.BLACK);
		txtUserName.setFont(new Font(font, Font.PLAIN, fontsize));
		txtUserName.setBounds(355, 190, 300, 40);
		contentPedido.add(txtUserName);
		txtUserName.setColumns(100);
		txtUserName.setBackground(Color.decode(txtcolor1));
		txtUserName.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		
		txtplato = new JTextField();
		txtplato.setEditable(false);
		txtplato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Click para buscar plato.");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		txtplato.setToolTipText("");
		txtplato.setForeground(Color.BLACK);
		txtplato.setFont(new Font(font, Font.PLAIN, fontsize));
		txtplato.setColumns(100);
		txtplato.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtplato.setBackground(Color.decode(txtcolor1));
		txtplato.setBounds(700, 190, 300, 40);
		contentPedido.add(txtplato);
		

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentPedido.add(separator);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.decode(txtcolor1));
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(355, 170, 240, 15);
		contentPedido.add(lblNombre);
		
		Plato = new JLabel("Plato");
		Plato.setForeground(Color.decode(txtcolor1));
		Plato.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Plato.setBounds(700, 170, 240, 15);
		contentPedido.add(Plato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(353, 250, 723, 315);
		contentPedido.add(scrollPane);
		String [] titulos = {"Nombre ", "Duraci�n", "Precio"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla

		scrollPane.setViewportView(table_1);
		
		JLabel lblPlus = new JLabel("plus");
		lblPlus.setBackground(Color.WHITE);
		lblPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Agregar a pedido.");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		lblPlus.setBounds(1010, 175, 64, 64);
		lblPlus.setIcon(new ImageIcon("Icons\\plus.png"));
		contentPedido.add(lblPlus);
		JButton btnpedido = new JButton("Realizar pedido");
		btnpedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Terminar el pedido.");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		btnpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	hotel.login(tipodeuser);
			}
		});
		btnpedido.setBounds(776, 581, btnwidth+50, btnheight);
		btnpedido.setBackground(Color.decode(btncolor1));
		btnpedido.setForeground(Color.WHITE);
		btnpedido.setFont(new Font(font, Font.BOLD, btnsize));
		contentPedido.add(btnpedido);
		
	}
	private void vistaConsulta() {
		
		contentConsulta = new JPanel();
		contentConsulta.setBackground(Color.decode(backgroundcolor));
		contentConsulta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentConsulta);
		contentConsulta.setLayout(null);
		
		lblCocina.setText("Servicio : consulta");
		lblCocina.setForeground(Color.WHITE);
		lblCocina.setFont(new Font(font, Font.BOLD, 40));
		lblCocina.setBounds(512, 66, 353, 50);
		contentConsulta.add(lblCocina);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(235, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentConsulta.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(337, 578, 723, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentConsulta.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaServicios();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a servicio");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentConsulta.add(lblBack);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentConsulta.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(337, 155, 723, 393);
		contentConsulta.add(scrollPane);
		String [] titulos = {"Id ", "Nombre", "Platos","Posici�n"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		scrollPane.setViewportView(table_1);
		
	}
}
