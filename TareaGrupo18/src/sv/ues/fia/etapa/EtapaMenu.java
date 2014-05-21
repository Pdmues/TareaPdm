package sv.ues.fia.etapa;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EtapaMenu extends ListActivity {

	String[] menu={"Insertar Etapa","Modificar Etapa","Consultar Etapa","Eliminar Etapa"};
	String[] activitys={"EtapaInsertar","EtapaModificar","EtapaConsultar","EtapaEliminar"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
	}

	@Override
protected void onListItemClick(ListView l,View v,int position,long id){
		super.onListItemClick(l, v, position, id);
		String nombreValue=activitys[position];
		try{
			Class<?> clase=Class.forName("sv.ues.fia.etapa."+nombreValue);
			Intent i=new Intent(this,clase);
			this.startActivity(i);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}
}
