package fr.CornelisJ.exam.repository;

import fr.CornelisJ.exam.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository
            extends JpaRepository<City, Long>,
                    EntityNameRepository<City> {

    // SELECT * FROM city WHERE price BETWEEN min AND max
//    List<City> findAllByPriceBetween(double min, double max);

//    List<City> findTop9ByOrderByPublishedAtDesc();

    // SELECT * FROM city WHERE name LIKE "%{name}%"
    List<City> findAllByNameIsContainingIgnoreCase(String name);

    // SELECT * FROM city WHERE name LIKE "{name}%"
    List<City> findAllByNameIsStartingWithIgnoreCase(String name);

    // SELECT * FROM city WHERE city.publisher_id = {p.id}
//    List<City> findAllByPublisher(Publisher p);

    // SELECT * FROM city g
    // JOIN city_category gc ON g.id = gc.city_id
    // JOIN category c ON c.id = gc.category_id
    // WHERE c.slug = {slug}
    // ORDER BY published_at DESC
//    List<City> findAllByCategoriesSlugOrderByPublishedAtDesc(String slug);

    // SELECT * FROM city g
    // JOIN city_category gc ON g.id = gc.city_id
    // WHERE gc.category_id = {c.id}
    // ORDER BY published_at DESC
//    List<City> findAllByCategoriesOrderByPublishedAtDesc(Category c);

    Optional<City> findBySlug(String slug);

//    List<City> findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(String s1, String s2, String s3, String s4);

}