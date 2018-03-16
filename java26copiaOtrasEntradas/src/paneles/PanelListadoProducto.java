package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.Producto;
import tableModels.TableModelProductos;
import daos.ProductosDAOimpl;


public class PanelListadoProducto extends JPanel{
	ProductosDAOimpl daoProductos = new ProductosDAOimpl();
	private Producto[] productos;

	public PanelListadoProducto() {
		this.add(new JLabel("soy el panel de listado de productos"));
	}

	public void refrescarProductos(){
		this.productos = daoProductos.obtenerProducto();
		JTable tabla = new JTable(new TableModelProductos(productos));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    this.add(scrollPane);
	}//end refrescarProductos
}
