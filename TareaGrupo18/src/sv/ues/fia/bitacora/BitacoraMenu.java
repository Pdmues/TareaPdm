package sv.ues.fia.bitacora;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BitacoraMenu extends ListActivity {

	String[] menu={"Insertar Bitacora","Modificar Bitacora","Consultar Bitacora","Eliminar Bitacora"};
	String[]
	activities={"BitacoraInsertar","BitacoraModificar","BitacoraConsultar","BitacoraEliminar"};
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
	clase=Class.forName("sv.ues.fia.bitacora."+nombreValue);
	Intent inte = new Intent(this,clase);
	this.startActivity(inte);
}
catch(ClassNotFoundException e)
{
	e.printStackTrace();
}
}
}
