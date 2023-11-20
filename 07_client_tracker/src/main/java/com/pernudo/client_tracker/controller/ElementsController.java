package com.pernudo.client_tracker.controller;

import com.pernudo.client_tracker.service.ElementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class ElementsController {
    @Autowired
    ElementsService elementsService;

    @GetMapping(value = "search")
    public String search(@RequestParam("price") double priceMax, Model model){
        IReactiveDataDriverContextVariable reactive =
                new ReactiveDataDriverContextVariable(elementsService.elementByPrice(priceMax), 1);
        model.addAttribute("result", reactive);
        return "list";
    }

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

}
