package java16juegobolathreads;

import java.awt.Color;
import java.awt.Graphics;

public class Zona {
private int x;
private int y;
private int ancho;
private int alto;
private Color color;

public Zona(int x, int y, int ancho, int alto, Color color) {
	this.x = x;
	this.y = y;
	this.ancho = ancho;
	this.alto = alto;
	this.color = color;
}
public boolean detectarColision(Bola b){
	if(b.getx() >= this.x && b.getx() <= (this.x+this.ancho) &&
		b.getY() >= this.y && b.getY() <= (this.y+this.alto)){
			return true;
		}else {
			return false;
		}
}

public void dibujar(Graphics g){
	g.setColor(color);
	g.fillRect(x, y, ancho, alto);
}
}
