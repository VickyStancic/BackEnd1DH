package com.dh.clase36.integradora.controller;

import com.dh.clase36.integradora.entities.Odontologo;
import com.dh.clase36.integradora.entities.Paciente;
import com.dh.clase36.integradora.entities.Turno;
import com.dh.clase36.integradora.exceptions.ResourceNotFoundException;
import com.dh.clase36.integradora.service.OdontologoService;
import com.dh.clase36.integradora.service.PacienteService;
import com.dh.clase36.integradora.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //controlar si los id son existentes
        Optional<Paciente> paciente= pacienteService.buscar(turno.getPaciente().getId());
        Optional<Odontologo> odontologo= odontologoService.buscar(turno.getOdontologo().getId());
        //control
        if (paciente.isPresent()&&odontologo.isPresent()){
            //okey, podemos agregar el turno
            respuesta=ResponseEntity.ok(turnoService.guardar(turno));
        }
        else{
            respuesta= ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PutMapping
    public Turno actualizar(@RequestBody Turno turno){
        return turnoService.actualizar(turno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id){
        if(turnoService.buscar(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscar(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok("Se elimino el Turno sin problemas");
    }
}
