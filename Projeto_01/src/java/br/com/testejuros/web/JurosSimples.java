/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testejuros.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gil
 */
@WebServlet(name = "JurosSimples", urlPatterns = {"/juros-simples"})
public class JurosSimples extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name='viewport' content='width=device-width', initial-scale=1.0>");
            out.println("<style type='text/css'>");
            out.println("@import url('folhaestilo.css');");
            out.println("</style>");
            out.println("<title>Juros Simples</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='titulo-botao'>");
            out.println("<div class='titulo'>");
            out.println("<h1>Cálculo do Juros Simples</h1>");
            out.println("</div>");
            out.println("<div class='botao'>");
            out.println("<a href='home'><div class='voltar'><h3>Voltar<h3></div></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='conteudo'>");
            out.println("<div class='bloco1'>");
            out.println("<form action='juros-simples'>");
            out.println("<p>Valor do empréstimo: </p>");
            out.println("<input type='text' name='valor'>");
            out.println("<p>Taxa de juros por mês (%): </p>");
            out.println("<input type='text' name='taxa'>");
            out.println("<p>Tempo (meses): </p>");
            out.println("<input type='text' name='tempo'><br>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
            out.println("</div>");

            double valor = Double.parseDouble(request.getParameter("valor"));
            double taxa = Double.parseDouble(request.getParameter("taxa"));
            int tempo = Integer.parseInt(request.getParameter("tempo"));
            taxa = taxa / 100;
            double montante;
            montante = valor * (1 + (taxa * tempo));
            out.println("<div class='bloco2'>");
            out.println("<div class='resultado'>");
            out.println("<h2>O montante é: R$" + montante + "</h2>");
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
