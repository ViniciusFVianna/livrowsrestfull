/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Vinicius.Vianna
 */
public class CarroTest extends TestCase {

    private CarroService carroService = new CarroService();

    public void testListaCarros() {
        List<Carro> carros = carroService.getCarros();
        assertNotNull(carros);
        //Valida se encontrou algo
        assertTrue(carros.size() > 0);
        //Valida se encontrou o Truker
        Carro truker = carroService.findbyName("Trucker 1948").get(0);
        assertEquals("Trucker 1948", truker.getNome());
        //Valida se encontrou ferrari
        Carro ferrari = carroService.findbyName("Ferrari FF").get(0);
        assertEquals("Ferrari FF", ferrari.getNome());
        //Valida se encrontrou o Bugatti
        Carro bugatti = carroService.findbyName("Bugatti Veyron").get(0);
        assertEquals("Bugatti Veryon", bugatti.getNome());
    }//fecha testListaCArros

}//fecha classe

