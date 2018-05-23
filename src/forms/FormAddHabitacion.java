package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import exception.EArrayVacio;
import exception.ECamposVacios;
import exception.ECliente;
import exception.ECocina;
import hotel.Administrador;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Recursos;


public class FormAddHabitacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9202313976634921997L;
	private JPanel contentPane;
	private final String backgroundcolor="#44b256";
	private final String font= "Century Gothic";
	private final int fontsize=20;
	private final String txtcolor1= "#FFFFFF";
	private JTable table_1;
	private final int btnwidth= 250;
	private final int btnheight= 40;
	private final int btnsize= 30;
	private final String btncolor1= "#3a88db";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					Administrador e = new Administrador("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123");
					FormAddHabitacion frame = new FormAddHabitacion(h,e);
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
	public FormAddHabitacion(Hotel hotel, Administrador admin) {
		setForeground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setFont(new Font(font, Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextField txtId,txtPrecio;
		JLabel lblNombre,Disponibilidad;
		
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setForeground(Color.WHITE);
		lblHabitacion.setFont(new Font(font, Font.BOLD, 40));
		lblHabitacion.setBounds(507, 66, 363, 50);
		contentPane.add(lblHabitacion);		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(245, 578, 100, 100);
		ImageIcon iconinfo =new ImageIcon("Icons"+File.separator+"information.png");
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
		textMensaje.setBounds(355, 578, 665, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPane.add(textMensaje);
		JLabel lblBack = new JLabel("Back");
		lblBack.setBounds(185, 296, 64, 64);
		lblBack.setIcon(new ImageIcon("Icons\\back1.png"));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().setVisible(false);
	
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
		contentPane.add(lblBack);
		
		txtId = new JTextField();
		txtId.setToolTipText("");
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font(font, Font.PLAIN, fontsize));
		txtId.setBounds(355, 190, 300, 40);
		contentPane.add(txtId);
		txtId.setColumns(100);
		txtId.setBackground(Color.decode(txtcolor1));
		txtId.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		
		
		JComboBox<String> cbDisponibilidad = new JComboBox<String>();
		cbDisponibilidad.setModel(new DefaultComboBoxModel<String>(new String[] {"S�", "No"}));
		cbDisponibilidad.setBackground(Color.WHITE);
		cbDisponibilidad.setForeground(Color.BLACK);
		cbDisponibilidad.setFont(new Font(font, Font.PLAIN, fontsize));
		cbDisponibilidad.setBounds(720, 190, 300, 40);
		cbDisponibilidad.setBorder(null);
		contentPane.add(cbDisponibilidad);	
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentPane.add(separator);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.decode(txtcolor1));
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(355, 170, 240, 15);
		contentPane.add(lblNombre);
		
		Disponibilidad = new JLabel("Disponibilidad");
		Disponibilidad.setForeground(Color.decode(txtcolor1));
		Disponibilidad.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		Disponibilidad.setBounds(720, 170, 240, 15);
		contentPane.add(Disponibilidad);
			
		JLabel lblDuracin = new JLabel("Tipo");
		lblDuracin.setForeground(Color.WHITE);
		lblDuracin.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblDuracin.setBounds(355, 241, 240, 15);
		contentPane.add(lblDuracin);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		lblPrecio.setBounds(720, 241, 240, 15);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("");
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPrecio.setColumns(100);
		txtPrecio.setBorder(new LineBorder(Color.decode(txtcolor1), 3, true));
		txtPrecio.setBackground(Color.WHITE);
		txtPrecio.setBounds(720, 261, 300, 40);
		contentPane.add(txtPrecio);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(false);	
		scrollPane.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(353, 377, 665, 188);
		JComboBox<String> cbTipo = new JComboBox<String>();
		cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"VIP", "Presidencial", "Normal"}));
		cbTipo.setForeground(Color.BLACK);
		cbTipo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cbTipo.setBorder(null);
		cbTipo.setBackground(Color.WHITE);
		cbTipo.setBounds(355, 261, 300, 40);
		contentPane.add(cbTipo);
		String [] titulos = {"Nombre ","Tipo", "Disponibilidad","Precio"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(table_1.getSelectedRow()!=-1) {
						Habitacion habitacion = admin.buscarHabitacion(table_1.getValueAt(table_1.getSelectedRow(),0).toString(), hotel);
						txtId.setText(habitacion.getID());
						txtPrecio.setText(String.valueOf(habitacion.getPrecioNoche()));
						cbTipo.setToolTipText(habitacion.getTipo());
					}else {
						JOptionPane.showMessageDialog(contentPane, "Porfavor seleccione una habitación para continuar");
					}
					
				} catch (ECliente e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
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
						admin.addHabitacion(txtId.getText(), cbTipo.getSelectedItem().toString(), Double.valueOf(txtPrecio.getText()), hotel);
						Recursos.WriteFileObjectEmpresa("hotel.dat", hotel);
						int validar = JOptionPane.showConfirmDialog(contentPane,
								"Habitacion creada correctamente �Desea crear otra?");
						if (validar == 0) {
							dispose();
							new FormAddHabitacion(hotel, admin).setVisible(true);
						}else {
							dispose();
						}
					}
					else {
						admin.editarHabitacion(txtId.getText(), cbDisponibilidad.getSelectedItem().toString(), 
								txtPrecio.getText(), cbTipo.getSelectedItem().toString(), hotel);
						Recursos.WriteFileObjectEmpresa("hotel.dat", hotel);
						int validar = JOptionPane.showConfirmDialog(contentPane,
								"Habitacion editada correctamente �Desea editar otra?");
						if (validar == 0) {
							dispose();
							new FormAddHabitacion(hotel, admin).setVisible(true);
						}else {
							dispose();
						}
					}
				} catch (NumberFormatException | ECamposVacios | ECliente e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		});
		btnCrear.setBounds(720, 326, 300, 40);
		btnCrear.setBackground(Color.decode(btncolor1));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font(font, Font.BOLD, btnsize));
		contentPane.add(btnCrear);
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(btnEditar.getText()=="Editar") 
					textMensaje.setText("Cargar lista de habitaciones para editar.");
				else 
					textMensaje.setText("Crear nuevo habitación.");
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
						admin.ConsultaHabitaciones(modeloTable, hotel);
						btnEditar.setText("Crear Nuevo");
						contentPane.add(scrollPane);
						scrollPane.setVisible(true);
						btnCrear.setText("Terminar");
					} catch (EArrayVacio e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				}else {
					btnEditar.setText("Editar");
					scrollPane.setVisible(false);
					txtId.setEditable(true);
					txtId.setText("");
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
		contentPane.add(btnEditar);
		
		
	
		
		
	}
}
