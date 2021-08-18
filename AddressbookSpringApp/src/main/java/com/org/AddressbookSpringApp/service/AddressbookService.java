package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.builder.AddressbookBuilder;
import com.org.AddressbookSpringApp.constant.ExceptionConstant;
import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.exception.AddressbookException;
import com.org.AddressbookSpringApp.model.AddressbookData;
import com.org.AddressbookSpringApp.repository.IAddressbookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressbookService implements IAddressbookService {

    @Autowired
    private IAddressbookRepository addressbookRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AddressbookBuilder addressbookBuilder;

    @Override
    public List<AddressbookDTO> getAddressbookData() {
        return addressbookRepository.findAll().stream()
                .map(addressBookDO -> modelMapper.map(addressBookDO, AddressbookDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public AddressbookData getAddressbookDataById(int id) {
        return addressbookRepository.findById(id).
                orElseThrow(() -> new AddressbookException("Id: " + id +" does not exists.Please write a correct empId"));
    }

    @Override
    public AddressbookDTO addAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = addressbookBuilder.buildDTO(addressbookDTO);
        addressbookData = addressbookRepository.save(addressbookData);
        addressbookDTO.setId(addressbookData.getId());
        return addressbookDTO;
    }

    @Override
    public AddressbookDTO updateAddressbookData(int id, AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = addressbookRepository.findById(id).
                orElseThrow(() -> new AddressbookException(ExceptionConstant.ID_NOT_FOUND.getMessage()));
        BeanUtils.copyProperties(addressbookDTO, addressbookData);
        return addressbookDTO;
    }

    @Override
    public void deleteAddressbookData(int id) {
        AddressbookData addressbookData = this.getAddressbookDataById(id);
        addressbookRepository.delete(addressbookData);
    }
}