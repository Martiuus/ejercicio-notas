package pe.edu.idat.ejercicio_notas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class promedioController {

    @GetMapping("/promedio")
    public String formularioNotas(){
        return "promedio";
    }
}
