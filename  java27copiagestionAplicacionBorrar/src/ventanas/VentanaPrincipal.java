package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoCliente;
import paneles.PanelListadoProducto;
import paneles.PanelRegistroCliente;
import paneles.PanelRegistroProducto;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private PanelRegistroCliente panelRegistroCliente = new PanelRegistroCliente();
	private PanelListadoCliente panelListadoCliente = new PanelListadoCliente();
	private PanelRegistroProducto panelRegistroProducto = new PanelRegistroProducto();
	private PanelListadoProducto panelListadoProducto = new PanelListadoProducto();
	
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuclientes = new JMenu("clientes");
	private JMenu menuProductos = new JMenu("productos");
	private JMenu menuAyuda = new JMenu("Ayuda");

	public VentanaPrincipal() {
		// preparar la barra de menu
		JMenuItem clientesInsertar = new JMenuItem("insertar cliente");
		JMenuItem clientesListar = new JMenuItem("listar cliente");
		JMenuItem productosInsertar = new JMenuItem("insertar producto");
		JMenuItem productosListar = new JMenuItem("listar producto");
		
		menuclientes.add(clientesInsertar);
		menuclientes.add(clientesListar);
		menuProductos.add(productosInsertar);
		menuProductos.add(productosListar);
		barraDeMenu.add(menuclientes);
		barraDeMenu.add(menuProductos);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		

		// voy a decir a las opciones quien las va a atender cuando se haga un
		// click
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		productosInsertar.addActionListener(this);
		productosListar.addActionListener(this);

		// configuracion de ventana principal
		this.setSize(800, 600);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// cuando arranque se muestra el panel registro cliente

		this.setContentPane(panelRegistroCliente);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("atiendo a" + e.getActionCommand());
		if (e.getActionCommand().equals("insertar cliente")) {
			setContentPane(panelRegistroCliente);
		} else if (e.getActionCommand().equals("listar cliente")) {
			setContentPane(panelListadoCliente);
			panelListadoCliente.refrescarClientes();
		}else if (e.getActionCommand().equals("insertar producto")) {
			setContentPane(panelRegistroProducto);
		}else if (e.getActionCommand().equals("listar producto")) {
			setContentPane(panelListadoProducto);
			panelListadoProducto.refrescarProductos();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

}
