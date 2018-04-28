/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.servlet;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius.Vianna
 */
@WebServlet("/carros/")
public class CarrosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarroService carroService = new CarroService();
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<Carro> carros = carroService.getCarros();
         String carrosString = carros.toString();
         response.getWriter().write(carrosString);
    }//fecha doGet
    
}//fecha classe
