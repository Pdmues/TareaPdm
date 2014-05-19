package sv.ues.fia.tipoespecialidad;

public class TipoEspecialidad 
{
	int IDespecialidad;
	String NombreEspecialidad;
	public TipoEspecialidad(int iDespecialidad, String nombreEspecialidad) {
		IDespecialidad = iDespecialidad;
		NombreEspecialidad = nombreEspecialidad;
	}
	public TipoEspecialidad() {
		// TODO Auto-generated constructor stub
	}
	public int getIDespecialidad() {
		return IDespecialidad;
	}
	public void setIDespecialidad(int iDespecialidad) {
		IDespecialidad = iDespecialidad;
	}
	public String getNombreEspecialidad() {
		return NombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		NombreEspecialidad = nombreEspecialidad;
	}

}
