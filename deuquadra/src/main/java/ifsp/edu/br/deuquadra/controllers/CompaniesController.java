package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
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

    //    @Operation(summary = "Incluir nova especie")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Especie criada"),
//            @ApiResponse(responseCode = "400", description = "Bad request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")})

}
