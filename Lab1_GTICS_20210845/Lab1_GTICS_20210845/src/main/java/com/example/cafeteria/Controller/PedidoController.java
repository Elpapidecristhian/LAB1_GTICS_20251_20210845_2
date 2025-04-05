package com.example.cafeteria.Controller;

import com.example.cafeteria.model.Confi_orden;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/PedidoController")
public class PedidoController {

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("orderConfig", new Confi_orden());
        return "pedido_form"; //Para la vista del html
    }
    @PostMapping
    public String procesarPedido(@ModelAttribute Confi_orden orderConfig, Model model) {
        double total = calcularTotal(orderConfig);
        model.addAttribute("order", orderConfig);
        model.addAttribute("total", total);
        return "pedido_resumen"; // para la vista de los pedido_resumen.html"
    }

    @PostMapping("/calificacion")
    public String procesarCalificacion(@ModelAttribute Confi_orden ratingForm, Model model) {
        model.addAttribute("mensaje", "Gracias por tu calificación de " + ratingForm.getEstrellas() + " estrellas, esperamos que puedas volver pronto :3");
        return "agradecimiento_uwu"; //para el html agradecimiento_uwu
    }

    // Método para calcular el total de la orden (por ejemplo, multiplicando la cantidad por un precio fijo)
    private double calcularTotal(Confi_orden orderConfig) {
        return 10.0 * orderConfig.getCantidad();
    }
}
