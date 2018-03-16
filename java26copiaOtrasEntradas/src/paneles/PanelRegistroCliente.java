package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAO;
import daos.ClientesDAOimpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener {

	JTextField campoNombre = new JTextField(15);
	JTextField campoDomicilio = new JTextField(15);
	JTextField campoPoblacion = new JTextField(15);
	JTextField campoCodigoPostal = new JTextField(15);
	JTextField campoTelefono = new JTextField(15);

	public PanelRegistroCliente() {

		// vamos a crear un gestor que permita colocar las cosas en forma de
		// filas y celdas
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("introduce datos de cliente"), gbc);
		// segunda fila
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		this.add(new JLabel("nombre:"), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);
		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Domicilio:"), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio, gbc);
		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Poblacion:"), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion, gbc);
		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Codigo Postal:"), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal, gbc);
		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Telefono:"), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono, gbc);
		// septima fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		// creamos boton
		JButton botonRegistroCliente = new JButton("registrar");
		botonRegistroCliente.addActionListener(this);
		this.add(botonRegistroCliente, gbc);

	}// end panelRegistroCliente()

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Boton panelregistrocliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();
		// validar estos datos TODO
		
		Cliente clienteARegistrar = new Cliente(nombre, domicilio, poblacion, codigoPostal, telefono);
		System.out.println("voy a registrar:" + clienteARegistrar.toString());
		//voy a invocar lo necesario de la capa de datos para registrar al cliente
		ClientesDAOimpl clienteDAO = new ClientesDAOimpl();
		clienteDAO.registrarCliente(clienteARegistrar);
		
	}// end actionperformer

}// endclass
