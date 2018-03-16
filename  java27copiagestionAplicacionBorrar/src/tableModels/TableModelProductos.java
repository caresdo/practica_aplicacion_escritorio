package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Producto;

public class TableModelProductos extends AbstractTableModel {
	private String[] columnas = { "nombre", "cantidad", "precio",
			"oferta", "fechaCad", "proveedor", "comentario" };
	private String[][] datos = null;

	public TableModelProductos(Producto[] productos) {
		datos = new String[productos.length][columnas.length];
		for (int i = 0; i < productos.length; i++) {
			Producto c = productos[i];
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getCantidad();
			datos[i][2] = c.getPrecio();
			//datos[i][3] = c.isOferta();
			datos[i][4] = c.getFechaCad();
			datos[i][5] = c.getProveedor();
			datos[i][6] = c.getComentario();
		}
	}
	
	public int getRowCount() {
		return datos.length;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}
	//nombre
  public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }


	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}
