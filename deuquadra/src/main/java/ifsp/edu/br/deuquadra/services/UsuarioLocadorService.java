package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.UsuarioLocadorModel;

import java.util.Optional;

public interface UsuarioLocadorService {
    UsuarioLocadorModel register(UsuarioLocadorModel usuarioLocadorModel);
    UsuarioLocadorModel findByEmail(String email);
    UsuarioLocadorModel update(UsuarioLocadorModel usuarioLocadorModel);

    Optional<UsuarioLocadorModel> findById(Integer id);
}
