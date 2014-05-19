package sv.ues.fia.perfil;

public class Perfil 
{
	private String Nperfil="";
	private String Estado="";
	private String Observaciones="";
	
	public Perfil() {}

	public Perfil(String nperfil, String estado, String observaciones) {
		Nperfil = nperfil;
		Estado = estado;
		Observaciones = observaciones;
	}

	public String getNperfil() {
		return Nperfil;
	}

	public void setNperfil(String nperfil) {
		Nperfil = nperfil;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public void setNperfil(int parseInt) {
		// TODO Auto-generated method stub
		
	}
	
}
