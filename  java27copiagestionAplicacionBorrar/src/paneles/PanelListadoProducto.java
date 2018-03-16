package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import modelo.Producto;
import tableModels.TableModelProductos;
import daos.ProductosDAOimpl;


public class PanelListadoProducto extends JPanel implements ActionListener{
	ProductosDAOimpl daoProductos = new ProductosDAOimpl();
	private Producto[] productos;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoProducto() {
		this.add(new JLabel("soy el panel de listado de productos"));
	}

	public void refrescarProductos(){
		this.productos = daoProductos.obtenerProducto();
		tabla = new JTable(new TableModelProductos(productos));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(700, 500));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    //this.removeAll();
	    this.add(botonBorrar);
	    this.add(scrollPane);
	    
	    botonBorrar.addActionListener(this);
	}//end refrescarProductos
	
	public void actionPerformed(ActionEvent arg0) {
		if (tabla.getSelectedRow() == -1){
			return;
		}
		
		JOptionPane.showMessageDialog(null, "borrar: " + productos[tabla.getSelectedRow()].toString());
		daoProductos.borrarProducto(productos[tabla.getSelectedRow()].getId());
		refrescarProductos();
		SwingUtilities.updateComponentTreeUI(this);
	}
}
