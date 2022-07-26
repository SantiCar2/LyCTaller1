import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;

public class Panel_Principal extends JFrame {

	private JPanel contentPane;
	private static final String rutaSimbolos = "C:\\Users\\Dennis\\eclipse-workspace\\LenguajesCompiladores\\Archivos\\Simbolos.txt";
	private static final String rutaOperadores = "C:\\Users\\Dennis\\eclipse-workspace\\LenguajesCompiladores\\Archivos\\Operadores.txt";
	private static final String rutaCondicionales = "C:\\Users\\Dennis\\eclipse-workspace\\LenguajesCompiladores\\Archivos\\Condicionales.txt";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public Panel_Principal() {
		Panel_2 p2 = new Panel_2();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnNewButton = new JButton("Verificar\r\n");
		btnNewButton.setBounds(214, 201, 164, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Ingrese su parrafo:\r\n");
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(228, 0, 217, 25);
		contentPane.add(lblNewLabel);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 565, 154);
		contentPane.add(textPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 p2.ventana.setVisible(true);

				File doc = new File(rutaSimbolos);

				BufferedReader obj = null;
				try {
					obj = new BufferedReader(new FileReader(doc));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String strng;
				try {
					while ((strng = obj.readLine()) != null);
						//System.out.println(strng);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
	}
}
