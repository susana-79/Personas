package rm.Personas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rm.Personas.modelo.Persona;
import rm.Personas.repositorio.PersonaRepositorio;

import java.util.List;
@Service
public class PersonaServicio implements IPersonaServicio{
    @Autowired
    private PersonaRepositorio personaRepositorio;
    @Override
    public List<Persona> listarPersona() {
        return personaRepositorio.findAll();
    }

    @Override
    public Persona buscarPersonaPorId(Integer idPersona) {
        Persona persona=personaRepositorio.findById(idPersona).orElse(null);
        return persona;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepositorio.deleteById(id);

    }
}
