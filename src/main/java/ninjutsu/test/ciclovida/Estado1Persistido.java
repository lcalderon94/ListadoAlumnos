package ninjutsu.test.ciclovida;

import javax.persistence.*;
import ninjutsu.dominio.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1.Crear estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("Clara@gmail.com");
        contacto.setTelefono("654123258");
        
        //2. persistimos el objeto
        
        em.getTransaction().begin();
        
        em.persist(contacto);
        em.flush();
        
        em.getTransaction().commit();
        
        //3. detached (separado)
        
        System.out.println("contacto ="+contacto);
        
    }
}
