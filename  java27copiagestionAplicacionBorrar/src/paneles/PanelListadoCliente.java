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
import javax.swing.table.TableModel;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOimpl;
import modelo.Cliente;

public class PanelListadoCliente extends JPanel implements ActionListener{

	ClientesDAOimpl daoClientes = new ClientesDAOimpl();
	private Cliente[] clientes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	public PanelListadoCliente() {
		this.add(new JLabel("soy el panel de listado de clientes"));
	}

	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(700, 500));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    //this.removeAll();
	    this.add(botonBorrar);
	    this.add(scrollPane);
	    
	    botonBorrar.addActionListener(this);
	}//end refrescarClientes

	public void actionPerformed(ActionEvent arg0) {
		if (tabla.getSelectedRow() == -1){
			return;
		}
		
		JOptionPane.showMessageDialog(null, "borrar: " + clientes[tabla.getSelectedRow()].toString());
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrescarClientes();
		SwingUtilities.updateComponentTreeUI(this);
	}
}// end PanelListadoClientes
