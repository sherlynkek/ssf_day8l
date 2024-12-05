package sg.edu.nus.iss.vttp5a_day8l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {
    
    @GetMapping("/home")
    public String homeSession(){
        return "home";
    }

    @PostMapping("/listSession")
    public String listSession(@RequestBody MultiValueMap<String, String> entity, HttpSession session, Model model) {
        String fName = entity.getFirst("fullname");
        session.setAttribute("myname", fName);

        model.addAttribute("myFullName", fName);
        return "listSession";
    }

    @GetMapping("/clearSession")
    public String clearSession(HttpSession session, Model model) {
        if (session.getAttribute("myname") == null)
            return "redirect:/session/home";

        model.addAttribute("myFullName", session.getAttribute("myname"));
        return "clearSession";
    }

    @GetMapping("/create")
    public String create(HttpSession session, Model model) {
        return "home";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session, Model model) {

        session.invalidate();

        return "redirect:/session/firstpage";
    }
}
