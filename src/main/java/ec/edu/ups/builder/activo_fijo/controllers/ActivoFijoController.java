package ec.edu.ups.builder.activo_fijo.controllers;

import ec.edu.ups.builder.activo_fijo.models.ActivoFijo;
import ec.edu.ups.builder.activo_fijo.dto.ActivoFijoRequest;
import ec.edu.ups.builder.activo_fijo.models.ActivoBuilder;
import ec.edu.ups.builder.activo_fijo.service.ActivoFijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;;

@Controller
@RequestMapping("/activos")
public class ActivoFijoController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private ActivoFijoService activoFijoService;

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("activoFijo", new ActivoFijo(null, null, 0));
        return "crear_activo";
    }

    @PostMapping("/crear")
    public String crearActivo(@ModelAttribute("activoFijo") ActivoFijoRequest activoRequest, Model model) {
        ActivoFijo activoFijo = new ActivoBuilder(activoRequest.getCodigo(), activoRequest.getNombres(),
                activoRequest.getPrecio())
                .conMarca(activoRequest.getMarca())
                .conModelo(activoRequest.getModelo())
                .conAño(activoRequest.getAño())
                .conColor(activoRequest.getColor())
                .conUbicacion(activoRequest.getUbicacion())
                .build();

        activoFijoService.crearActivo(activoFijo);
        return "redirect:/activos/listar";
    }

    @GetMapping("/listar")
    public String listarActivos(Model model) {
        List<ActivoFijo> activos = activoFijoService.listarActivos();
        model.addAttribute("activos", activos);
        return "listar_activos";
    }

    // Actualización: Cargar formulario con datos del activo existente
    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEdicion(@PathVariable String codigo, Model model) {
        Optional<ActivoFijo> activoFijoOpt = activoFijoService.buscarPorCodigo(codigo);
        if (activoFijoOpt.isPresent()) {
            model.addAttribute("activoFijo", activoFijoOpt.get());
            return "editar_activo_fijo"; // Vista para editar
        } else {
            return "redirect:/activos/lista"; // Si no se encuentra, redirige a la lista
        }
    }

    // Actualización: Guardar los cambios del activo fijo
    @PostMapping("/editar/{codigo}")
    public String actualizarActivoFijo(@PathVariable String codigo,
            @ModelAttribute("activoFijo") ActivoFijo activoFijo) {
        activoFijoService.actualizarActivo(codigo, activoFijo);
        return "redirect:/activos/listar";
    }

    // Buscar un activo por código
    @GetMapping("/buscar")
    public String buscarActivos(@RequestParam("query") String query, Model model) {
        List<ActivoFijo> resultados = activoFijoService.buscarPorCodigoONombres(query);
        model.addAttribute("activos", resultados);
        return "listar_activos"; // Asegúrate de que esta sea la vista correcta
    }

    // Eliminar un activo fijo
    @PostMapping("/eliminar/{codigo}")
    public String eliminarActivoFijo(@PathVariable String codigo) {
        activoFijoService.eliminarPorCodigo(codigo);
        return "redirect:/activos/listar";
    }
}
