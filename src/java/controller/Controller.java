/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.ContatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.internal.perf.PerfCounter;
import model.Contato;

/**
 *
 * @author Vinicius
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/adicionaContatos", "/adicionaContatosbd", "/listaContatos", "/home", "/editaContatos", "/editaContatosbd", "/excluiContatos"})
public class Controller extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        String action = request.getServletPath();

        if (action.equals("/adicionaContatos")) {
            response.sendRedirect("ad-contatos.jsp");
        }
        if (action.equals("/listaContatos")) {

            List<Contato> lista = ContatoDAO.lerTudo();
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("li-contatos.jsp");
            dispatcher.forward(request, response);

            //response.sendRedirect("li-contatos.jsp");
        }

        if (action.equals("/home")) {
            //response.sendRedirect("li-contatos.jsp");
            response.sendRedirect("index.html");
        }

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
        //processRequest(request, response);
        String action = request.getServletPath();
        ContatoDAO dao = new ContatoDAO();
        Contato contato = new Contato();

        if (action.equals("/adicionaContatosbd")) {

            contato.setNome(request.getParameter("nome"));
            contato.setSenha(request.getParameter("senha"));
            contato.setEmail(request.getParameter("email"));
            contato.setSexo(request.getParameter("sexo"));
            contato.setPais(request.getParameter("pais"));
            if (dao.salvar(contato) == 1) {
                response.sendRedirect("cadcontsucesso.jsp");
            } else {
                response.sendRedirect("cadconterro.jsp");
            }
        }

        if (action.equals("/editaContatos")) {
            log(request.getParameter("id"));
            contato = dao.getContatoPorId(Integer.parseInt(request.getParameter("id")));
            //log("aaaaa: "+ contato.getId());
            if (contato.getId() > 0) {
                request.setAttribute("contato", contato);
                //request.setAttribute("id", contato.getId());
                //request.setAttribute("nome", contato.getNome());
                //request.setAttribute("senha", contato.getSenha());
                //request.setAttribute("email", contato.getEmail());
                //request.setAttribute("sexo", contato.getSexo());
                //request.setAttribute("pais", contato.getPais());

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("ed-contatos.jsp");
                dispatcher.forward(request, response);

            } else {
                response.sendRedirect("li-contatos.jsp");
            }
        }

        if (action.equals("/editaContatosbd")) {

            contato.setId(Integer.parseInt(request.getParameter("id")));
            //System.out.println("AAA");
            contato.setNome(request.getParameter("nome"));
            contato.setSenha(request.getParameter("senha"));
            contato.setEmail(request.getParameter("email"));
            contato.setSexo(request.getParameter("sexo"));
            contato.setPais(request.getParameter("pais"));
            if (dao.atualizar(contato) == 1) {
                response.sendRedirect("cadcontsucesso.jsp");
            } else {
                response.sendRedirect("cadconterro.jsp");
            }
        }
        if (action.equals("/excluiContatos")) {
            contato = dao.getContatoPorId(Integer.parseInt(request.getParameter("id")));
            if (dao.deletar(contato) == 1) {
                response.sendRedirect("cadcontsucesso.jsp");
            } else {
                response.sendRedirect("cadconterro.jsp");
            }

        }
    }

}
