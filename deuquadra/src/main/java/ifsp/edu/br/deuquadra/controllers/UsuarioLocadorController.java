package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.dtos.Locatario.LoginDto;
import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;
import ifsp.edu.br.deuquadra.repositories.UsuarioLocadorRepository;
import ifsp.edu.br.deuquadra.services.UsuarioLocadorService;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@RestController
@RequestMapping("/locador")
@CrossOrigin
public class UsuarioLocadorController {

    @Autowired
    UsuarioLocadorService rentersService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioLocadorModel locatario){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(locatario.getPassword());
        locatario.setPassword(hashPassword);

        return ResponseEntity.status(HttpStatus.OK).body(rentersService.register(locatario));
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginInfo) {
        UsuarioLocadorModel user = rentersService.findByEmail(loginInfo.email);
        if(user ==  null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatched = passwordEncoder.matches(loginInfo.password, user.getPassword());
        if(!isPasswordMatched) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");

        String userJwt = Jwts.builder().setSubject(user.toString()).compact();
        return ResponseEntity.status(HttpStatus.OK).body(userJwt);
    }

}
