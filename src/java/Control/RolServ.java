/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.DAO;
import Modelo.Implementar.Admin;
import Modelo.Tablas.RolTab;
import Servicios.Mensajes.msj;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author almoreno
 */
public class RolServ extends HttpServlet {

    @Resource(name = "Pool")
    private DataSource pool;
    MsjServ msj = new MsjServ();
    String Ruta;
    RolTab r;
    Long Id;
    String Nombre;
    String Detalles;
    Boolean Status;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession Ss = request.getSession(true);
//        if (Ss.getAttribute("Log") != null){

        if (Ss.getAttribute("msj") != null) {
            msj.m = (msj) Ss.getAttribute("msj");
        }

        if (Ss.getAttribute("jsp") != null) {
            Ruta = (String) Ss.getAttribute("jsp");
        } else {
            Ruta = "rol.jsp";
        }

        String accion = request.getParameter("Accion");
        if (accion == null) {
            accion = "Listar";
        }

        try {
            Admin Asql = new Admin(pool);

            switch (accion) {
                case "Listar":
                    List<RolTab> RolList = Asql.getRol().all();
                    Ss.setAttribute("lsRol", RolList);
                    break;
                case "Registrar":
                    Nombre = request.getParameter("nombre");
                    Detalles = request.getParameter("detalles");
                    Status = request.getParameter("estado") != null;
                    r = new RolTab(Nombre, Detalles, Status);
                    msj.m = Asql.getRol().Insert(r);
                    break;
                case "Actualizar":
                    Id = Long.valueOf(request.getParameter("id"));
                    Nombre = request.getParameter("nombre");
                    Detalles = request.getParameter("detalles");
                    Status = request.getParameter("estado") != null;
                    r = new RolTab(Id, Nombre, Detalles, Status);
                    msj.m = Asql.getRol().Update(r);
                    break;
                case "Consultar":
                    Id = Long.valueOf(request.getParameter("id"));
                    r = Asql.getRol().one(Id);
                    Ss.setAttribute("rol", r);
                    break;
                case "Eliminar":
                    Id = Long.valueOf(request.getParameter("id"));
                    msj.m = Asql.getRol().Delete(Id);
                    break;
            }
        } catch (SQLException ex) {
            msj.m = msj.NotSql(ex);
        }

//        }else{
//            Ruta = "index.jsp";
//        }
        if (msj.m != null) {
            Ss.setAttribute("msj", msj.m);
        }
        request.getRequestDispatcher(Ruta).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
