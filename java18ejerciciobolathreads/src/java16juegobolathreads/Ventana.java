package java16juegobolathreads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame implements Runnable {
	private Bola bola = new Bola(50, 50);
	boolean hiloActivo = true;
	Thread hilo = new Thread(this);
	private Zona zona = new Zona(700, 300, 100, 200, Color.GREEN);
	private Zona zona1 = new Zona(200, 100, 100, 100, Color.RED);
	private Zona zona2 = new Zona(100, 400, 100, 100, Color.RED);
	private Zona zona3 = new Zona(500, 300, 100, 100, Color.RED);
	private int velocidad = 10;
	
	public Ventana() {
		this.setSize(800, 600);
		this.setLocation(50, 50);
		this.setTitle("lleva la bola hasta la zona de meta");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		this.setContentPane(new JComponent() {
			public void paint(Graphics g) {
				super.paint(g);
				bola.dibujar(g);
				zona.dibujar(g);
				zona1.dibujar(g);
				zona2.dibujar(g);
				zona3.dibujar(g);
			}
		});
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == 39) {
					bola.direccionBola = Direcciones.DERECHA;
				} else if (e.getKeyCode() == 40) {
					bola.direccionBola = Direcciones.ABAJO;
				}else if (e.getKeyCode() == 37){
					bola.direccionBola = Direcciones.IZQUIERDA;
				}else if (e.getKeyCode() == 38){
					bola.direccionBola = Direcciones.ARRIBA;
				}
			}
		});
		hilo.start();
		/*
		 * @Override public void paint(Graphics g) { super.paint(g);
		 * bola.dibujar(g); }
		 */
		// vamos a mostrarle a la ventana que es lo que va a dibujar
		
	}

	@Override
	public void run() {
		while (hiloActivo) {
			bola.mover();
			if (zona.detectarColision(bola)) {
				JOptionPane.showMessageDialog(null, "FELICIDADES HAS GANADO");
				velocidad= velocidad / 2;
				bola.reinicio();
				
			} else if (bola.getx() > this.getWidth()
					|| bola.getY() > this.getHeight()
					|| bola.getx() < -50
					|| bola.getY() < -50) {
				JOptionPane.showMessageDialog(null, "has perdido");
				zona1 = new Zona(200, 100, 100, 100, Color.RED);
				bola.reinicio();
			} else if (zona1.detectarColision(bola) || zona2.detectarColision(bola) || zona3.detectarColision(bola)){
				JOptionPane.showMessageDialog(null, "te has chocado");
				bola.reinicio();
			}

			repaint();
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				System.out.println("se ha interrumpido el sleep");
			}
		}

	}
}
