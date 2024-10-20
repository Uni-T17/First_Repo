package com.kit.kat.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScholarshipViewController {

    @GetMapping("/scholarship-management")
    public String viewScholarships() {
        // Return the Thymeleaf template name without the .html extension
        return "scholarships";
    }
}
