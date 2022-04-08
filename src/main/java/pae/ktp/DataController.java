/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pae.ktp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SWMahardhika
 */
@CrossOrigin
@Controller
public class DataController {
    
    DataktpJpaController dataktpJpaController = new DataktpJpaController();
    List<Dataktp> newdata = new ArrayList<>();
    
    @RequestMapping("/main")
    public String getMain(){
        return "menu";
    }
    
    @RequestMapping("/data")
    public String getDataKTP(Model model){
        int record = dataktpJpaController.getDataktpCount();
        String result = "";
        try {
            newdata = dataktpJpaController.findDataktpEntities().subList(0, record);
        } catch (Exception e) {
            result = e.getMessage();
        }
        
        model.addAttribute("goData", newdata);
        //model.addAttribute("record", record);
        
        return "database";
    }
}
