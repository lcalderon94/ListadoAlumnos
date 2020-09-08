package ninjutsu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ninjutsu.dominio.Alumno;
import ninjutsu.dominio.Contacto;
import ninjutsu.dominio.Domicilio;
import ninjutsu.servicio.ServicioAlumno;


@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String idAlumnoS = req.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);
        
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.encontrarAlumno(alumno);
        
        //req.setAttribute("alumno", alumno);
        
        HttpSession sesion = req.getSession();
        sesion.setAttribute("alumno", alumno);
        
        req.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(req, res);
        
        
    }
    
    
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
         
         ServicioAlumno servicioAlumno = new ServicioAlumno();
         
         String modificar = req.getParameter("Modificar");
         
         if(modificar != null){
         
         String nombre = req.getParameter("nombre");
         String apellido = req.getParameter("apellido");
         String calle = req.getParameter("calle");
         String noCalle = req.getParameter("noCalle");
         String pais = req.getParameter("pais");
         String email = req.getParameter("email");
         String telefono = req.getParameter("telefono");
         
        
        HttpSession sesion = req.getSession();
        Alumno alumno = (Alumno) sesion.getAttribute("alumno");
       
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        
        
        
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        
        servicioAlumno.guardarAlumno(alumno);
        
        sesion.removeAttribute("alumno");
         }else{
             //Caso de eliminar
             
             String idAlumnoS = req.getParameter("idAlumno");
             Integer idAlumno = Integer.parseInt(idAlumnoS);
             Alumno alumno = new Alumno(idAlumno);
             
             servicioAlumno .eliminarAlumno(alumno);
             
         }
        
        req.getRequestDispatcher("/index.jsp").forward(req, res);
        
     }       
}
