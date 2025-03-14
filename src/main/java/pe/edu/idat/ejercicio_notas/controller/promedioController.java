package pe.edu.idat.ejercicio_notas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ejercicio_notas.model.promedioModel;

@Controller
public class promedioController {

    @GetMapping("/promedio")
    public String formularioNotas(Model model){
        model.addAttribute("promediomodel", new promedioModel());
        model.addAttribute("visualizaralerta", false);
        return "promedio";
    }

    @PostMapping("/calcularpromedio")
    public String calcularPromedio(@ModelAttribute("promediomodel") promedioModel pm , Model model){
        Double nota1m = pm.getNota1();
        Double nota2m = pm.getNota2();
        Double nota3m = pm.getNota3();
        Double nota4m = pm.getNotaFinal();
        String condicion = "";
        String ColorResultado = "alert-primary";

        Double resultado = (nota1m * 0.04) + (nota2m * 0.12) + (nota3m * 0.24) + (nota4m * 0.6);
        if (resultado < 13){
            condicion = "Desprobado";
            ColorResultado = "alert-danger";
        }else {
            condicion = "Aprobado";
        }
        model.addAttribute("resultado", condicion + ", nota: " + resultado);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("color", ColorResultado);
        return "promedio";

    }

}
