package rm.Personas.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rm.Personas.excepcion.RecursosNoEncontrado;
import rm.Personas.modelo.Persona;
import rm.Personas.servicio.IPersonaServicio;

import java.util.List;

@RestController
//http://localhost:8080/personas-app/
@RequestMapping("personas-app")
// el puerto de react
@CrossOrigin(value="http://localhost:3000")
public class PersonaControlador {
    private static final Logger logger=
            LoggerFactory.getLogger(PersonaControlador.class);
 @Autowired
    private IPersonaServicio personaServicio;
    //http://localhost:8080/personas-app/personas
    @GetMapping("/personas")
    public List<Persona> obtenerPersonas(){
        var personas=personaServicio.listarPersona();

        personas.forEach(persona -> logger.info(persona.toString()));
        return personas;
    }
    @PostMapping("/personas")
    public Persona agregarPersonas(@RequestBody Persona persona){
        logger.info("Persona a agregar:"+ persona);
        return personaServicio.guardarPersona(persona);
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona>
    obtenerPersonaPorId(@PathVariable Integer id){
        Persona persona= personaServicio.buscarPersonaPorId(id);
        if (persona==null)
            throw new RecursosNoEncontrado("No se encontro el Id:"+ id);
        return ResponseEntity.ok(persona);

    }
    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona detallesPersona) {
        Persona persona = personaServicio.buscarPersonaPorId(id);
        if (persona == null) {
            throw new RecursosNoEncontrado("No se encontro el Id:" + id);
        }

        persona.setNombre(detallesPersona.getNombre());
        persona.setApellido(detallesPersona.getApellido());
        persona.setPersonalidad(detallesPersona.getPersonalidad());

        Persona personaActualizada = personaServicio.actualizarPersona(persona);
        return ResponseEntity.ok(personaActualizada);
    }
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Integer id) {
        Persona persona = personaServicio.buscarPersonaPorId(id);
        if (persona == null) {
            throw new RecursosNoEncontrado("No se encontro el Id:" + id);
        }

        personaServicio.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
    
    }






