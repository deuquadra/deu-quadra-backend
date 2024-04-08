package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.CompaniesModel;

import java.util.List;
import java.util.Optional;

public interface CompaniesService {


        CompaniesModel save(CompaniesModel companiesModel);

        List<CompaniesModel> findAll();

        Optional<CompaniesModel> findById(Integer id);

        CompaniesModel update(CompaniesModel companiesModel);

        void deleteById(Integer id);

}
