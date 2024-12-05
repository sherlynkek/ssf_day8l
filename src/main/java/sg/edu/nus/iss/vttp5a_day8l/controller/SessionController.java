package sg.edu.nus.iss.vttp5a_day8l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.vttp5a_day8l.model.SessionData;

@Controller
@RequestMapping("/session")
public class SessionController {
    
    @GetMapping("/home")
    public String homeSession(){
        return "home";
    }

    @PostMapping("/list")
    public String showData(HttpSession session, Model model) {
        List<SessionData> sessions = null;
        if (session.getAttribute("session") == null) {
            sessions = new ArrayList<>();
        }
        else {
            sessions = (List<SessionData>) session.getAttribute("session");
        }

        model.addAttribute("sessions", sessions);
        return "listSession";
    }

    @GetMapping("/clear")
    public String clearSession(HttpSession session, Model model) {
        if (session.getAttribute("myname") == null)
            return "redirect:/session/home";

        model.addAttribute("myFullName", session.getAttribute("myname"));
        return "redirect:/session/home";
    }

    @GetMapping("/create")
    public String create(HttpSession session, Model model) {
        
        return "home";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session, Model model) {

        session.invalidate();

        return "redirect:/session/home";
    }
}
