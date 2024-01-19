package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.Department;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.DepartmentRepository;
import fr.CornelisJ.exam.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private Slugger slugger;

    public List<Department> findAll() {
        List<Department> departments = departmentRepository.findAll();
        boolean hasFlush = false;
        for (Department department : departments) {
            if (department.getSlug() == null) {
                department.setSlug(slugger.slugify(department.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            departmentRepository.flush();
        }
        return departments;
    }


    public Department findBySlug(String slug) {
        Optional<Department> optionalDepartment = departmentRepository.findBySlug(slug);
        if (optionalDepartment.isEmpty()) {
            throw new NotFoundInstantFrancingException("Department", "slug", slug);
        }
        return optionalDepartment.get();
    }

//    public List<Department> findTop9ByOrderByPublishedAtDesc() {
//        return departmentRepository.findTop9ByOrderByPublishedAtDesc();
//    }

//    public List<Department> findByCategory(String slug) {
//        return departmentRepository.findAllByCategoriesSlugOrderByPublishedAtDesc(slug);
//    }

    public Department getObjectById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new NotFoundInstantFrancingException("Department", "id", id);
        }
        return optionalDepartment.get();
    }

//    public List<Department> findAllBySearchedValue(String search) {
//        return departmentRepository.findAllByNameIsContainingIgnoreCaseOrCategoriesNameIsContainingIgnoreCaseOrPlatformsNameIsContainingIgnoreCaseOrCountriesNameIsContainingIgnoreCaseOrderByPriceDesc(search, search, search, search);
//    }
}
