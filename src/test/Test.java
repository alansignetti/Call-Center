package test;

import java.time.LocalDate;

import model.Cliente;
import model.Empleado;
import model.SistemaCallCenter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaCallCenter sist= new SistemaCallCenter();
		
		sist.agregarCliente("Luis", "Perez", 111, true);
		sist.agregarCliente("Lucas", "Pereyra", 222, false);
		
		sist.agregarEmpleado("Pedro", "Lopez",333, 100);
		sist.agregarEmpleado("Pablo", "Gomes",444, 90);
		
		
		
//		System.out.println(sist.traerPersonas());
//		System.out.println(sist.traerClientes());
//		System.out.println(sist.traerEmpleados());
		System.out.println(sist.traerPersona(111));
		System.out.println(sist.traerPersona(333));
		
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(444),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sist.traerPersona(222),(Empleado)sist.traerPersona(333),5);
		sist.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),4);
		sist.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),4);
		sist.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),3);
		sist.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),3);
		sist.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),2);
		sist.agregarLlamada(LocalDate.of(2018, 2, 21),(Cliente)sist.traerPersona(111),(Empleado)sist.traerPersona(333),4);
		
//		System.out.println(sist.traerLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21)));
		System.out.println(sist.getLstLlamadas());
		System.out.println(sist.traerEmpleados());
		System.out.println(sist.traerLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21)));	
		System.out.println(sist.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),5));
	
		
	}

}
