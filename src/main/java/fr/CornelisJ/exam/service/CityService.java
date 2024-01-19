package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.City;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.CityRepository;
import fr.CornelisJ.exam.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;
    private Slugger slugger;

    public List<City> findAll() {
        List<City> citys = cityRepository.findAll();
        boolean hasFlush = false;
        for (City city : citys) {
            if (city.getSlug() == null) {
                city.setSlug(slugger.slugify(city.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            cityRepository.flush();
        }
        return citys;
    }


    public City findBySlug(String slug) {
        Optional<City> optionalCity = cityRepository.findBySlug(slug);
        if (optionalCity.isEmpty()) {
            throw new NotFoundInstantFrancingException("City", "slug", slug);
        }
        return optionalCity.get();
    }

//    public List<City> findTop9ByOrderByPublishedAtDesc() {
//        return cityRepository.findTop9ByOrderByPublishedAtDesc();
//    }

//    public List<City> findByCategory(String slug) {
//        return cityRepository.findAllByCategoriesSlugOrderByPublishedAtDesc(slug);
//    }

    public City getObjectById(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isEmpty()) {
            throw new NotFoundInstantFrancingException("City", "id", id);
        }
        return optionalCity.get();
    }

//    public List<City> findAllBySearchedValue(String search) {
//        return cityRepository.findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(search, search, search, search);
//    }
}
