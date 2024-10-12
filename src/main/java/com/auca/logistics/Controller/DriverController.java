package com.auca.logistics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auca.logistics.Model.Driver;
import com.auca.logistics.Model.DriverDto;
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

    @GetMapping("/drivercreate")
    public String createDriver(Model model) {
        System.out.println("Accessing /NewDriver"); 
        DriverDto driverCreate = new DriverDto();
        model.addAttribute("driverCreate", driverCreate);
        return "CreateDriver";
    }


    @PostMapping("/drivercreate")
    public String createDriver(@ModelAttribute DriverDto driverCreate,
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


    @GetMapping("/driverEdit")
    public String editDriver(Model model, @RequestParam int id) {

        Driver driver = driverRepository.findById(id).orElse(null);
        if(driver == null){
            return "redirect:/StaffDriver";
        }

        DriverDto driverDto = new DriverDto();
        driverDto.setFirstName(driver.getFirstName());
        driverDto.setLastName(driver.getLastName());
        driverDto.setPhone(driver.getPhone());
        driverDto.setAddress(driver.getAddress());
        driverDto.setGender(driver.getGender());

        model.addAttribute("driver",driver);
        model.addAttribute("driverDto", driverDto);

        return "/driverEdit";
    }
    
    
    @PostMapping("/driverEdit")
    public String editDriver(
        Model model,
        @RequestParam int id,
        @ModelAttribute DriverDto driverDto,
        BindingResult result
        ) {

            Driver driver = driverRepository.findById(id).orElse(null);
            if (driver == null){
                return "redirect:/StaffDriver";
            }

            model.addAttribute("driver",driver);

            if(result.hasErrors()){
                return "/driverEdit";
            }

            driver.setFirstName(driverDto.getFirstName());
            driver.setLastName(driverDto.getLastName());
            driver.setPhone(driverDto.getPhone());
            driver.setAddress(driverDto.getAddress());
            driver.setGender(driverDto.getGender());

            driverRepository.save(driver);
        return "redirect:/Staffdriver";
    }


    @GetMapping("/driverDelete")
    public String deletedriver(@RequestParam int id) {
        driverRepository.deleteById(id);
        return "redirect:/StaffDriver";
    }
    
    

} 
