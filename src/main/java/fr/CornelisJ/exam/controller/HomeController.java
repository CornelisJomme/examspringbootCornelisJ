package fr.CornelisJ.exam.controller;

import fr.CornelisJ.exam.service.ListingService;
import fr.CornelisJ.exam.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/", name = "AppHome")
@AllArgsConstructor
public class HomeController {

    private ListingService listingService;

    @GetMapping(name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("listing", listingService.findTop12ByOrderByCreatedAtDesc());
        return mav;
    }

}
