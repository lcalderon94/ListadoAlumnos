package ninjutsu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ninjutsu.dominio.Alumno;
import ninjutsu.dominio.Contacto;
import ninjutsu.dominio.Domicilio;
import ninjutsu.servicio.ServicioAlumno;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
         String nombre = req.getParameter("nombre");
         String apellido = req.getParameter("apellido");
         String calle = req.getParameter("calle");
         String noCalle = req.getParameter("noCalle");
         String pais = req.getParameter("pais");
         String email = req.getParameter("email");
         String telefono = req.getParameter("telefono");
         
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);
        
        req.getRequestDispatcher("/index.jsp").forward(req, res);
        
     }       
}
