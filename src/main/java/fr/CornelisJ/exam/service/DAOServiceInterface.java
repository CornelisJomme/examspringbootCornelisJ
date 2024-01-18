package fr.CornelisJ.exam.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T getObjectById(Long id);

}
