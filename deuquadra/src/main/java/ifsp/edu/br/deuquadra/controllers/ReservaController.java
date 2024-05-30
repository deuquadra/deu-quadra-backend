package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.models.ReservaModel;
import ifsp.edu.br.deuquadra.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

    @Autowired
    ReservaService reservaService;



    @GetMapping("/{id}")
    public ResponseEntity<Optional<ReservaModel>> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ReservaModel> create(@RequestBody ReservaModel reservaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reservaModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaModel> update(@RequestBody ReservaModel reservaModel) {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.update(reservaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        reservaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("quadra/{id}")
    public ResponseEntity<List<ReservaModel>> findReservaByQuadra(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findReservaByQuadra(id));
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<ReservaModel>> findReservaByLocatario(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findReservaByLocatario(id));
    }
}
