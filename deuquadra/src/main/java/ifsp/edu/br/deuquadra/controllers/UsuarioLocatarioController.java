package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.dtos.Locatario.LoginDto;
import ifsp.edu.br.deuquadra.dtos.Locatario.LoginResponse;
import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;
import ifsp.edu.br.deuquadra.repositories.UsuarioLocatarioRepository;
import ifsp.edu.br.deuquadra.services.UsuarioLocatarioServiceImpl;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@RestController
@RequestMapping("/locatario")
@CrossOrigin
@Validated
public class UsuarioLocatarioController {

    @Autowired
    UsuarioLocatarioServiceImpl locatarioService;

    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody @Valid  UsuarioLocatarioModel locatario){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(locatario.getPassword());
        locatario.setPassword(hashPassword);

        return ResponseEntity.status(HttpStatus.OK).body(locatarioService.register(locatario));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginInfo) {
        UsuarioLocatarioModel user = locatarioService.findByEmail(loginInfo.email);
        if(user ==  null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatched = passwordEncoder.matches(loginInfo.password, user.getPassword());
        if(!isPasswordMatched) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");

        String userJwt = Jwts.builder().setSubject(user.toString()).compact();
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(userJwt, userJwt));
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid UsuarioLocatarioModel locatario){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(locatario.getPassword());
        locatario.setPassword(hashPassword);

        return ResponseEntity.status(HttpStatus.OK).body(locatarioService.update(locatario));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioLocatarioModel>> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(locatarioService.findById(id));
    }
}
