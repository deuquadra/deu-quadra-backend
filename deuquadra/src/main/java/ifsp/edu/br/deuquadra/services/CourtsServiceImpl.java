package ifsp.edu.br.deuquadra.services;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import ifsp.edu.br.deuquadra.repositories.CompaniesRepository;
import ifsp.edu.br.deuquadra.repositories.CourtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @ComponentScan( "ifsp.edu.br.deuquadra.*" )
    @Service
    public class CourtsServiceImpl implements CourtsService {

        //@Autowired
        @Autowired
        private CourtsRepository courtsRepository;

        @Override
        public CourtsModel save(CourtsModel courtsModel) {
            return courtsRepository.save(courtsModel);
        }

        @Override
        public List<CourtsModel> findAll() {
            return courtsRepository.findAll();
        }

        @Override
        public Optional<CourtsModel> findById(Integer id) {
            return courtsRepository.findById(id);
        }

        @Override
        public CourtsModel update(CourtsModel id) {
            return courtsRepository.save(id);
        }

        @Override
        public void deleteById(Integer id) {
            courtsRepository.deleteById(id);
        }

        @Override
        public List<CourtsModel> findByProximity(Double minLat, Double maxLat, Double minLon, Double maxLon){
            return courtsRepository.findByProximity(minLat, maxLat, minLon, maxLon);

        }


    }
