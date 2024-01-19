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

    // SELECT * FROM department WHERE price BETWEEN min AND max
//    List<Department> findAllByPriceBetween(double min, double max);

    List<Listing> findTop12ByOrderByCreatedAtDesc();

    // SELECT * FROM department WHERE name LIKE "%{name}%"
    List<Listing> findAllByTitleIsContainingIgnoreCase(String title);

    // SELECT * FROM department WHERE name LIKE "{name}%"
    List<Listing> findAllByTitleIsStartingWithIgnoreCase(String title);

    // SELECT * FROM department WHERE department.publisher_id = {p.id}
//    List<Department> findAllByPublisher(Publisher p);

    // SELECT * FROM department g
    // JOIN department_category gc ON g.id = gc.department_id
    // JOIN category c ON c.id = gc.category_id
    // WHERE c.slug = {slug}
    // ORDER BY published_at DESC
//    List<Department> findAllByCategoriesSlugOrderByPublishedAtDesc(String slug);

    // SELECT * FROM department g
    // JOIN department_category gc ON g.id = gc.department_id
    // WHERE gc.category_id = {c.id}
    // ORDER BY published_at DESC
//    List<Department> findAllByCategoriesOrderByPublishedAtDesc(Category c);

    Optional<Listing> findBySlug(String slug);

//    List<Department> findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(String s1, String s2, String s3, String s4);

}