package java12diferencias;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

	private Image original = null;
	private Image diferencia = null;

	// un constructor es un metodo que se ejecuta cuando se crea una merodo de
	// la clase
	public Ventana() {
		// cargamos las imagenes
		try {
			original = ImageIO.read(new File("original.jpg"));
			diferencia = ImageIO.read(new File("diferencia.jpg"));
		} catch (IOException e) {
			System.out.println("no pude cargar la imagen");
			System.exit(-1);
		}

		// esto es un constructor que se ejecutara cuando se haga un new
		// ventana(), esto es un sitio ideal para preparar al objeto
		this.setSize(800, 600); // this hace referencia al objeto que se creo
								// usando el new ventana
		this.setVisible(true);// en este cas this seria lo mismo que poner
								// miVentana desde el principal
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setTitle("haz click en la diferendia de la derecha");
		
		//agrego un escuchador para saber donde va haciendo click el usuario
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("click en x: " + x +" "+ "y: " + y);
				if(x>715 && x<740 && y>65 && y<105){
					JOptionPane.showMessageDialog(null, "adivinaste la diferencia");
				}else if(x<400){}
				else{
					JOptionPane.showMessageDialog(null, "eres un poco torpe");
				}
			}
		});
	}//fin de ventana

	public void paint(Graphics g) {
		super.paint(g);
		/*
		 * g.setColor(Color.GREEN); g.fillRect(50, 50, 100, 200);
		 */
		g.drawImage(original, 0, 0, 400, 400, null);
		g.drawImage(diferencia, 400, 0, 400, 400, null);
		
	}
	// private es que el elemento solo lo puedo usar desde dentro de la clase y
	// public desde cualquier sitio

}
