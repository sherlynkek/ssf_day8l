package sg.edu.nus.iss.vttp5a_day8l.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

import sg.edu.nus.iss.vttp5a_day8l.service.SessionDataService;
import sg.edu.nus.iss.vttp5a_day8l.model.HttpSessionData;
import sg.edu.nus.iss.vttp5a_day8l.model.HttpSessionList;

@Controller
@RequestMapping
public class SessionController {
    
    @Autowired
    SessionDataService sessionDataService;

    @GetMapping("/home")
    public String homepage(HttpSession httpSession) {
        HttpSessionList httpSessionList = (HttpSessionList)httpSession.getAttribute("session");
        // Optional<List<HttpSessionData>> data = Optional.of(httpSessionList.getSessionList());
        // List<HttpSessionData> dataList = data.get();
        if (httpSessionList == null) {
            httpSessionList = new HttpSessionList();
            httpSessionList.setSessionList(new ArrayList<>());
            httpSession.setAttribute("session", httpSessionList);
        }
        return "homepage";
    }

    @GetMapping("/sessions")
    public String getSessionsDataList(Model model, HttpSession httpSession) {
        // Object temp = httpSession.getAttribute("data");
        // if(temp instanceof List<HttpSessionData>){
        //     List<HttpSessionData> dataList = (List<HttpSessionData>) temp;
        // }
        HttpSessionList httpSessionList = (HttpSessionList)httpSession.getAttribute("session");
        Optional<List<HttpSessionData>> data = Optional.of(httpSessionList.getSessionList());
        List<HttpSessionData> dataList = data.get();
        model.addAttribute("dataList", dataList);
        return "sessionList";
    }

    @GetMapping("/sessions/delete") 
    public String deleteSession(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/sessions/create")
    public String createNewSessionData(Model model, HttpSessionData data) {
        data = new HttpSessionData();
        model.addAttribute("data", data);
        return "sessionForm";
    }

    @PostMapping("/sessions/create")
    public String handleSessionForm(@ModelAttribute HttpSessionData dataGot, HttpSession httpSession) {
        HttpSessionList httpSessionList = (HttpSessionList)httpSession.getAttribute("session");
        Optional<List<HttpSessionData>> data = Optional.of(httpSessionList.getSessionList());
        List<HttpSessionData> dataList = data.get();
        dataList.add(dataGot);
        httpSession.setAttribute("dataList", dataList);

        return "redirect:/home";
    }
}
