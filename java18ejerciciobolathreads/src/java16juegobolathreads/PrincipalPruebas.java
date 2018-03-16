package java16juegobolathreads;

public class PrincipalPruebas {

	public static void main(String[] args) {
		// cuando creemos una instancia usando new debemos indicar el
		// constructor a usar
		Bola b = new Bola(40, 50);
		// a veces necesitamos que los valores que tenga un objeto no se puedan
		// modificar desde fuera de su clase para que tengamos un control total
		// sobre los mismos

		// en este caso puedo darle un valor x o y inicial auna bola pero luego
		// no puedo modificarlas

		// saco el valor del return para obtener la x privada
		System.out.println("la bola esta en la posicion " + b.getx() + " "
				+ b.getY());

	}

}
