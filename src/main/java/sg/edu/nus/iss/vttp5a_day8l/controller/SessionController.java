package sg.edu.nus.iss.vttp5a_day8l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @SuppressWarnings("unchecked")
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

    @GetMapping("")
    public String sessionCreate(Model model) {
        SessionData sessionData = new SessionData();
        model.addAttribute("session", sessionData);
        return "create";
    }


    @SuppressWarnings("unchecked")
    @PostMapping("")
    public String postSessionCreate(@ModelAttribute("session") SessionData entity, HttpSession httpSession, Model model) {

        List<SessionData> sessions = null;
        if (httpSession.getAttribute("session") == null) {
            sessions = new ArrayList<>();
        } else {
            sessions = (List<SessionData>) httpSession.getAttribute("session");
        }
        sessions.add(entity);
        
        httpSession.setAttribute("session", sessions);
        model.addAttribute("sessions", sessions);
        return "listSession";
    }
    
    @GetMapping("/clear")
    public String clearSession(HttpSession httpSession) {
        httpSession.removeAttribute("session");
        httpSession.invalidate();

        return "redirect:/sessions/home";
    }
}
