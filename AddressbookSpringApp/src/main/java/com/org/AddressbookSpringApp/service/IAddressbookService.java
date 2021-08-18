package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookDTO> getAddressbookData();
    AddressbookData getAddressbookDataById(int id);
    AddressbookDTO addAddressbookData(AddressbookDTO addressbookDTO);
    AddressbookDTO updateAddressbookData(int id, AddressbookDTO addressbookDTO);
    void deleteAddressbookData(int id);
}
