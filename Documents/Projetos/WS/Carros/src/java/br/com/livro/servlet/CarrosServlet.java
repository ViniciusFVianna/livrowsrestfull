/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livro.servlet;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import br.com.livro.domain.Response;
import br.com.livro.util.RegexUtil;
import br.com.livro.util.ServletUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@WebServlet("/carros/*")
public class CarrosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarroService carroService = new CarroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        Long id = RegexUtil.matchId(requestUri);
        if (id != null) {
            //Informou o id
            Carro carro = carroService.getCarro(id);
            if (carro != null) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(carro);
                ServletUtil.writeJSON(response, json);
            } else {
                response.sendError(404, "Carro não encontrado");
            }//fecha else
        } else {
            //Lista de carros
            List<Carro> carros = carroService.getCarros();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(carros);
            ServletUtil.writeJSON(response, json);
        }//fecha else
    }//fecha doGet
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        //Cria o carro
        Carro carro = getCarroFromRequest(request);
        //Salva o carro
        carroService.save(carro);
        //Escreve o JSON do novo carro salvo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(carro);
        ServletUtil.writeJSON(resp, json);
    }//fecha doPost

    //Lê os parâmetros da request e cria o objeto carro
    private Carro getCarroFromRequest(HttpServletRequest request) {
        Carro c = new Carro();
        String id = request.getParameter("id");
        if(id != null){
            //Se informou o id , busca o objeto do banco de dados
            c = carroService.getCarro(Long.parseLong(id));
        }//fecha if
        c.setNome(request.getParameter("nome"));
        c.setDesc(request.getParameter("descricao"));
        c.setUrlFoto(request.getParameter("url_foto"));
        c.setUrlVideo(request.getParameter("url_video"));
        c.setLatitude(request.getParameter("latitude"));
        c.setLongetude(request.getParameter("longitude"));
        c.setTipo(request.getParameter("tipo"));
        return c;
    }//fecha metodo

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        Long id = RegexUtil.matchId(requestUri);
        if (id != null) {
            //Informou o id
            carroService.delete(id);
            response.sendError(200, "Carro excluído com sucesso");
            Response r = Response.Ok("Carro excluído com sucesso");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(r);
            ServletUtil.writeJSON(response, json);
            
            } else {
                response.sendError(404, "URL inválida");
            }//fecha else
    }//fecha doDelete    
}//fecha classe
