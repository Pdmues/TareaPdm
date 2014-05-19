package sv.ues.fia.docente;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DocenteMenu extends ListActivity {
	String[] menu={"Insertar Docente","Modificar Docente","Consultar Docente","Eliminar Docente"};
	String[]
	activities={"DocenteInsertar","DocenteModificar","DocenteConsultar","DocenteEliminar"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, menu));
	}
	@Override
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		super.onListItemClick(l, v, position, id);
		String nombreValue=activities[position];
		try
		{
			Class<?>
			clase=Class.forName("sv.ues.fia.docente."+nombreValue);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
