package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import exception.ECliente;
import exception.ExceptionNodo;
import hotel.Chef;
import hotel.Cliente;
import hotel.Empleado;
import hotel.Habitacion;
import hotel.Hotel;
import hotel.Persona;
import hotel.Reserva;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
	private JTextField textFieldHabitacion;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					Chef e = new Chef("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123");
					Empleado b = new Empleado("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123"){};
					FormReservas frame = new FormReservas(h, b);
					frame.setVisible(true);
//					h.getCocina().getMenu().add(new Plato("Bandeja ", true, 80.5, 5000));
//					h.getCocina().getMenu().add(new Plato("Bandeja 2 ", true, 80.5, 15000));
//					h.getCocina().getMenu().add(new Plato("Bandeja 3 ", true, 80.5, 18000));
					Cliente c = new Cliente("Lopez", "Daniel", "Sin especificar", "DD", "123", "CC", "123");
					Habitacion hab = new Habitacion("300", "Vip",1300);
					Habitacion hab1 = new Habitacion("301", "Vip",1300);
					Habitacion hab2 = new Habitacion("302", "Vip",1300);
					Habitacion hab3 = new Habitacion("303", "Vip",1300);
					Habitacion hab4 = new Habitacion("304", "Vip",1300);
					
					ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
					habitaciones.add(hab);
					habitaciones.add(hab1);
					habitaciones.add(hab2);
					habitaciones.add(hab3);
					habitaciones.add(hab4);
					
					h.setHabitaciones(habitaciones);
					
					
					Reserva r = new Reserva(null, null, hab);
					
					
	
					c.getReservasActivas().add(r);
					h.addUser(c);
					/*Date d1 = new Date("08/05/18") ;
					Date d2 = new Date("08/07/18") ;
				
					Cliente c1= new  Cliente("nombre"," apellido", "genero", "correo", "id", "tipoId", "pwd");
					c1.addReserva(d1, d2, "VIp", h);
					ArrayList<Plato> pla= new ArrayList<Plato>();
					pla.add(new Plato("Bandeja paisa", true, 80.0, 80.50));
					pla.add(new Plato("Ajiaco", true, 90.0, 80.50));
					System.out.println(c1.getReservasActivas().size());
					Pedido p1= new Pedido(c1.getReservasActivas().get(0), pla);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
public FormReservas(Hotel hotel, Persona empleado) {
		
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
		lblUsuario.setBounds(10, 67, 123, 14);
		panel.add(lblUsuario);
		lblUsuario.setVisible(false);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(10, 83, 86, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setVisible(false);
		
		JLabel lblSeleccioneHabitacin = new JLabel("Seleccione Habitaci\u00F3n");
		lblSeleccioneHabitacin.setBounds(232, 67, 131, 14);
		panel.add(lblSeleccioneHabitacin);
		lblSeleccioneHabitacin.setVisible(false);
		
		JLabel lblHabitacin = new JLabel("Habitaci\u00F3n");
		lblHabitacin.setBounds(10, 285, 86, 14);
		panel.add(lblHabitacin);
		lblHabitacin.setVisible(false);
		
		textFieldHabitacion = new JTextField();
		textFieldHabitacion.setBounds(87, 282, 86, 20);
		panel.add(textFieldHabitacion);
		textFieldHabitacion.setColumns(10);
		textFieldHabitacion.setVisible(false);
		
		
		
		
		textFieldFechaIn = new JTextField();
		textFieldFechaIn.setBounds(10, 185, 86, 20);
		panel.add(textFieldFechaIn);
		textFieldFechaIn.setColumns(10);
		textFieldFechaIn.setVisible(false);
		
		textFieldFechaOut = new JTextField();
		textFieldFechaOut.setBounds(10, 241, 86, 20);
		panel.add(textFieldFechaOut);
		textFieldFechaOut.setColumns(10);
		textFieldFechaOut.setVisible(false);
		
		JLabel lblFechaIngreso = new JLabel("Fecha ingreso (AAAA-MM-DD)\r\n");
		lblFechaIngreso.setBounds(10, 160, 156, 14);
		panel.add(lblFechaIngreso);
		lblFechaIngreso.setVisible(false);
		
		JLabel lblFechaSalida = new JLabel("Fecha salida (AAAA-MM-DD)");
		lblFechaSalida.setBounds(10, 216, 139, 14);
		panel.add(lblFechaSalida);
		lblFechaSalida.setVisible(false);
		
		textFieldTarifa = new JTextField();
		textFieldTarifa.setEditable(false);
		textFieldTarifa.setBounds(291, 282, 86, 20);
		panel.add(textFieldTarifa);
		textFieldTarifa.setColumns(10);
		textFieldTarifa.setVisible(false);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(252, 285, 46, 14);
		panel.add(lblTarifa);
		lblTarifa.setVisible(false);
		
		JLabel lblIDReserva = new JLabel("Ingrese el ID de la reserva");
		lblIDReserva.setBounds(10, 114, 140, 14);
		panel.add(lblIDReserva);
		lblIDReserva.setVisible(false);
		
		textFieldIDReserva = new JTextField();
		textFieldIDReserva.setBounds(10, 129, 86, 20);
		panel.add(textFieldIDReserva);
		textFieldIDReserva.setColumns(10);
		textFieldIDReserva.setVisible(false);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinalizar.setBounds(640, 281, 89, 23);
		panel.add(btnFinalizar);
		btnFinalizar.setVisible(false);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefrescar. setBounds(421, 63, 114, 23);
		panel.add(btnRefrescar);
		btnRefrescar.setVisible(false);
		
		//JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVolver.setBounds(541, 281, 89, 23);
		panel.add(btnVolver);
		
		//JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnAgregar.setVisible(false);
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
				lblHabitacin.setVisible(true);
				textFieldHabitacion.setVisible(true);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(209, 90, 462, 171);
				panel.add(scrollPane);
				String [] titulos = {"ID","Tipo", "Precio"};	//crear vector con titulos de la tabla
				DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
				table = new JTable(modeloTable);							//cargar modelo en la tabla
				scrollPane.setViewportView(table);
//				int i = table.getSelectedRow();
//		    String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
				
				
			    btnFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						
					if(textFieldFechaIn.getText().equals("") || textFieldFechaOut.getText().equals("") || textUsuario.getText().equals("") || textFieldIDReserva.getText().equals("") || textFieldHabitacion.getText().equals("")) 
						JOptionPane.showMessageDialog(contentPane, "Por favor llenar todos los campos");
					else {
						int validar = JOptionPane.showConfirmDialog(contentPane,"Est\u00e1 seguro de que la informaci\u00f3n es correcta?");
						if(validar==0) {
						try {
						   
							empleado.addReserva(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()),
									textFieldHabitacion.getText() , hotel, textUsuario.getText());
						} catch (ExceptionNodo e2) {
							
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}
						
						//JOptionPane.show("La reserva ha sido realizada con exito");
					
						btnAgregar.setVisible(true);
						btnEliminar.setVisible(true);
						btnEditar.setVisible(true);
						lblUsuario.setVisible(false);
						textUsuario.setVisible(false);
						textUsuario.setText("");
						lblSeleccioneHabitacin.setVisible(false);
						textFieldFechaIn.setVisible(false);
						textFieldFechaIn.setText("");
						textFieldFechaOut.setVisible(false);
						textFieldFechaOut.setText("");
						lblFechaIngreso.setVisible(false);
						lblFechaSalida.setVisible(false);
						textFieldTarifa.setVisible(false);
						textFieldTarifa.setText("");
						lblTarifa.setVisible(false);
						lblIDReserva .setVisible(false);
						textFieldIDReserva.setVisible(false);
						textFieldIDReserva.setText("");
						btnFinalizar.setVisible(false);
						btnRefrescar.setVisible(false);
						textFieldHabitacion.setText("");
						
						hotel.limpiarMenu(modeloTable);
						scrollPane.setVisible(false);
						
						lblHabitacin.setVisible(false);
						textFieldHabitacion.setVisible(false);
						}
					}
					}
				});
				
				
				
				btnRefrescar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					if ( textFieldFechaIn.getText().equals("") || textFieldFechaOut.getText().equals("")) {
						JOptionPane.showMessageDialog(contentPane,"Por favor llenar todos los campos");
					}else {
						hotel.limpiarMenu(modeloTable);
						// hotel.printHabitaciones(modeloTable,LocalDate.parse(textFieldFechaIn.getText()),LocalDate.parse(textFieldFechaOut.getText()));
						 refreshTablaHabitaciones(hotel,modeloTable,LocalDate.parse(textFieldFechaIn.getText()),LocalDate.parse(textFieldFechaOut.getText()));
						 Period a = Period.between(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()));
						
							 try {
								textFieldTarifa.setText(String.valueOf(Math.abs(hotel.buscarHabitacion(textFieldHabitacion.getText()).getPrecioNoche()
										 *(a.getDays()))));
							} catch (ECliente e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						}
				}
				});
				
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						btnAgregar.setVisible(true);
						btnEliminar.setVisible(true);
						btnEditar.setVisible(true);
						lblUsuario.setVisible(false);
						textUsuario.setVisible(false);
						textUsuario.setText("");
						lblSeleccioneHabitacin.setVisible(false);
						textFieldFechaIn.setVisible(false);
						textFieldFechaIn.setText("");
						textFieldFechaOut.setVisible(false);
						textFieldFechaOut.setText("");
						lblFechaIngreso.setVisible(false);
						lblFechaSalida.setVisible(false);
						textFieldTarifa.setVisible(false);
						textFieldTarifa.setText("");
						lblTarifa.setVisible(false);
						lblIDReserva .setVisible(false);
						textFieldIDReserva.setVisible(false);
						textFieldIDReserva.setText("");
						btnFinalizar.setVisible(false);
						btnRefrescar.setVisible(false);
						
						hotel.limpiarMenu(modeloTable);
						scrollPane.setVisible(false);
						
						lblHabitacin.setVisible(false);
						textFieldHabitacion.setVisible(false);
					}
				});
				
				

				
				}
			});
		btnAgregar.setBounds(39, 23, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setVisible(false);
				btnEliminar.setVisible(false);
				btnAgregar.setVisible(false);
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
				lblHabitacin.setVisible(true);
				textFieldHabitacion.setVisible(true);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(209, 90, 462, 171);
				panel.add(scrollPane);
				String [] titulos = {"ID","Tipo", "Precio"};	//crear vector con titulos de la tabla
				DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
				table = new JTable(modeloTable);							//cargar modelo en la tabla
				scrollPane.setViewportView(table);
//				int i = table.getSelectedRow();
//		    String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
				
				
			    btnFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						
					if(textFieldFechaIn.getText().equals("") && textFieldFechaOut.getText().equals("") && textUsuario.getText().equals("") && textFieldIDReserva.getText().equals("") && textFieldHabitacion.getText().equals("")) 
						JOptionPane.showMessageDialog(contentPane,"Por favor llenar todos los campos");
					else {
						int validar = JOptionPane.showConfirmDialog(contentPane,"Est\u00e1 seguro de que la informaci\u00f3n es correcta?");
						if(validar==0) {
						try {
						    //String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
							//empleado.addReserva(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()),
							//		textFieldHabitacion.getText() , hotel, textUsuario.getText());
							Reserva r = hotel.buscarCliente(textUsuario.getText()).buscarReserva(textFieldIDReserva.getText());
							r.setDate_in(LocalDate.parse(textFieldFechaIn.getText()));
							r.setDate_out(LocalDate.parse(textFieldFechaOut.getText()));
							r.setHabitacion(hotel.buscarHabitacion(textFieldHabitacion.getText()));
						
			    
						} catch (ExceptionNodo e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e2.getMessage());
						} catch (ECliente e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						
						//JOptionPane.show("La reserva ha sido realizada con exito");
					
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);
						btnAgregar.setVisible(true);
						lblUsuario.setVisible(false);
						textUsuario.setVisible(false);
						textUsuario.setText("");
						lblSeleccioneHabitacin.setVisible(false);
						textFieldFechaIn.setVisible(false);
						textFieldFechaIn.setText("");
						textFieldFechaOut.setVisible(false);
						textFieldFechaOut.setText("");
						lblFechaIngreso.setVisible(false);
						lblFechaSalida.setVisible(false);
						textFieldTarifa.setVisible(false);
						textFieldTarifa.setText("");
						lblTarifa.setVisible(false);
						lblIDReserva .setVisible(false);
						textFieldIDReserva.setVisible(false);
						textFieldIDReserva.setText("");
						btnFinalizar.setVisible(false);
						btnRefrescar.setVisible(false);
						textFieldHabitacion.setText("");
						
						hotel.limpiarMenu(modeloTable);
						scrollPane.setVisible(false);
						
						lblHabitacin.setVisible(false);
						textFieldHabitacion.setVisible(false);
					}
					}
					}
				});
				
				
				
				btnRefrescar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					hotel.limpiarMenu(modeloTable);
					// hotel.printHabitaciones(modeloTable,LocalDate.parse(textFieldFechaIn.getText()),LocalDate.parse(textFieldFechaOut.getText()));
					 refreshTablaHabitaciones(hotel,modeloTable,LocalDate.parse(textFieldFechaIn.getText()),LocalDate.parse(textFieldFechaOut.getText()));
					 Period a = Period.between(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()));
					
					 try {
						textFieldTarifa.setText(String.valueOf(Math.abs(hotel.buscarHabitacion(textFieldHabitacion.getText()).getPrecioNoche()
								 *(a.getDays()))));
					} catch (ECliente e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
				});
				
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);
						btnEditar.setVisible(true);
						lblUsuario.setVisible(false);
						textUsuario.setVisible(false);
						textUsuario.setText("");
						lblSeleccioneHabitacin.setVisible(false);
						textFieldFechaIn.setVisible(false);
						textFieldFechaIn.setText("");
						textFieldFechaOut.setVisible(false);
						textFieldFechaOut.setText("");
						lblFechaIngreso.setVisible(false);
						lblFechaSalida.setVisible(false);
						textFieldTarifa.setVisible(false);
						textFieldTarifa.setText("");
						lblTarifa.setVisible(false);
						lblIDReserva .setVisible(false);
						textFieldIDReserva.setVisible(false);
						textFieldIDReserva.setText("");
						btnFinalizar.setVisible(false);
						btnRefrescar.setVisible(false);
						
						hotel.limpiarMenu(modeloTable);
						scrollPane.setVisible(false);
						
						lblHabitacin.setVisible(false);
						textFieldHabitacion.setVisible(false);
					}
				});
				
				

				
				}
			});
		
		btnEditar.setBounds(314, 23, 89, 23);
		panel.add(btnEditar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminar.setVisible(false);
				btnAgregar.setVisible(false);
				btnEditar.setVisible(false);
				lblUsuario.setVisible(true);
				textUsuario.setVisible(true);
				lblIDReserva.setVisible(true);
				textFieldIDReserva.setVisible(true);
				btnFinalizar.setVisible(true);
				
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						btnEliminar.setVisible(true);
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						lblUsuario.setVisible(false);
						textUsuario.setVisible(false);
						lblIDReserva.setVisible(false);
						textFieldIDReserva.setVisible(false);
						btnFinalizar.setVisible(false);
						
						
						
						lblHabitacin.setVisible(false);
						textFieldHabitacion.setVisible(false);
					}
				});
				
				 btnFinalizar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						
							
							
						if( textUsuario.getText().equals("") && textFieldIDReserva.getText().equals("")) 
							JOptionPane.showMessageDialog(null,"Por favor llenar todos los campos");
						else {
							int validar = JOptionPane.showConfirmDialog(contentPane,"Est\u00e1 seguro de que la informaci\u00f3n es correcta?");
							if(validar==0) {
							try {
							    //String ID = table.getValueAt(table.getSelectedRow(), 0).toString();
								//empleado.addReserva(LocalDate.parse(textFieldFechaIn.getText()), LocalDate.parse(textFieldFechaOut.getText()),
								//		textFieldHabitacion.getText() , hotel, textUsuario.getText());
								
								hotel.buscarCliente(textUsuario.getText()).cancelReserva(textUsuario.getText());
								
							
				    
							} catch (ExceptionNodo e2) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e2.getMessage());
							}
							
							//JOptionPane.show("La reserva ha sido realizada con exito");
						
							btnEliminar.setVisible(true);
							btnAgregar.setVisible(true);
							btnEditar.setVisible(true);
							lblUsuario.setVisible(false);
							textUsuario.setVisible(false);
							lblIDReserva.setVisible(false);
							textFieldIDReserva.setVisible(false);
							btnFinalizar.setVisible(false);
							
							
							
							lblHabitacin.setVisible(false);
							textFieldHabitacion.setVisible(false);
						}
						}
						}
					});
				
				
				
			}
		});
		btnEliminar.setBounds(602, 23, 89, 23);
		panel.add(btnEliminar);
		
		
		
		
		
		
		
		
		
	}
private  void refreshTablaHabitaciones(Hotel h, DefaultTableModel modeloTable, LocalDate in, LocalDate out) {
		
		
		int numeroFilas = table.getRowCount();
		for (int i = numeroFilas - 1; i > 0; i--) {
			table.remove(i);
		}
		if(h.getHabitaciones()!=null) {
			int ps=h.getHabitaciones().size();
			table.setRowMargin(ps);
			if(ps<=0) {
				table.setRowHeight(1);
				for(int i=0;i<3;i++) {
					table.setValueAt(null, 0, i);
				}
			}else {
				int i=0;
				
			
				while (i<h.getHabitaciones().size() ) {
					if ( h.getHabitaciones().get(i).verDisponibilidad(in, out)) {
					String [] model = {h.getHabitaciones().get(i).getID(),h.getHabitaciones().get(i).getTipo(),Double.toString(h.getHabitaciones().get(i).getPrecioNoche())};
					modeloTable.addRow(model);
					}
					i++;
					
				}

		
			}
		
		}
		
	}
}

