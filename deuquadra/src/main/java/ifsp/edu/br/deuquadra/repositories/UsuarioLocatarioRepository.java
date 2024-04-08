package ifsp.edu.br.deuquadra.repositories;

import ifsp.edu.br.deuquadra.models.UsuarioLocatarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLocatarioRepository extends JpaRepository<UsuarioLocatarioModel, Integer> {
    UsuarioLocatarioModel findByEmail(String email);
}
