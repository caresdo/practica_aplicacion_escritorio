package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOimpl;
import modelo.Cliente;

public class PanelListadoCliente extends JPanel {

	ClientesDAOimpl daoClientes = new ClientesDAOimpl();
	private Cliente[] clientes;

	public PanelListadoCliente() {
		this.add(new JLabel("soy el panel de listado de clientes"));
	}

	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    this.add(scrollPane);
	}//end refrescarClientes
}// end PanelListadoClientes
