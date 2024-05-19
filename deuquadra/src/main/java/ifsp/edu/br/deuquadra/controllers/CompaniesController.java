package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.models.BoundingBox;
import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CoordinatesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import ifsp.edu.br.deuquadra.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompaniesController {

    @Autowired
    CompaniesService companieService;

    @GetMapping
    public ResponseEntity<List<CompaniesModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(companieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CompaniesModel>> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(companieService.findById(id));
    }

    @GetMapping("empresa/{id}")
    public ResponseEntity<List<CompaniesModel>> findByIdUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(companieService.findByIdUser(id));
    }

    @PostMapping
    public ResponseEntity<CompaniesModel> create(@RequestBody CompaniesModel companiesModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(companieService.save(companiesModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompaniesModel> update(@RequestBody CompaniesModel companiesModel){
        return ResponseEntity.status(HttpStatus.OK).body(companieService.update(companiesModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        companieService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping("/search")
    public ResponseEntity<List<CompaniesModel>> FindByProximity(@RequestBody CoordinatesModel coordinates){

        BoundingBox bb = new BoundingBox(coordinates.getLat(), coordinates.getLon(), coordinates.getKm());

        return ResponseEntity.status(HttpStatus.OK).body(companieService.findByProximity(bb.getMinLatitude(), bb.getMaxLatitude(), bb.getMinLongitude(), bb.getMaxLongitude()));
    }
}
