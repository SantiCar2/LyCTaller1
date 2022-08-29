import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Panel_Principal extends JFrame {// Definimos la clase Panel Principal en la cual vamos a almacenar nuestro
	// texto escrito por el usuario.
	
	private JPanel contentPane;// Se utiliza para almacenar todas las plantillas en el front
	private static final String rutaSimbolos = "Archivos\\\\Simbolos.txt";// Es la ruta que
	// utilizamos para almacenar nuestra tabla de simbolos.
	private static final String rutaEscritura = "Archivos\\\\EscribeAqui.txt";// Esta ruta se
	// utiliza para el fichero en el cual se debee escribir el texto para despues
	// compilar nuestro lenguaje.
	public static Queue<tuplaSimbolos> tuplas = new LinkedList<tuplaSimbolos>();// Utilizamos un Queque para almacenar
	// nuestra tupla de simbolos

	public Main m = new Main(); // Definimos el main como variable para utilizarlo en el Front
	public String textoParrafos; // Se utiliza para almacenar el parrafo de nuestro fichero

	// private static Queue<String> textoParrafo = new LinkedList<String>();

	// private static final String rutaOperadores =
	// "C:\\Users\\Dennis\\eclipse-workspace\\LenguajesCompiladores\\Archivos\\Operadores.txt";
	// private static final String rutaCondicionales =
	// "C:\\Users\\Dennis\\eclipse-workspace\\LenguajesCompiladores\\Archivos\\Condicionales.txt";

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {// Este main nos ejecuta El frame el cual contiene el panel principal.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_Principal frame = new Panel_Principal();
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
	public Panel_Principal() {// Definimos el constructor del panel principal vacio en el cual creamos los
		// paneles y todos los esquemas de dise�o.
		// Panel_2 p2 = new Panel_2();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton1 = new JButton("Tabla de simbolos\r\n");
		btnNewButton1.setBounds(195, 70, 185, 23);
		contentPane.add(btnNewButton1);

		JButton btnNewButton2 = new JButton("Salir\r\n");
		btnNewButton2.setBounds(195, 209, 185, 23);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Tabla de Tokens\r\n");
		btnNewButton3.setBounds(195, 116, 185, 23);
		contentPane.add(btnNewButton3);

		JLabel lblNewLabel = new JLabel("Porfavor seleccione el boton:\r\n");
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(192, 0, 228, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnOperacionesAritmeticas = new JButton("Operaciones Aritmeticas");
		btnOperacionesAritmeticas.setBounds(195, 163, 185, 23);
		contentPane.add(btnOperacionesAritmeticas);

		/*
		 * JTextPane textPane = new JTextPane(); textPane.setBounds(10, 36, 565, 154);
		 * contentPane.add(textPane);
		 */

		try {
			// textPane.setText(Main.extraerFicheroEscritura());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Se define el metodo actionPerformed en el que agregamos un
				// boton que cuando se ejecute verifique el parrafo escrito
				// en el fichero y despues creemos una tabla donde colocamos
				// todos nuestros resultados.
				// Main.crearTabla(tuplas, textoParrafos).forEach(s -> System.out.println(s))
				JFileChooser j = new JFileChooser();
				if (j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					Main.rutaEscritura = j.getSelectedFile().getAbsolutePath();
					
				}
				try {
					tuplas = Main.extraerFicheroSimbolo();
					/* textPane.setText(Main.extraerFicheroEscritura()); */
					Panel_2 p = null;
					p = new Panel_2(Main.tableData(Main.crearTabla(tuplas, textoParrafos)));
					p.ventana.setVisible(true);
					dispose();
		
					

				} catch (Excepciones e1) {
					e1.printStackTrace();
				}

				;

			}
		});
		
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Boton para salir del programa.
				dispose();
			}
		});
		
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Boton para salir del programa.
				JFileChooser j = new JFileChooser();
				if (j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					Main.rutaEscritura = j.getSelectedFile().getAbsolutePath();
					
				}
				try {
					tuplas = Main.extraerFicheroSimbolo();
					/* textPane.setText(Main.extraerFicheroEscritura()); */
					Panel_3 p = null;
					p = new Panel_3(Main.tablaDeTokens(Main.crearTabla(tuplas, textoParrafos)));
					p.ventana.setVisible(true);
					dispose();
		
					

				} catch (Excepciones e1) {
					e1.printStackTrace();
				}

				;

			}
		});
		
		btnOperacionesAritmeticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Boton para salir del programa.
				JFileChooser j = new JFileChooser();
				if (j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					Main.rutaEscritura = j.getSelectedFile().getAbsolutePath();
					
				}
				try {
					tuplas = Main.extraerFicheroSimbolo();

					Panel_4 p = null;
					p = new Panel_4(Main.operacionesAritmeticasData(Main.crearTabla(tuplas, textoParrafos), Main.extraerFicheroEscritura()));
					p.ventana.setVisible(true);
					dispose();
		
					

				} catch (Excepciones e1) {
					e1.printStackTrace();
				}

				;

			}
		});

	}

}
