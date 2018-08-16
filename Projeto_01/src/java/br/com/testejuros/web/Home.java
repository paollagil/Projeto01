/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testejuros.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gil
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name='viewport' content='width=device-width', initial-scale=1.0>");
            out.println("<style type='text/css'>");
            out.println("@import url('folhaestilo.css');");
            out.println("</style>");
            out.println("<title>Home</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='titulo' style='width: 100%;'>");
            out.println("<h1>Projeto 01</h1>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='conteudo'>");
            out.println("<div class='bloco1'>");
            out.println("<p class='descricao'>Aplicação web para o cálculo de juros simples e juros composto.</p>");
            out.println("<div class='componentes'>");
            out.println("<h4>Componentes</h4>");
            out.println("</div>");
            out.println("<div class='lista'>");
            out.println("<ul>");
            out.println("<li>Paolla Gil Claudino</li>");
            out.println("<li>Vinícius</li>");
            out.println("<li>Thyago</li>");
            out.println("<li>Daniel</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='bloco2'>");
            out.println("<div class='menuzinho'>");
            out.println("<a href='juros-simples'><div class='link'>Juros Simples</div></a>");
            out.println("<a href='juros-composto'><div class='link'>Juros Composto</div></a>");
            out.println("</div>");
            out.println("</div>");
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
