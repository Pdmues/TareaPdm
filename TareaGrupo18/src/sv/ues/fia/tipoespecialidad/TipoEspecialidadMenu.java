package sv.ues.fia.tipoespecialidad;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TipoEspecialidadMenu extends ListActivity {

	String[] menu={"Insertar Tipo Especialidad","Modificar Tipo Especialidad","Consultar Tipo Especialidad","Eliminar Tipo Especialidad"};
			String[]
			activities={"TipoEspecialidadInsertar","TipoEspecialidadModificar","TipoEspecialidadConsultar","TipoEspecialidadEliminar"};
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
			clase=Class.forName("sv.ues.fia.tipoespecialidad."+nombreValue);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
