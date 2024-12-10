package sg.edu.nus.iss.vttp5a_day8l.controller;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_day8l.constant.Constant;


@Controller
@RequestMapping("/demo")
public class DemoController {
    
    /* @Autowired
    @Qualifier(Constant.template01)
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    @Qualifier(Constant.template02)
    RedisTemplate<String, String> redisTemplate2;

    @GetMapping()
    public String displayDateTime(Model model) throws ParseException  {

        String strDate = "2004-08-09 15:30:33";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date testDate = sdf.parse(strDate);
        long epochMillisecondsDate = testDate.getTime();

        Date testDate2 = new Date(epochMillisecondsDate);

        model.addAttribute("date", testDate2);
        return "demo";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<String> test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        redisTemplate.opsForHash().put("test", "map", list.toString());

        Object s = redisTemplate.opsForHash().get("test", "map");
        List<String> list2 = new ArrayList<>();
        String str = s.toString();
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace(" ", "");
        String[] splitString = str.split(",");
        for (String sss : splitString) {
            list2.add(sss);
        }

        return list2;
    }

    @GetMapping("/test/person")
    @ResponseBody
    public List<Person> testSerializedPerson() throws ParseException {
        String strDate = "1980-12-12 10:45:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDob = sdf.parse(strDate);
        List<Person> persons = new ArrayList<>();
        Person p = new Person(1, "Darryl", "darrylng@nus.edu.sg", "97304777", myDob);
        persons.add(p);
        p = new Person(2, "Derrick", "derricktan@nus.edu.sg", "81234567", myDob);
        persons.add(p);
        p = new Person(3, "Nancy", "nancy@nus.edu.sg", "98765432", myDob);
        persons.add(p);

        for (Person p1 : persons) {
        // 1. serialize the persons array using JSon-P to JsonObject
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("id", p1.getId().toString());
            jsonObjectBuilder.add("fullName", p1.getFullName());
            jsonObjectBuilder.add("email", p1.getEmail());
            jsonObjectBuilder.add("phone", p1.getPhone());
            jsonObjectBuilder.add("dob", p1.getDob().toString());
            JsonObject jsonObject = jsonObjectBuilder.build();

        // 2. save the JsonObject as into redis map: key named "persons"
            redisTemplate2.opsForHash().put(Constant.personKey, p1.getId().toString(), jsonObject.toString());
        }

        // 3. read the redis key "persons" into Map entries
        Map<Object, Object> retrievedData = redisTemplate2.opsForHash().entries(Constant.personKey);

        List<Person> retrievedPersonList = new ArrayList<>();
        // 4. loop and display the entry of the entries
        for (Entry<Object, Object> mapEntry : retrievedData.entrySet()) {
            JsonReader jsonReader = Json.createReader(new StringReader(mapEntry.getValue().toString()));
            JsonObject jsonObject = jsonReader.readObject();

        // 5. change the return method to return List<Persons>
        // deserialize back to collection of persons, List<Person>
            Person pp = new Person();
            pp.setId(Integer.parseInt(jsonObject.getString("id")));
            pp.setFullName(jsonObject.getString("fullName"));
            pp.setEmail(jsonObject.getString("email"));
            pp.setPhone(jsonObject.getString("phone"));
            String strDOB = jsonObject.getString("dob");
            // Fri Dec 12 10:45:00 GMT+08:00 1980
            SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zz yyyy");
            Date myDob1 = sdf1.parse(strDOB);
            pp.setDob(myDob1);
            retrievedPersonList.add(pp);
        }

        // return the list of person, List<Person>
        return retrievedPersonList;
    } */
    
}
