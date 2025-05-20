package ejemplo.ms.duoc.demomicroservices.controller;

import ejemplo.ms.duoc.demomicroservices.model.Paciente;
import ejemplo.ms.duoc.demomicroservices.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Paciente pacienteNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNuevo);
        // return new ResponseEntity<>(pacienteNuevo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setRut(paciente.getRut());
            pac.setNombre(paciente.getNombre());
            pac.setApellido(paciente.getApellido());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setTelefono(paciente.getTelefono());
            pac.setEmail(paciente.getEmail());
            pac.setDireccion(paciente.getDireccion());
            // Actualiza otros campos según sea necesario
            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

