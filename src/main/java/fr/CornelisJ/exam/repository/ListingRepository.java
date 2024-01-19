package fr.CornelisJ.exam.repository;

import fr.CornelisJ.exam.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository
            extends JpaRepository<Listing, Long>,
                    EntityNameRepository<Listing> {


    List<Listing> findTop12ByOrderByCreatedAtDesc();

    List<Listing> findAllByTitleIsContainingIgnoreCase(String title);

    List<Listing> findAllByTitleIsStartingWithIgnoreCase(String title);


    Optional<Listing> findBySlug(String slug);


}