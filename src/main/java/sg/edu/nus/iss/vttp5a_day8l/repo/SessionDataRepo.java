package sg.edu.nus.iss.vttp5a_day8l.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day8l.model.HttpSessionList;
import sg.edu.nus.iss.vttp5a_day8l.model.HttpSessionData;

@Repository
public class SessionDataRepo {
    
    private HttpSessionList httpSessionList;

    public List<HttpSessionData> getAllSessionDatas() {
        return httpSessionList.getSessionList();
    }

    public void addSessionData(HttpSessionData httpSessionData) {
        httpSessionList.getSessionList().add(httpSessionData);
    }
}