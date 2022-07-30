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

public class Panel_2 extends JFrame {// En el panel dos creamos nuestra tabla de reultados donde colocamos todas las
										// verificaciones de nuestro compilador y lenguaje.

	private JPanel contentPane;// Se utiliza para manejar el contenido del frame.
	public JFrame ventana;// La venta va encima del panel.
	private JTable table;// Jtable lo usamos para almacenar un estructura en forma de tabla en java.
	private Panel_Principal p = new Panel_Principal();// Instanciamos el panel principal para despues utilizarlo al
														// momento de llenar nuestra tabla.
	private static String[][] datos = new String[0][0];// Asignamos una matriz de tipo String para llenar los datos
														// internos de la tabla con el fichero.
	private static final String[] titulos = { "Simbolo", "Ubicacion", "Tipos" };// Asiganmos un arreglo en donde van los
																				// titulos de la tabla.

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {//En el main colocamos la ejecucion del frame.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_2 frame = new Panel_2(datos);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String[][] getDatos() {//Este get lo usamos para manipular el acceso a los datos.
		return datos;
	}

	public void setDatos(String[][] datos) {//S utiliza para setear el contenico del fichero a la matriz datos.
		this.datos = datos;
	}

	/**
	 * Create the frame.
	 */
	public Panel_2(String[][] data) {//Es este constructor colocamos un parametro en el cual cuando se cree la tabla ya 
		//coloquemos los datos del ficheroEscritura en la matriz y asi podamos mostrar toda la informacion.
		this.datos = data;
		// Panel_Principal p = new Panel_Principal();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(10, 22, 716, 219);
		contentPane.add(table);
		ventana = new JFrame("Tablas");
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setSize(738, 200);
		set_Table();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void set_Table() {//Es este set_Table lo que hacemos es asignarle un scroll a la tabla para que podamos subir y 
		//bajar de manera muy facil y sea comodo verificar los datos.
		table = new JTable(datos, titulos);
		table.revalidate();
		JScrollPane JS = new JScrollPane(table);
		JS.setPreferredSize(new Dimension(700, 150));
		ventana.getContentPane().add(JS);
	}

}
