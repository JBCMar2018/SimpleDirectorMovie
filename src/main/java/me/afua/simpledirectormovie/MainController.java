package me.afua.simpledirectormovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    MovieRepository movies;

    @Autowired
    DirectorRepository directors;

    @RequestMapping("/")
    public String showIndex(Model model)
    {
        //Displays a list of movies.
        model.addAttribute("directorlist",directors.findAll());
        return "listdirectors";
    }

    @RequestMapping("/addnewdirector")
    public String addADirector(Model model)
    {
        //As usual, allow an empty director object to be created into which values will be entered
        model.addAttribute("aDirector",new Director());
        return "addDirector";
    }


    @RequestMapping("/editDirector")
    public String editDirector(HttpServletRequest request, Model model)
    {
        //Make a director from the ID that is passed from the form (see the listdirectors form for the syntax)

        //Create a long from the request parameter that is passed
        long id = Long.parseLong(request.getParameter("directorid"));

        //Find the corresponding object from the database
        Director theDirector = directors.findById(id).get();

        //Modify the director object

        //Add the director to the model, so it can be passed to the view.
        //Remember to name it appropriately, so that the addDirector form can use it.

        model.addAttribute("aDirector",theDirector);
        return "addDirector";
    }
    @PostMapping("/savedirector")
    public String saveDirector(@Valid @ModelAttribute("aDirector") Director director, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addDirector";
        }
        directors.save(director);
        return "redirect:/";

    }


    //Movie Details

    @RequestMapping("/addmovie")
    public String addmovie(Model model)
    {
        //As usual, allow an empty director object to be created into which values will be entered
        model.addAttribute("aMovie",new Movie());
        model.addAttribute("directorlist",directors.findAll());
        return "addmovie";
    }

    @PostMapping("/savemovie")
    public String saveMovie(@Valid @ModelAttribute("aMovie") Movie movie, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addmovie";
        }
        movies.save(movie);
        return "redirect:/";

    }


}
