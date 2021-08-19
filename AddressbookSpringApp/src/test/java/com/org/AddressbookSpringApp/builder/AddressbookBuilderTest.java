package com.org.AddressbookSpringApp.builder;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddressbookBuilderTest {

    @InjectMocks
    private AddressbookBuilder addressbookBuilder;

    @Test
    public void buildDOTest() {
        AddressbookDTO addressbookDTO = new AddressbookDTO();
        addressbookDTO.setFirstName("Pallabi");
        addressbookDTO.setLastName("Rani");
        AddressbookData addressBookData = addressbookBuilder.buildDTO(addressbookDTO);
        assertEquals("Pallabi", addressBookData.getFirstName());
        assertEquals("Rani", addressBookData.getLastName());
    }
}
