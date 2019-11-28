package model;

import java.time.LocalDate;
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

		while (it.hasNext()&&stop==0) {
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
		if (!lstPersonas.isEmpty()) {
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		if (p==null) {
			devolver=lstPersonas.add(new Cliente(id, nombre, apellido, dni, activo));
		}
		return devolver;
	}
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) {
		boolean devolver = false;
		Persona p=this.traerPersona(dni);
		int id=1;
		if (lstPersonas.size()!=0) {
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
				

		if (p==null) {
			devolver=lstPersonas.add(new Empleado(id, nombre, apellido, dni, sueldoBase));
		}
		return devolver;
	}

	public List<Persona> traerPersonas(){

		return lstPersonas;
	}

	public List<Cliente> traerClientes(){
		List<Cliente> listaCli = new ArrayList<Cliente>();
		Iterator<Persona>it=lstPersonas.iterator();
		Persona p=null;

		while (it.hasNext()) {
			p =  it.next();
			if (p instanceof Cliente) {
				listaCli.add((Cliente) p);
			}			
		}
		return listaCli;
	}
	public List<Empleado> traerEmpleados(){
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		Iterator<Persona>it=lstPersonas.iterator();
		Persona p=null;

		while (it.hasNext()) {
			p =  it.next();
			if (p instanceof Empleado) {
				listaEmpleado.add((Empleado) p);
			}			
		}
		return listaEmpleado;
	}

	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta){
		
		List<Llamada> lista= new ArrayList<Llamada>();
		Iterator<Llamada> it=lstLlamadas.iterator();
		Llamada l=null;
		
		while (it.hasNext()) {
			 l =  it.next();
			if (l.getFecha().isAfter(desde)||l.getFecha().isEqual(desde)&&l.getFecha().isBefore(hasta)||l.getFecha().isEqual(hasta)) {
				lista.add(l);
			}
		}		
		return lista;		
	}


		public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion){
			
			List<Llamada> lista= new ArrayList<Llamada>();
			
			Iterator<Llamada> it=this.traerLlamada(desde, hasta).iterator();
			Llamada l=null;
			while (it.hasNext()) {
				 l =  it.next();
				if (l.getNivelDeSatisfaccion()==nivelDeSatisfaccion) {
					lista.add(l);
				}
			}		
			return lista;			
		}
		
		
		public boolean agregarLlamada( LocalDate fecha, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) {

			int id=1;
			if (lstLlamadas.size()!=0) {
				id=lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
			}
			
			return lstLlamadas.add(new Llamada(id, cliente, empleado, fecha, nivelDeSatisfaccion));
		}
		

		public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde,LocalDate hasta,int nivelDeSatisfaccion) {
			List<Llamada>lista=this.traerLlamada(desde, hasta, nivelDeSatisfaccion);
			double resultado=0;
			int cantLlamadas=lista.size();
			int totalLlamadas=lstLlamadas.size();
			resultado=cantLlamadas*100/totalLlamadas;
			return resultado;
			
		}
		
		
		
		
	


}
