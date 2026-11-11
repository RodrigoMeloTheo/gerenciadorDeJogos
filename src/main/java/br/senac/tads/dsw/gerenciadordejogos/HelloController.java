package br.senac.tads.dsw.gerenciadordejogos;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class HelloController {

    @GetMapping("/hello")
    public Mensagem hello() {
        return new Mensagem("Rodrigo Melo Theodoro", "testezao brabo");
    }
    

}
