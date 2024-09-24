package rm.Personas.servicio;

import rm.Personas.modelo.Persona;

import java.util.List;

public interface IPersonaServicio {
    public List<Persona> listarPersona();
    public Persona buscarPersonaPorId(Integer idPersona);
    public Persona guardarPersona(Persona persona);
    public Persona actualizarPersona(Persona persona);
    public void  eliminarPersona(Integer persona);
}
