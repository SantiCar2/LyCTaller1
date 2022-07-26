import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Panel_2 extends JFrame {

	private JPanel contentPane;
	public JFrame ventana;
	private JTable table;
	private String[][] datos = {{ "1", "Fernando", "Castillo", "Ecuador" },
			{ "2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" },
			{"2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" }
			, {"2", "Fernando", "Castillo", "Ecuador" },{"2", "Fernando", "Castillo", "Ecuador" }};
	private String[] titulos = { "Simbolo", "Ubicacion", "Tipo 1", "Tipo2" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_2 frame = new Panel_2();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panel_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(10, 22, 416, 219);
		contentPane.add(table);
		ventana = new JFrame("Tablas");
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setSize(438, 200);
		set_Table();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	private void set_Table() {
		table = new JTable(datos, titulos);
		JScrollPane JS = new JScrollPane(table);
		JS.setPreferredSize(new Dimension(400, 150));
		ventana.getContentPane().add(JS);

	}

}