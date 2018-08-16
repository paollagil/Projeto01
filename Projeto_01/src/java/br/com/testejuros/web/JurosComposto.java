/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testejuros.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gil
 */
@WebServlet(name = "JurosCompostos", urlPatterns = {"/juros-composto"})
public class JurosComposto extends HttpServlet {

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
            out.println("<title>Juros Composto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='titulo-botao'>");
            out.println("<div class='titulo'>");
            out.println("<h1>Cálculo do Juros Composto</h1>");
            out.println("</div>");
            out.println("<div class='botao'>");
            out.println("<a href='home'><div class='voltar'><h3>Voltar<h3></div></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='conteudo'>");
            out.println("<div class='bloco1'>");
            out.println("<form action='juros-composto'>");
            out.println("<p>Valor do empréstimo: </p>");
            out.println("<input type='text' name='valor'>");
            out.println("<p>Taxa de juros por mês (%): </p>");
            out.println("<input type='text' name='taxa'>");
            out.println("<p>Tempo (meses): </p>");
            out.println("<input type='text' name='tempo'><br>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
            out.println("</div>");
            out.println("<div class='bloco2'>");
            double valor = Double.parseDouble(request.getParameter("valor"));
            double taxa = Double.parseDouble(request.getParameter("taxa"));
            int tempo = Integer.parseInt(request.getParameter("tempo"));
            taxa = taxa / 100;
            double montante;
            double jurosacumulado;
            double juros;
            double soma;
            double elevado;
            double aux = 0;
            DecimalFormat formatacao = new DecimalFormat("###,##0.00");
            for (int i = 0; i <= tempo; i++) {
                if (i == 0) {
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Mês</th>");
                    out.println("<th>Juros do mês</th>");
                    out.println("<th>Juros acumulado</th>");
                    out.println("<th>Montante acumulado</th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<th>0</th>");
                    out.println("<th>-</th>");
                    out.println("<th>-</th>");
                    out.println("<th>" + formatacao.format(valor) + "</th>");
                    out.println("</tr>");
                } else {
                    soma = 1 + taxa;
                    elevado = Math.pow(soma, i);
                    jurosacumulado = valor * (elevado - 1);
                    montante = valor * elevado;
                    if (i == 1) {
                        juros = jurosacumulado;
                        aux = jurosacumulado;
                    } else {
                        juros = jurosacumulado - aux;
                        aux = jurosacumulado;
                    }
                    out.println("<tr>");
                    out.println("<th>" + i + "</th>");
                    out.println("<th>" + formatacao.format(juros) + "</th>");
                    out.println("<th>" + formatacao.format(jurosacumulado) + "</th>");
                    out.println("<th>" + formatacao.format(montante) + "</th>");
                    out.println("</tr>");
                    if (i == tempo) {
                        out.println("</table>");
                        out.println("</div>");
                    }
                }

            }
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
