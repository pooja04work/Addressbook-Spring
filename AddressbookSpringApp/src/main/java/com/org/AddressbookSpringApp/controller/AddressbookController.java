package com.org.AddressbookSpringApp.controller;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.dto.ResponseDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;
import com.org.AddressbookSpringApp.service.IAddressbookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
//@Validated
public class AddressbookController {

    @Autowired
    IAddressbookService addressbookService;

    //Adding SLF4j
    Logger logger = LoggerFactory.getLogger(AddressbookController.class);

    /*
     * @method: Ability To Get All Person From DB Using GET Method
     * @Execution URL: localhost:8080/addressbook/get
     */
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        logger.trace("Retrieve List of person from addressbook");
        List<AddressbookDTO> addressbookList =  addressbookService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("get call Success", addressbookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @method: Ability To Get Person By Id From DB Using GET Method
     * @Execution URL: localhost:8080/addressbook/get/1
     * @param: id
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable("id") int id){
        logger.trace("Find a employee by Id from addressbook");
        AddressbookData addressbookDTO = addressbookService.getAddressbookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get correct Data", addressbookDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @method: Ability To add Person To the DB Using POST Method
     * @Execution URL: localhost:8080/addressbook/create
     * @param: addressbookDTO
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        logger.trace("Adding person To addressbook");
        AddressbookDTO addressbookDTO1 = addressbookService.addAddressbookData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("add person Successfully", addressbookDTO1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @method: Ability To Update Person To the DB Using PUT Method
     * @Execution URL: localhost:8080/addressbook/update
     * @param: addressbookDTO, id
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO,@PathVariable int id) {
        logger.trace("Update person detail By Id to addressbook");
        AddressbookDTO addressbookDTO1 = addressbookService.updateAddressbookData(id,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated person Successfully", addressbookDTO1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @method: Ability To Delete Person From the DB Using DELETE Method
     * @Execution URL: localhost:8080/addressbook/delete/1
     * @param: id
     */
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("Id") int id) {
        logger.trace("Deleting a person from addressbook");
        addressbookService.deleteAddressbookData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully: ",id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}