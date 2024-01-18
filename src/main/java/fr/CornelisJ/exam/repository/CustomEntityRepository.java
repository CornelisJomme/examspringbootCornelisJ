package fr.CornelisJ.exam.repository;

import java.util.Optional;

public interface CustomEntityRepository<T> {

    Optional<T> findByName(String name);
    Optional<T> findBySlug(String slug);

}
