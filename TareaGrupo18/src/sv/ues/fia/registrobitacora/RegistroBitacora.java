package sv.ues.fia.registrobitacora;

public class RegistroBitacora 
{
private String carnet="";
private int idbitacora=0;
private String tipoReunion;
private String fecha;
public String getTipoReunion() {
	return tipoReunion;
}
public void setTipoReunion(String tipoReunion) {
	this.tipoReunion = tipoReunion;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getCarnet() {
	return carnet;
}
public void setCarnet(String carnet) {
	this.carnet = carnet;
}
public int getIdbitacora() {
	return idbitacora;
}
public void setIdbitacora(int idbitacora) {
	this.idbitacora = idbitacora;
}

}