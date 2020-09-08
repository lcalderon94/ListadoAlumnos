package ninjutsu.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ninjutsu.dominio.Alumno;
import ninjutsu.servicio.ServicioAlumno;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();
        
        req.setAttribute("alumnos", alumnos);
        
        try {
            req.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(req, res);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
