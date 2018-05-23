package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import exception.EArrayVacio;
import exception.ExceptionNodo;
import hotel.Empleado;
import hotel.Habitacion;
import hotel.Hotel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class FormReservas extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4873135912328496045L;
	private JPanel contentPane;
	private final String backgroundcolor="#44b256";
	private final String font= "Century Gothic";
	private JTextField textUsuario;
	private static DefaultTableModel Habitaciones_ModelTable;
	private JTable table;
	private JTextField textFieldFechaIn;
	private JTextField textFieldFechaOut;
	private JTextField textFieldTarifa;
	private JTextField textFieldIDReserva;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReservas frame = new FormReservas(null, null);
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
	public FormReservas(Hotel hotel, Empleado empleado) {
		
		JButton btnAgregar = new JButton("Agregar");
		JButton btnEditar = new JButton("Editar");
		
		JButton btnEliminar = new JButton("Eliminar");
		
		JButton btnVolver = new JButton("Volver");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 506);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReservas = new JLabel("RESERVAS");
		
		lblReservas.setBounds(264, 67, 212, 50);
		lblReservas.setFont(new Font(font, Font.BOLD, 40));
		lblReservas.setForeground(Color.WHITE);
		lblReservas.setText("RESERVAS");
		contentPane.add(lblReservas);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 128, 739, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		
		
		
		JLabel lblUsuario = new JLabel("Ingrese ID del usuario");
		lblUsuario.setBounds(26, 67, 123, 14);
		panel.add(lblUsuario);
		lblUsuario.setVisible(false);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(26, 83, 86, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setVisible(false);
		
		JLabel lblSeleccioneHabitacin = new JLabel("Seleccione Habitaci\u00F3n");
		lblSeleccioneHabitacin.setBounds(209, 67, 131, 14);
		panel.add(lblSeleccioneHabitacin);
		lblSeleccioneHabitacin.setVisible(false);
		
		
		
		
		
		
		textFieldFechaIn = new JTextField();
		textFieldFechaIn.setBounds(26, 185, 86, 20);
		panel.add(textFieldFechaIn);
		textFieldFechaIn.setColumns(10);
		textFieldFechaIn.setVisible(false);
		
		textFieldFechaOut = new JTextField();
		textFieldFechaOut.setBounds(26, 241, 86, 20);
		panel.add(textFieldFechaOut);
		textFieldFechaOut.setColumns(10);
		textFieldFechaOut.setVisible(false);
		
		JLabel lblFechaIngreso = new JLabel("Fecha ingreso (AAAA-MM-DD)\r\n");
		lblFechaIngreso.setBounds(26, 160, 156, 14);
		panel.add(lblFechaIngreso);
		lblFechaIngreso.setVisible(false);
		
		JLabel lblFechaSalida = new JLabel("Fecha salida (AAAA-MM-DD)");
		lblFechaSalida.setBounds(26, 216, 139, 14);
		panel.add(lblFechaSalida);
		lblFechaSalida.setVisible(false);
		
		textFieldTarifa = new JTextField();
		textFieldTarifa.setBounds(498, 282, 86, 20);
		panel.add(textFieldTarifa);
		textFieldTarifa.setColumns(10);
		textFieldTarifa.setVisible(false);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(442, 285, 46, 14);
		panel.add(lblTarifa);
		lblTarifa.setVisible(false);
		
		JLabel lblIDReserva = new JLabel("Ingrese el ID de la reserva");
		lblIDReserva.setBounds(26, 114, 140, 14);
		panel.add(lblIDReserva);
		lblIDReserva.setVisible(false);
		
		textFieldIDReserva = new JTextField();
		textFieldIDReserva.setBounds(26, 129, 86, 20);
		panel.add(textFieldIDReserva);
		textFieldIDReserva.setColumns(10);
		textFieldIDReserva.setVisible(false);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(297, 281, 89, 23);
		panel.add(btnFinalizar);
		btnFinalizar.setVisible(false);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefrescar. setBounds(421, 63, 89, 23);
		panel.add(btnRefrescar);
		btnRefrescar.setVisible(false);
		
		//JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVolver.setBounds(181, 281, 89, 23);
		panel.add(btnVolver);
		
		//JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnEliminar.setVisible(false);
				btnEditar.setVisible(false);
				lblUsuario.setVisible(true);
				textUsuario.setVisible(true);
				lblSeleccioneHabitacin.setVisible(true);
				textFieldFechaIn.setVisible(true);
				textFieldFechaOut.setVisible(true);
				lblFechaIngreso.setVisible(true);
				lblFechaSalida.setVisible(true);
				textFieldTarifa.setVisible(true);
				lblTarifa.setVisible(true);
				lblIDReserva .setVisible(true);
				textFieldIDReserva.setVisible(true);
				btnFinalizar.setVisible(true);
				btnRefrescar.setVisible(true);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(209, 90, 462, 171);
				panel.add(scrollPane);
				String [] titulos = {"ID","Tipo", "Precio"};	//crear vector con titulos de la tabla
				DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
				table = new JTable(modeloTable);							//cargar modelo en la tabla
				scrollPane.setViewportView(table);
				int i = table.getSelectedRow();
			    String ID = table.getValueAt(i, 1).toString();
				
				
				
				try {
					empleado.addReserva(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()),
							ID , hotel, hotel.buscarCliente(textUsuario.getText()));
				} catch (ExceptionNodo e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				btnRefrescar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					try {
						 hotel.limpiarMenu(modeloTable);
						 hotel.printHabitaciones(modeloTable,LocalDate.parse(textFieldFechaIn.getText()),LocalDate.parse(textFieldFechaOut.getText()));
					} catch (EArrayVacio e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(panel, e1.getMessage());
					}
				}
				});
				
				

				
				}
			});
		btnAgregar.setBounds(39, 23, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(314, 23, 89, 23);
		panel.add(btnEditar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(602, 23, 89, 23);
		panel.add(btnEliminar);
		
		
		
		
		
		
		
	}
}
