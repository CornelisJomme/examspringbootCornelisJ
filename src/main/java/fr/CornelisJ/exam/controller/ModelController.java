package fr.CornelisJ.exam.controller;

import fr.CornelisJ.exam.entity.Model;
import fr.CornelisJ.exam.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/model", name = "AppModel")
@AllArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Model model = modelService.findBySlug(slug);
        // Initialisation du ReviewDTO
//        ModelDTO dto = new ModelDTO();
//        dto.setModelId(model.getId());
//        dto.setUserId(1L);
        mav.setViewName("model/show");
        mav.addObject("model", model);
//        mav.addObject("reviewDto", dto);
        return mav;
    }

//    @GetMapping(path = "/search/{searched}", name = "search")
//    public ModelAndView search(@PathVariable String searched, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("citiesReleased", modelService.findAllBySearchedValue(searched));
//        return mav;
//    }

}
