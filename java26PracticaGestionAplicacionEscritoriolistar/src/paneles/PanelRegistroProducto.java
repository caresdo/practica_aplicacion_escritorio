package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ProductosDAOimpl;
import modelo.Producto;

public class PanelRegistroProducto extends JPanel implements ActionListener{
	
	JTextField campoNombre = new JTextField(15);
	JTextField campoCantidad = new JTextField(15);
	JTextField campoPrecio = new JTextField(15);
	JTextField campoOferta = new JTextField(15);
	JTextField campoFechaCad = new JTextField(15);
	JTextField campoProveedor = new JTextField(15);
	JTextField campoComentario = new JTextField(15);
	
	public PanelRegistroProducto() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("introduce datos de producto"), gbc);
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
		this.add(new JLabel("cantidad:"), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoCantidad, gbc);
		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("precio:"), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPrecio, gbc);
		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("oferta:"), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoOferta, gbc);
		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("fecha caducidad:"), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoFechaCad, gbc);
		// septima fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("proveedor:"), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoProveedor, gbc);
		//octava fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("comentario:"), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoComentario, gbc);
		//novena fila
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		// creamos boton
		JButton botonRegistroProducto = new JButton("registrar");
		botonRegistroProducto.addActionListener(this);
		this.add(botonRegistroProducto, gbc);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Boton panelregistroproducto");
		String nombre = campoNombre.getText();
		String cantidad = campoCantidad.getText();
		String precio = campoPrecio.getText();
		String oferta = campoOferta.getText();
		String fechaCad = campoFechaCad.getText();
		String proveedor = campoProveedor.getText();
		String comentario = campoComentario.getText();
		
		Producto productoARegistrar = new Producto(nombre, cantidad, precio, oferta, fechaCad, proveedor, comentario);
		ProductosDAOimpl productoDAO = new ProductosDAOimpl();
		productoDAO.registrarProducto(productoARegistrar);
	}
	

}
