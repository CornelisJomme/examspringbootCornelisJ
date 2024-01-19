package fr.CornelisJ.exam.controller;

import fr.CornelisJ.exam.entity.Listing;
import fr.CornelisJ.exam.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/listing", name = "AppListing")
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @GetMapping(path = "", name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("listing/index");
        mav.addObject("listings", listingService.findTop12ByOrderByCreatedAtDesc());
        return mav;
    }

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Listing listing = listingService.findBySlug(slug);
        mav.setViewName("listing/show");
        mav.addObject("listing", listing);
        mav.addObject("listing/index", listing);
        return mav;
    }

//    @GetMapping(path = "/search/{searched}", name = "search")
//    public ModelAndView search(@PathVariable String searched, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("citiesReleased", regionService.findAllBySearchedValue(searched));
//        return mav;
//    }

}
