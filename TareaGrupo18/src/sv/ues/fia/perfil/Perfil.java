package sv.ues.fia.perfil;

public class Perfil 
{
	private int Nperfil=0;
	private String Estado="";
	private String Observaciones="";
	private int ngrupo;
	private int idinstitucion;
	
	public Perfil() {}

	

	public Perfil(int nperfil, String estado, String observaciones, int ngrupo,	int idinstitucion) {
		super();
		Nperfil = nperfil;
		Estado = estado;
		Observaciones = observaciones;
		this.ngrupo = ngrupo;
		this.idinstitucion = idinstitucion;
	}



	public int getNgrupo() {
		return ngrupo;
	}



	public void setNgrupo(int ngrupo) {
		this.ngrupo = ngrupo;
	}



	public int getIdinstitucion() {
		return idinstitucion;
	}



	public void setIdinstitucion(int idinstitucion) {
		this.idinstitucion = idinstitucion;
	}



	public void setNperfil(int nperfil) {
		Nperfil = nperfil;
	}


	public int getNperfil() {
		return Nperfil;
	}

	public void setNperfil1(int nperfil) {
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

	
}
