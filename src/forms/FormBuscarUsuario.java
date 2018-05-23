package forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import hotel.Cliente;
import hotel.Hotel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class FormBuscarUsuario extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1943671760146660323L;
	private JPanel contentPane;
	private Hotel hotel;
	private final String backgroundcolor="#44b256";
	private final String txtcolor1= "#FFFFFF";
	private final String font= "Century Gothic";
	private final int fontsize=30;
	private JLabel lblCocina ;
	private JTable table_1;
	private JTextField textFieldBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel h = new Hotel();
					
					Cliente a = new Cliente("a", "a", "Sin especificar", "DD", "1234", "CC", "123");
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
					FormBuscarUsuario frame = new FormBuscarUsuario(h, new JTextField ());
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
	public FormBuscarUsuario(Hotel h,JTextField campo) {
		hotel=h;
		setForeground(Color.WHITE);
		setExtendedState(MAXIMIZED_BOTH);
		setFont(new Font(font, Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cocina");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\oficcial.png"));
		setBounds(0, 0, 1366, 768);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(backgroundcolor));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCocina = new JLabel("Buscar Usuario");
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
		
		JTextArea textMensaje = new JTextArea();
		textMensaje.setWrapStyleWord(true);
		textMensaje.setLineWrap(true);
		textMensaje.setTabSize(4);
		textMensaje.setEditable(false);
		textMensaje.setRows(3);
		textMensaje.setBounds(337, 578, 400, 100);
		textMensaje.setBackground(Color.decode(backgroundcolor));
		textMensaje.setForeground(Color.WHITE);
		textMensaje.setFont(new Font(font, Font.PLAIN | Font.ITALIC, fontsize));
		contentPane.add(textMensaje);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.decode("#c4c4c4"));
		separator.setBounds(313, 141, 763, 20);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(337, 217, 720, 330);
		contentPane.add(scrollPane);
		String [] titulos = {"id","Nombre", "Apellido","Reserva"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla
		scrollPane.setViewportView(table_1);
		try {
			h.ConsultaUsuarios(modeloTable);
		} catch (EArrayVacio e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRow()==-1) {			//comprobar que se seleccione una fila
					JOptionPane.showMessageDialog(contentPane, "Porfavor seleccione un producto para continuar");
					dispose();
				}else {//si se selecciona fila pasar contenido del sku al textfile del form para agregar producto
					campo.setText((String) table_1.getValueAt(table_1.getSelectedRow(), 0));
					dispose();
				}
			}
		});
		btnSeleccionar.setForeground(Color.WHITE);
		btnSeleccionar.setFont(new Font("Century Gothic", Font.BOLD, 30));
		btnSeleccionar.setBackground(new Color(58, 136, 219));
		btnSeleccionar.setBounds(760, 600, 300, 40);
		contentPane.add(btnSeleccionar);
		
		
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(467, 166, 430, 40);
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
				try {
					hotel.ConsultaUsuarios(modeloTable, textFieldBuscar.getText());
				} catch (EArrayVacio e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		});
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setFont(new Font("Century Gothic", Font.BOLD, 30));
		btnFiltrar.setBackground(new Color(58, 136, 219));
		btnFiltrar.setBounds(907, 166, 150, 40);
		contentPane.add(btnFiltrar);
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font(font, Font.BOLD | Font.ITALIC, fontsize));
		lblBuscar.setBounds(347, 166, 100, 40);
		contentPane.add(lblBuscar);
	}
}
