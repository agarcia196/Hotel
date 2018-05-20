package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;
import exception.ECamposVacios;
import exception.ECocina;
import exception.ELetrasEnCampoN;
import hotel.Hotel;
import hotel.Plato;
import hotel.Recursos;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormRecepcion extends JFrame {

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
	private final String backgroundcolor="#ffebcd";
	private final String btncolor1= "#3a88db";
	private final String txtcolor1= "#000000";
	private final int btnwidth= 250;
	private final int btnheight= 40;
	private final int btnsize= 30;
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private JLabel lblRecepcion;
	private JTable table_1;
	private Plato p;
	private JTextField txtplato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					FormRecepcion frame = new FormRecepcion (h);
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
	public FormRecepcion (Hotel h) {
		hotel=h;
		setForeground (Color.WHITE);
		setExtendedState (MAXIMIZED_BOTH);
		setFont (new Font(font, Font.PLAIN, 14));
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		setTitle ("Recepción");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setBounds(0, 0, 1366, 768);
		lblRecepcion = new JLabel();
		vistaPrincipal();
	}
	
	private void vistaCMenu(String ventana,JTextField txtpedido) {
		// TODO Auto-generated method stub
		JPanel contentCmenu = new JPanel();
		contentCmenu.setBackground(Color.decode(backgroundcolor));
		contentCmenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentCmenu);
		contentCmenu.setLayout(null);
		
		lblRecepcion.setText("Men� : Consultar men�");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(472, 66, 460, 50);
		contentCmenu.add(lblRecepcion);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(235, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons/information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentCmenu.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(337, 578, 360, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentCmenu.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons/back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				if(ventana=="Pedido")
					vistaPedido();
				else
					vistaMenu();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a Men�");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentCmenu.add(lblBack);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentCmenu.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(337, 155, 723, 393);
		contentCmenu.add(scrollPane);
		String [] titulos = {"Nombre","Disponibilidad", "Duraci�n","Precio"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		scrollPane.setViewportView(table_1);
		try {
			hotel.getCocina().printMenu(modeloTable);
		} catch (EArrayVacio e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(contentCmenu, e1.getMessage());
		}
		if(ventana=="Pedido") {
		JButton btnpedido = new JButton("Seleccionar");
		btnpedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Generar pedido con producto seleccionado.");
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
				if(table_1.getSelectedRow()==-1) {	
					JOptionPane.showMessageDialog(contentCmenu, "Porfavor seleccione un producto para continuar");
				}else {
					getContentPane().setVisible(false);
					txtpedido.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					setContentPane(contentPedido);
					contentPedido.setVisible(true);
				}
			}
		});
		btnpedido.setBounds(760, 569, btnwidth+50, btnheight);
		btnpedido.setBackground(Color.decode(btncolor1));
		btnpedido.setForeground(Color.WHITE);
		btnpedido.setFont(new Font(font, Font.BOLD, btnsize));
		contentCmenu.add(btnpedido);}
	}

	private void vistaEliminar() {
		// TODO Auto-generated method stub
		JPanel contentEliminar = new JPanel();
		contentEliminar.setBackground(Color.decode(backgroundcolor));
		contentEliminar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentEliminar);
		contentEliminar.setLayout(null);
		
		lblRecepcion.setText("Men� : Eliminar plato");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(490, 66, 412, 50);
		contentEliminar.add(lblRecepcion);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(235, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentEliminar.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(337, 578, 360, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentEliminar.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaMenu();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a Men�");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentEliminar.add(lblBack);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentEliminar.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(337, 155, 723, 393);
		contentEliminar.add(scrollPane);
		String [] titulos = {"Nombre","Disponibilidad", "Duraci�n","Precio"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		try {
			hotel.getCocina().printMenu(modeloTable);
		} catch (EArrayVacio e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(contentEliminar, e2.getMessage());
		}
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(table_1.getSelectedRow()!=-1) {
					p = hotel.getCocina().buscarPlato((String)table_1.getValueAt(table_1.getSelectedRow(),0));
					}else {
						JOptionPane.showMessageDialog(contentEliminar, "Porfavor seleccione un producto plato para continuar");
					}
					
				} catch (ECocina e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentEliminar, e1.getMessage());
				}
			}
		});
		JButton btnpedido = new JButton("Eliminar");
		btnpedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Eliminar producto");
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
				try {
					int validar = JOptionPane.showConfirmDialog(contentEliminar, "�Esta seguro de eliminar "+p.getNombre()+" del men�?");
					if(validar==0) {
					hotel.getCocina().removePlato(p);
					hotel.limpiarMenu(modeloTable);
					hotel.getCocina().printMenu(modeloTable);
					Recursos.WriteFileObjectEmpresa("hotel.dat", hotel);
					}
				} catch (ECocina | EArrayVacio e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentEliminar, e.getMessage());
					
				}
			}
		});
		btnpedido.setBounds(760, 578, btnwidth+50, btnheight);
		btnpedido.setBackground(Color.decode(btncolor1));
		btnpedido.setForeground(Color.WHITE);
		btnpedido.setFont(new Font(font, Font.BOLD, btnsize));
		contentEliminar.add(btnpedido);
		
	}

	private void vistaCrearPlato() {
		// TODO Auto-generated method stub
		JTextField txtPlatoName, txtDuracion,txtPrecio;
		JLabel lblNombre,Disponibilidad;
		
		JPanel contentPlato = new JPanel();
		contentPlato.setBackground(Color.decode(backgroundcolor));
		contentPlato.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPlato);
		contentPlato.setLayout(null);
		
		lblRecepcion.setText("Men� : Crear plato");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(507, 66, 363, 50);
		contentPlato.add(lblRecepcion);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(245, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons\\information.png");
		Icon iconoinfo  = new ImageIcon(iconinfo.getImage().getScaledInstance(lblInfo.getWidth(),lblInfo.getHeight(), Image.SCALE_DEFAULT));
		lblInfo.setIcon(iconoinfo);
		lblInfo.setVisible(false);
		contentPlato.add(lblInfo);
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(355, 578, 665, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPlato.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaMenu();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Volver a Men�");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		contentPlato.add(lblBack);
		
		txtPlatoName = new JTextField();
		txtPlatoName.setToolTipText("");
		txtPlatoName.setForeground(Color.BLACK);
		txtPlatoName.setFont(new Font(font, Font.PLAIN, fontsize));
		txtPlatoName.setBounds(355, 190, 300, 40);
		contentPlato.add(txtPlatoName);
		txtPlatoName.setColumns(100);
		txtPlatoName.setBackground(Color.decode(txtcolor1));
		txtPlatoName.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		
		
		JComboBox<String> cbPlato = new JComboBox<String>();
		cbPlato.setModel(new DefaultComboBoxModel<String>(new String[] {"S�", "No"}));
		cbPlato.setBackground(Color.WHITE);
		cbPlato.setForeground(Color.BLACK);
		cbPlato.setFont(new Font(font, Font.PLAIN, fontsize));
		cbPlato.setBounds(720, 190, 300, 40);
		cbPlato.setBorder(null);
		contentPlato.add(cbPlato);	
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentPlato.add(separator);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.decode(txtcolor1));
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(355, 170, 240, 15);
		contentPlato.add(lblNombre);
		
		Disponibilidad = new JLabel("Disponibilidad");
		Disponibilidad.setForeground(Color.decode(txtcolor1));
		Disponibilidad.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Disponibilidad.setBounds(720, 170, 240, 15);
		contentPlato.add(Disponibilidad);
			
		JLabel lblDuracin = new JLabel("Duraci\u00F3n");
		lblDuracin.setForeground(Color.WHITE);
		lblDuracin.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblDuracin.setBounds(355, 241, 240, 15);
		contentPlato.add(lblDuracin);
		
		txtDuracion = new JTextField();
		txtDuracion.setToolTipText("");
		txtDuracion.setForeground(Color.BLACK);
		txtDuracion.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtDuracion.setColumns(100);
		txtDuracion.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtDuracion.setBackground(Color.WHITE);
		txtDuracion.setBounds(355, 261, 300, 40);
		contentPlato.add(txtDuracion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblPrecio.setBounds(720, 241, 240, 15);
		contentPlato.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("");
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPrecio.setColumns(100);
		txtPrecio.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtPrecio.setBackground(Color.WHITE);
		txtPrecio.setBounds(720, 261, 300, 40);
		contentPlato.add(txtPrecio);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(false);	
		scrollPane.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(353, 377, 665, 188);
		String [] titulos = {"Nombre ", "Disponibilidad","Duraci�n", "Precio"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(table_1.getSelectedRow()!=-1) {
					p = hotel.getCocina().buscarPlato(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
					txtPlatoName.setText(p.getNombre());
					txtPlatoName.setEditable(false);
					txtDuracion.setText(Double.toString(p.getDuracion()));
					txtPrecio.setText(Double.toString(p.getValor()));
					}else {
						JOptionPane.showMessageDialog(contentPlato, "Porfavor seleccione un producto plato para continuar");
					}
					
				} catch (ECocina e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPlato, e1.getMessage());
				}
			}
		});
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(btnCrear.getText()=="Terminar") 
					textMensaje.setText("Finalizar la edici�n.");
				else 
					textMensaje.setText("Terminar el plato.");
				lblInfo.setVisible(true);	
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				if(btnCrear.getText()=="Crear") {
					hotel.getCocina().addPlato(txtPlatoName.getText(), cbPlato.getSelectedItem().toString(), txtDuracion.getText() , txtPrecio.getText());
					int validar = JOptionPane.showConfirmDialog(contentPlato,
							"Plato creado correctamente �Desea crear otro?");
					if (validar == 1) {
						getContentPane().setVisible(false);
						vistaMenu();
					}else if(validar==0||validar==2) {
						getContentPane().setVisible(false);
						vistaCrearPlato();
					}
				}else {
					hotel.getCocina().editPlato(cbPlato.getSelectedItem().toString(), txtDuracion.getText() , txtPrecio.getText(),p);
					int validar = JOptionPane.showConfirmDialog(contentPlato,
							"Plato editado correctamente �Desea editar otro?");
					if (validar == 1) {
						getContentPane().setVisible(false);
						vistaMenu();
					}else if(validar==0||validar==2) {
						getContentPane().setVisible(false);
						vistaCrearPlato();
					}
				}
				Recursos.WriteFileObjectEmpresa("hotel.dat", hotel);
			} catch (ECamposVacios | ELetrasEnCampoN | ECocina e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(contentPlato, e.getMessage());
			}
			}
		});
		btnCrear.setBounds(720, 326, btnwidth+50, btnheight);
		btnCrear.setBackground(Color.decode(btncolor1));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font(font, Font.BOLD, btnsize));
		contentPlato.add(btnCrear);
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(btnEditar.getText()=="Editar") 
					textMensaje.setText("Cargar lista de platos para editar.");
				else 
					textMensaje.setText("Crear nuevo plato.");
				lblInfo.setVisible(true);
			}
			@Override		
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!scrollPane.isVisible()) {
					try {						
						hotel.getCocina().printMenu(modeloTable);
						btnEditar.setText("Crear Nuevo");
						contentPlato.add(scrollPane);
						scrollPane.setVisible(true);
						btnCrear.setText("Terminar");
					} catch (EArrayVacio e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPlato, e.getMessage());
					}
				}else {
					btnEditar.setText("Editar");
					scrollPane.setVisible(false);
					txtPlatoName.setEditable(true);
					txtPlatoName.setText("");
					txtDuracion.setText("");
					txtPrecio.setText("");
					btnCrear.setText("Crear");
					hotel.limpiarMenu(modeloTable);
				}
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Century Gothic", Font.BOLD, 30));
		btnEditar.setBackground(new Color(58, 136, 219));
		btnEditar.setBounds(355, 326, 300, 40);
		contentPlato.add(btnEditar);
		
	
		
	}

	private void vistaMenu() {
		// TODO Auto-generated method stub
		contentMenu = new JPanel();
		contentMenu.setBackground(Color.decode(backgroundcolor));
		contentMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentMenu);
		contentMenu.setLayout(null);
		
		lblRecepcion.setText("Men�");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(644, 65, 200, 50);
		contentMenu.add(lblRecepcion);
		
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
			
		JLabel lblCrearPlato_1 = new JLabel("Crear Plato");
		lblCrearPlato_1.setBounds(310, 200, 256, 256);
		lblCrearPlato_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaCrearPlato();
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
				vistaEliminar();
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
				getContentPane().setVisible(false);
				vistaCMenu("",null);
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
		
		lblRecepcion.setText("Recepción");
		lblRecepcion.setForeground(Color.decode (txtcolor1));
		lblRecepcion.setFont(new Font("Dialog", Font.BOLD, 50));
		lblRecepcion.setBounds(504, 70, 300, 50);
		contentPane.add(lblRecepcion);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(278, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons" + File.separator + "information.png");
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
		textMensaje.setBounds(381, 614, 766, 50);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.decode(txtcolor1));
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPane.add(textMensaje);
			
		JLabel lblAgregar = new JLabel("Ckeck-in");
		lblAgregar.setLabelFor(lblAgregar);
		lblAgregar.setBounds(141, 287, 185, 169);
		lblAgregar.setForeground (Color.decode(txtcolor1));
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaServicios();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Hacer check-in a un usuario sobre una reserva.");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		ImageIcon imageIconAgregar = new ImageIcon("Icons" + File.separator + "stairs.png");
		Icon iconoAgregar = new ImageIcon (imageIconAgregar.getImage ().getScaledInstance(lblAgregar.getWidth (), lblAgregar.getHeight (), Image.SCALE_DEFAULT));
		lblAgregar.setIcon (iconoAgregar);	
		contentPane.add(lblAgregar);
		
		JLabel lblCancelar = new JLabel("Check-out");
		lblCancelar.setForeground (Color.decode(txtcolor1));
		lblCancelar.setBounds(559, 296, 185, 160);
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaMenu();
			}
			public void mouseEntered(MouseEvent arg0) {
				textMensaje.setText("Check-out de un usuario sobre una reserva");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		ImageIcon imageIconCancelar = new ImageIcon("Icons" + File.separator + "stair.png");
		Icon iconoCancelar = new ImageIcon (imageIconCancelar.getImage ().getScaledInstance(lblCancelar.getWidth (), lblCancelar.getHeight (), Image.SCALE_DEFAULT));
		lblCancelar.setIcon(iconoCancelar);	
		contentPane.add(lblCancelar);
		
		JLabel lblAgregar_1 = new JLabel("Check-in");
		lblAgregar_1.setForeground(Color.decode(txtcolor1));
		lblAgregar_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblAgregar_1.setBounds(141, 468, 199, 60);
		contentPane.add(lblAgregar_1);
		
		JLabel lblCancelar_1 = new JLabel("Check-out");
		lblCancelar_1.setForeground (Color.decode(txtcolor1));
		lblCancelar_1.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize+20));
		lblCancelar_1.setBounds(539, 468, 242, 60);
		contentPane.add(lblCancelar_1);
		
		JLabel lblEditar = new JLabel("Reservas");
		lblEditar.setBounds(977, 291, 185, 160);
		contentPane.add(lblEditar);
		
		JLabel label_1 = new JLabel("Reservas");
		label_1.setForeground(Color.decode(txtcolor1));
		label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		label_1.setBounds(964, 468, 211, 60);
		contentPane.add(label_1);

		lblEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getContentPane().setVisible(false);
				vistaMenu();
			}
			public void mouseEntered (MouseEvent arg0) {
				textMensaje.setText("Busca una reserva para editarla o cancelarla");
				lblInfo.setVisible(true);
			}			
			public void mouseExited(MouseEvent arg0) {
				textMensaje.setText("");
				lblInfo.setVisible(false);
			}
		});
		ImageIcon imageIconEditar = new ImageIcon("Icons" + File.separator + "clipboard.png");
		Icon iconoEditar = new ImageIcon (imageIconEditar.getImage ().getScaledInstance(lblEditar.getWidth (), lblEditar.getHeight (), Image.SCALE_DEFAULT));
		lblEditar.setIcon(iconoEditar);	
		contentPane.add(lblEditar);
	}
	
	private void vistaServicios() {
		contentServicios = new JPanel();
		contentServicios.setBackground(Color.decode(backgroundcolor));
		contentServicios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentServicios);
		contentServicios.setLayout(null);
		
		lblRecepcion.setText("Check-in");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(644, 65, 200, 50);
		contentServicios.add(lblRecepcion);
		
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
		JTextField txtUserName;
		JLabel lblNombre,Plato;
		
		contentPedido = new JPanel();
		contentPedido.setBackground(Color.decode(backgroundcolor));
		contentPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPedido);
		contentPedido.setLayout(null);
		
		lblRecepcion.setText("Servicio : pedido");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(520, 66, 339, 50);
		contentPedido.add(lblRecepcion);		
		
		
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
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
				vistaCMenu("Pedido",txtplato);
			}
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
		
		lblRecepcion.setText("Servicio : consulta");
		lblRecepcion.setForeground(Color.WHITE);
		lblRecepcion.setFont(new Font(font, Font.BOLD, 40));
		lblRecepcion.setBounds(512, 66, 353, 50);
		contentConsulta.add(lblRecepcion);		
		
		
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
