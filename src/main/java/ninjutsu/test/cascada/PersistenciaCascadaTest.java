package ninjutsu.test.cascada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ninjutsu.dominio.Alumno;
import ninjutsu.dominio.Contacto;
import ninjutsu.dominio.Domicilio;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Nogales");
        domicilio.setNoCalle("10");
        domicilio.setPais("Inglaterra");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("luisito@hotmail.com");
        contacto.setTelefono("456951123");
        
        Alumno alumno = new Alumno();
        alumno.setApellido("lololo");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("Alumno = "+alumno);
    }
}
