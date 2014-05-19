package sv.ues.fia.trabajograduacion;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TrabajoGraduacionMenu extends ListActivity {
	String[] menu={"Insertar Trabajo de Graduacion","Modificar Trabajo de Graduacion","Consultar Trabajo de Graduacion","Eliminar Trabajo de Graduacion"};
	String[]
	activities={"TrabajoGraduacionInsertar","TrabajoGraduacionModificar","TrabajoGraduacionConsultar","TrabajoGraduacionEliminar"};
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
			clase=Class.forName("sv.ues.fia.trabajograduacion."+nombreValue);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	

}
