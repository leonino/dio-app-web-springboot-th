package com.leonino.appweb.controller;

import com.leonino.appweb.model.Jedi;
import com.leonino.appweb.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class JediController {

    @Autowired
    JediRepository jediRepository;

    @GetMapping
    public String main() {
        return "redirect:jedi";
    }

    @GetMapping("/jedi")
    public ModelAndView jedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", jediRepository.getAllJedi());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasFieldErrors()) return "new-jedi";

        jediRepository.addJedi(jedi);

        redirectAttributes.addFlashAttribute("message","Jedi cadastrado com sucesso: "+jedi.getFirstname()+" "+jedi.getLastname());

        return "redirect:jedi";
    }
}
