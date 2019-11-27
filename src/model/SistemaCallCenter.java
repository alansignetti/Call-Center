package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SistemaCallCenter {
	List<Llamada> lstLlamadas;
	List<Persona> lstPersonas;
	public SistemaCallCenter() {
		super();
		lstLlamadas = new ArrayList<Llamada>();
		lstPersonas = new ArrayList<Persona>();
	}
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}
	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	
	
	public Persona traerPersona(long dni) {
		Persona devolver=null;
		int stop=0;
		Persona p = null;
		Iterator<Persona>it=lstPersonas.iterator();
		
		while (it.hasNext()) {
			 p =  it.next();
			 if (p.getDni()==dni) {
				stop=1;
			}			
		}
		if (stop==1) {
			devolver=p;
		}
		
		return devolver;
	}
	
	public boolean agregarCliente(String nombre, String apellido, long dni, boolean activo) {
		boolean devolver = false;
		Persona p=this.traerPersona(dni);
		int id=1;
		if (id!=0) {
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		if (p!=null) {
			devolver=lstPersonas.add(new Cliente(id, nombre, apellido, dni, activo));
		}
		return devolver;
	}
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) {
		boolean devolver = false;
		Persona p=this.traerPersona(dni);
		int id=1;
		if (id!=0) {
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		if (p!=null) {
			devolver=lstPersonas.add(new Empleado(id, nombre, apellido, dni, sueldoBase));
		}
		return devolver;
	}
	
	
	
	

}
