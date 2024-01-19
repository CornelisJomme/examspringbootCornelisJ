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
public class ModelService {

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
        Optional<Model> optionalModel = modelRepository.findBySlug(slug);
        if (optionalModel.isEmpty()) {
            throw new NotFoundInstantFrancingException("Model", "slug", slug);
        }
        return optionalModel.get();
    }

    public Model getObjectById(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isEmpty()) {
            throw new NotFoundInstantFrancingException("Model", "id", id);
        }
        return optionalModel.get();
    }
}
