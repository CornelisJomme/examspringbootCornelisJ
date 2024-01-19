package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.Listing;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.ListingRepository;
import fr.CornelisJ.exam.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService {

    private ListingRepository listingRepository;
    private Slugger slugger;

    public List<Listing> findAll() {
        List<Listing> listings = listingRepository.findAll();
        boolean hasFlush = false;
        for (Listing listing : listings) {
            if (listing.getSlug() == null) {
                listing.setSlug(slugger.slugify(listing.getTitle()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            listingRepository.flush();
        }
        return listings;
    }


    public Listing findBySlug(String slug) {
        Optional<Listing> optionalListing = listingRepository.findBySlug(slug);
        if (optionalListing.isEmpty()) {
            throw new NotFoundInstantFrancingException("Listing", "slug", slug);
        }
        return optionalListing.get();
    }

    public List<Listing> findTop12ByOrderByCreatedAtDesc() {
        return listingRepository.findTop12ByOrderByCreatedAtDesc();
    }

//    public List<Listing> findByCategory(String slug) {
//        return listingRepository.findAllByCategoriesSlugOrderByPublishedAtDesc(slug);
//    }

    public Listing getObjectById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isEmpty()) {
            throw new NotFoundInstantFrancingException("Listing", "id", id);
        }
        return optionalListing.get();
    }

}
