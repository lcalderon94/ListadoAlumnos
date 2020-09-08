/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninjutsu.test;

import java.util.List;
import ninjutsu.dao.AlumnoDAO;
import ninjutsu.dao.DomicilioDAO;

/**
 *
 * @author luis
 */
public class TestDAOs {
    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDao.listar());
        System.out.println("\n");
        System.out.println("Domicilios: ");
        DomicilioDAO domicilioDao = new DomicilioDAO();
        imprimir(domicilioDao.listar());
    }
    
    public static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("Valor = "+o);
        }
    }
}
