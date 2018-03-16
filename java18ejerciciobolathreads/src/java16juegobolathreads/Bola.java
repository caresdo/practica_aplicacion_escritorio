package java16juegobolathreads;

import java.awt.Color;
import java.awt.Graphics;

public class Bola {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	public Direcciones direccionBola = Direcciones.DERECHA;

	// si no hay ningun contructor mas java incluye uno vacio que no tiene nada
	// ni hace nada
	public Bola(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho = 50;
		this.alto = 50;
	}

	// metodo de acceso para las x
	public int getx() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void mover() {
		if (direccionBola == Direcciones.DERECHA) {
			x++;
		} else if (direccionBola == Direcciones.ABAJO) {
			y++;
		} else if (direccionBola == Direcciones.ARRIBA){
			y--;
		}else if (direccionBola == Direcciones.IZQUIERDA){
			x--;
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, ancho, alto);
	}
	
	public void reinicio(){
		x = 0;
		y = 0;
	}
}
