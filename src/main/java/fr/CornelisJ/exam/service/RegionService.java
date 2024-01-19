package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.Region;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.RegionRepository;
import fr.CornelisJ.exam.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    private RegionRepository regionRepository;
    private Slugger slugger;

    public List<Region> findAll() {
        List<Region> regions = regionRepository.findAll();
        boolean hasFlush = false;
        for (Region region : regions) {
            if (region.getSlug() == null) {
                region.setSlug(slugger.slugify(region.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            regionRepository.flush();
        }
        return regions;
    }


    public Region findBySlug(String slug) {
        Optional<Region> optionalRegion = regionRepository.findBySlug(slug);
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

    public Region getObjectById(Long id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()) {
            throw new NotFoundInstantFrancingException("Region", "id", id);
        }
        return optionalRegion.get();
    }

//    public List<Region> findAllBySearchedValue(String search) {
//        return regionRepository.findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(search, search, search, search);
//    }
}
