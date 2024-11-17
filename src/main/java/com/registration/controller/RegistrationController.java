package com.registration.controller;

import com.registration.payload.RegistrationDto;
import com.registration.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    //http://localhost:8080/api/v1/registration/create
    @PostMapping("/create")
    public ResponseEntity<RegistrationDto> addRegistration(@RequestBody RegistrationDto registrationDto){
        RegistrationDto registrationDto1=registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(registrationDto1, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/v1/registration/delete?id=
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/registration/update?id=
    @PutMapping("/update")
    public ResponseEntity<RegistrationDto> updateRegistration(@RequestBody RegistrationDto registrationDto, @RequestParam long id){
        RegistrationDto registrationDto2=registrationService.updateRegistration(registrationDto,id);
        return new ResponseEntity<>(registrationDto2, HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/registration/get?pageNo=1&pageSize=3&sortBy=name&sortDir=asc
    //http://localhost:8080/api/v1/registration/get?pageNo=1&pageSize=3&sortBy=name&sortDir=desc
    @GetMapping("/get")
    public ResponseEntity<List<RegistrationDto>> getRegistration(
            @RequestParam(name="pageNo", defaultValue = "1",required = false) int pageNo,
            @RequestParam(name="pageSize", defaultValue = "3", required = false)int pageSize,
            @RequestParam(name="sortBy", defaultValue = "name",required = false) String sortBy,
            @RequestParam(name="sortDir", defaultValue = "name", required = false) String sortDir
    ){
        List<RegistrationDto> registrationDtos=registrationService.getRegistration(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(registrationDtos, HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/registration/ById?id=
    @GetMapping("/ById")
    public ResponseEntity<RegistrationDto> getRegistartionById(@RequestParam long id){
        RegistrationDto registrationDto=registrationService.getRegistrationById(id);
        return new ResponseEntity<>(registrationDto, HttpStatus.OK);

    }
}
