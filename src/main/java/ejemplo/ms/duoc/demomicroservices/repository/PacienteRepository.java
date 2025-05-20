package ejemplo.ms.duoc.demomicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ejemplo.ms.duoc.demomicroservices.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar pacientes por nombre o apellido
    // List<Paciente> findByNombre(String nombre);
    // List<Paciente> findByApellido(String apellido);

}
