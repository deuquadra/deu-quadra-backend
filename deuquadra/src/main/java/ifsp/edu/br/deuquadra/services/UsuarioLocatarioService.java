package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;
import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;

import java.util.Optional;

public interface UsuarioLocatarioService {
    UsuarioLocatarioModel register(UsuarioLocatarioModel usuarioLocatarioModel);
    UsuarioLocatarioModel findByEmail(String email);
    UsuarioLocatarioModel update(UsuarioLocatarioModel usuarioLocatarioModel);

    Optional<UsuarioLocatarioModel> findById(Integer id);
}