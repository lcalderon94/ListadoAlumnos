package ninjutsu.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ninjutsu.dominio.Contacto;

public class Estado2RecueprarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Recuperar un objeto de la base de datos
        
        Contacto contacto = null;
        
        //Recuperamos el objeto
        
        contacto = em.find(Contacto.class, 3);
        
        //detached
        
        
        System.out.println("Contacto = "+contacto);
        
    }
}
