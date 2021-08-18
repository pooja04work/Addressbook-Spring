package com.org.AddressbookSpringApp.builder;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressbookBuilder {
        public AddressbookData buildDTO(AddressbookDTO addressbookDTO) {
            AddressbookData addressBookData = new AddressbookData();
            BeanUtils.copyProperties(addressbookDTO, addressBookData);
            return addressBookData;
        }
}
