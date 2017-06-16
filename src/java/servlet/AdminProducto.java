/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.BeanProductosLocal;
import clases.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminProducto extends HttpServlet {

    @EJB(mappedName = "bean")
    private BeanProductosLocal beanProductos;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameterMap().containsKey("accion")) {
            if (request.getParameter("accion").equals("agregar")) {
                agregarProducto(request);
            }
            if (request.getParameter("accion").equals("eliminar")) {
                eliminarProducto(request);
            }
        }

        //para conocer desde que pagina se origino la peticion
        String jspPage = "/" + request.getParameter("jspname") + ".jsp";
        ArrayList<Producto> listaProductos = beanProductos.getListaProductos();

        request.setAttribute("listaProductos", listaProductos);
        request.getRequestDispatcher(jspPage).forward(request, response);

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

    private void agregarProducto(HttpServletRequest request) {
        String idProducto = request.getParameter("id");
        String nombreProducto = request.getParameter("nombre");
        String descripcionProducto = request.getParameter("descripcion");
        String fechaElaboracion = request.getParameter("elaboracion");
        int valorProducto;
        try {
            valorProducto = Integer.parseInt(request.getParameter("precio"));
        } catch (NumberFormatException e) {
            //si el valor es distinto de un numero
            valorProducto = 0;
        }

        Producto producto = new Producto(idProducto, nombreProducto, descripcionProducto, fechaElaboracion, valorProducto);

        beanProductos.agregarProducto(producto);
    }

    private void eliminarProducto(HttpServletRequest request) {
        String idProducto = request.getParameter("id");
        beanProductos.eliminarProducto(idProducto);
    }

}
