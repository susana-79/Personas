package rm.Personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import rm.Personas.modelo.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
