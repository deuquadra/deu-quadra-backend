package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.repositories.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@ComponentScan( "ifsp.edu.br.deuquadra.*" )
@Service
public class CompaniesServiceImpl implements CompaniesService {

    //@Autowired
    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public CompaniesModel save(CompaniesModel companiesModel) {
        return companiesRepository.save(companiesModel);
    }

    @Override
    public List<CompaniesModel> findAll() {
        return companiesRepository.findAll();
    }

    @Override
    public Optional<CompaniesModel> findById(Integer id) {
        return companiesRepository.findById(id);
    }

    @Override
    public CompaniesModel update(CompaniesModel id) {
        return companiesRepository.save(id);
    }

    @Override
    public void deleteById(Integer id) {
        companiesRepository.deleteById(id);
    }

    @Override
    public List<CompaniesModel> findByIdUser(Integer id) {
        return companiesRepository.findByIdUser(id);
    }

//    @Override
//    public List<CompaniesModel> findByProximity(Double minLat, Double maxLat, Double minLon, Double maxLon){
//        return companiesRepository.findByProximity(minLat, maxLat, minLon, maxLon);
//
//    }
}
