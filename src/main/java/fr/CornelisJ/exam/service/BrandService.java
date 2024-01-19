package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.Model;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.ModelRepository;
import fr.CornelisJ.exam.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private ModelRepository modelRepository;
    private Slugger slugger;

    public List<Model> findAll() {
        List<Model> models = modelRepository.findAll();
        boolean hasFlush = false;
        for (Model model : models) {
            if (model.getSlug() == null) {
                model.setSlug(slugger.slugify(model.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            modelRepository.flush();
        }
        return models;
    }


    public Model findBySlug(String slug) {
        Optional<Model> optionalRegion = modelRepository.findBySlug(slug);
        if (optionalRegion.isEmpty()) {
            throw new NotFoundInstantFrancingException("Region", "slug", slug);
        }
        return optionalRegion.get();
    }

//    public List<Region> findTop9ByOrderByPublishedAtDesc() {
//        return regionRepository.findTop9ByOrderByPublishedAtDesc();
//    }

//    public List<Region> findByCategory(String slug) {
//        return regionRepository.findAllByCategoriesSlugOrderByPublishedAtDesc(slug);
//    }

    public Model getObjectById(Long id) {
        Optional<Model> optionalRegion = modelRepository.findById(id);
        if (optionalRegion.isEmpty()) {
            throw new NotFoundInstantFrancingException("Region", "id", id);
        }
        return optionalRegion.get();
    }

//    public List<Region> findAllBySearchedValue(String search) {
//        return regionRepository.findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(search, search, search, search);
//    }
}
