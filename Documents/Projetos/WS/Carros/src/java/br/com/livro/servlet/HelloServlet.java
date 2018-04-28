/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius.Vianna
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        response.getWriter().print("Olá mundo "+ nome +" "+sobrenome);
    }//fecha doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        response.getWriter().print("Olá mundo "+ nome +" "+sobrenome);
    }//fecha doPost

     @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("Olá PUT ");
    }//fecha doPost
    
     @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("Olá mundo DELETE");
    }//fecha doPost
}//fecha classe
