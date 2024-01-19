package fr.CornelisJ.exam.controller;

import fr.CornelisJ.exam.entity.Department;
import fr.CornelisJ.exam.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/department", name = "AppDepartment")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Department department = departmentService.findBySlug(slug);
        // Initialisation du ReviewDTO
//        DepartmentDTO dto = new DepartmentDTO();
//        dto.setDepartmentId(department.getId());
//        dto.setUserId(1L);
        mav.setViewName("department/show");
        mav.addObject("department", department);
//        mav.addObject("reviewDto", dto);
        return mav;
    }

//    @GetMapping(path = "/search/{searched}", name = "search")
//    public ModelAndView search(@PathVariable String searched, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("citiesReleased", departmentService.findAllBySearchedValue(searched));
//        return mav;
//    }

}
