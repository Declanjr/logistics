package com.auca.logistics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auca.logistics.Model.Driver;
import com.auca.logistics.Model.DriverCreate;
import com.auca.logistics.Model.DriverRepository;



@Controller
@RequestMapping("/StaffDriver")
public class DriverController {

    @Autowired
    private DriverRepository  driverRepository;

    @GetMapping({"","/"})
    public String getdrivers(Model model) {
        var drivers = driverRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("drivers", drivers);
        return "StaffDriver";
    }

    @GetMapping("/NewDriver")
    public String createDriver(Model model) {
        DriverCreate driverCreate = new DriverCreate();
        model.addAttribute("driverCreate", driverCreate);
        return "NewDriver";
    }


    @PostMapping("/NewDriver")
    public String createDriver( @Validated @ModelAttribute DriverCreate driverCreate,
    BindingResult result
    ) {

        Driver driver = new Driver();
        driver.setFirstName(driverCreate.getFirstName());
        driver.setLastName(driverCreate.getLastName());
        driver.setPhone(driverCreate.getPhone());
        driver.setAddress(driverCreate.getAddress());
        driver.setGender(driverCreate.getGender());

        driverRepository.save(driver);
       
        return "redirect:/StaffDriver";
    }
    

} 
