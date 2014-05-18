package sv.ues.fia.facultad;

public class Facultad 
{
 private String IDfacultad="";
 private String NombFacultad="";

 public Facultad() {}

public Facultad(String iDfacultad, String nombFacultad) {
	super();
	IDfacultad = iDfacultad;
	NombFacultad = nombFacultad;
}

public String getIDfacultad() {
	return IDfacultad;
}

public void setIDfacultad(String iDfacultad) {
	IDfacultad = iDfacultad;
}

public String getNombFacultad() {
	return NombFacultad;
}

public void setNombFacultad(String nombFacultad) {
	NombFacultad = nombFacultad;
}
 

}
