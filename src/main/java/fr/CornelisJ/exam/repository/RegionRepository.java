package fr.CornelisJ.exam.repository;

import fr.CornelisJ.exam.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository
            extends JpaRepository<Region, Long>,
                    EntityNameRepository<Region> {

    // SELECT * FROM region WHERE price BETWEEN min AND max
//    List<Region> findAllByPriceBetween(double min, double max);

//    List<Region> findTop9ByOrderByPublishedAtDesc();

    // SELECT * FROM region WHERE name LIKE "%{name}%"
    List<Region> findAllByNameIsContainingIgnoreCase(String name);

    // SELECT * FROM region WHERE name LIKE "{name}%"
    List<Region> findAllByNameIsStartingWithIgnoreCase(String name);

    // SELECT * FROM region WHERE region.publisher_id = {p.id}
//    List<Region> findAllByPublisher(Publisher p);

    // SELECT * FROM region g
    // JOIN region_category gc ON g.id = gc.region_id
    // JOIN category c ON c.id = gc.category_id
    // WHERE c.slug = {slug}
    // ORDER BY published_at DESC
//    List<Region> findAllByCategoriesSlugOrderByPublishedAtDesc(String slug);

    // SELECT * FROM region g
    // JOIN region_category gc ON g.id = gc.region_id
    // WHERE gc.category_id = {c.id}
    // ORDER BY published_at DESC
//    List<Region> findAllByCategoriesOrderByPublishedAtDesc(Category c);

    Optional<Region> findBySlug(String slug);

//    List<Region> findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(String s1, String s2, String s3, String s4);

}