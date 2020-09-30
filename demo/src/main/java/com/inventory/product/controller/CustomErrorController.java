package com.inventory.product.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This is a controller class to display custom error page instead of white label error page
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        
        return "error";
    }
 
    public String getErrorPath() {
        return null;
    }
}