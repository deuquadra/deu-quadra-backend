package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import ifsp.edu.br.deuquadra.repositories.CompaniesRepository;
import ifsp.edu.br.deuquadra.repositories.CourtsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface CompaniesService {


        CompaniesModel save(CompaniesModel companiesModel);

        List<CompaniesModel> findAll();

        Optional<CompaniesModel> findById(Integer id);

        CompaniesModel update(CompaniesModel companiesModel);

        void deleteById(Integer id);

        List<CompaniesModel> findByIdUser(Integer id);
}
