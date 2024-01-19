package fr.CornelisJ.exam.controller;

import fr.CornelisJ.exam.dto.CityDTO;
import fr.CornelisJ.exam.entity.City;
import fr.CornelisJ.exam.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/city", name = "AppCity")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        City city = cityService.findBySlug(slug);
        // Initialisation du ReviewDTO
//        CityDTO dto = new CityDTO();
//        dto.setCityId(city.getId());
//        dto.setUserId(1L);
        mav.setViewName("city/show");
        mav.addObject("city", city);
//        mav.addObject("reviewDto", dto);
        return mav;
    }

//    @GetMapping(path = "/search/{searched}", name = "search")
//    public ModelAndView search(@PathVariable String searched, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("citiesReleased", cityService.findAllBySearchedValue(searched));
//        return mav;
//    }

}
