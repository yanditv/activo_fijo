package ec.edu.ups.builder.activo_fijo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.ups.builder.activo_fijo.models.ActivoFijo;

@Service
public class ActivoFijoService {

    private List<ActivoFijo> activos = new ArrayList<>();

    // Método para crear un nuevo activo
    public ActivoFijo crearActivo(ActivoFijo activoFijo) {
        activos.add(activoFijo); // Almacena el activo en una lista en memoria
        return activoFijo;
    }

    // Método para listar todos los activos
    public List<ActivoFijo> listarActivos() {
        return activos;
    }

    public Optional<ActivoFijo> buscarPorCodigo(String codigo) {
        return activos.stream()
                .filter(activo -> activo.getCodigo().equals(codigo))
                .findFirst();
    }

    public void actualizarActivo(String codigo, ActivoFijo activoActualizado) {
        buscarPorCodigo(codigo).ifPresent(activo -> {
            activo.setMarca(activoActualizado.getMarca());
            activo.setModelo(activoActualizado.getModelo());
            activo.setAño(activoActualizado.getAño());
            activo.setColor(activoActualizado.getColor());
            activo.setUbicacion(activoActualizado.getUbicacion());
        });
    }

    public List<ActivoFijo> buscarPorCodigoONombres(String query) {
        List<ActivoFijo> resultados = new ArrayList<>();
        for (ActivoFijo activo : activos) {
            if (activo.getCodigo().contains(query) || activo.getNombres().contains(query)) {
                resultados.add(activo);
            }
        }
        return resultados;
    }

    public void eliminarPorCodigo(String codigo) {
        activos.removeIf(activo -> activo.getCodigo().equals(codigo));
    }
}