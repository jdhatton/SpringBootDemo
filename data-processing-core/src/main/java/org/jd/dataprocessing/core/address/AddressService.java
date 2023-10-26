package org.jd.dataprocessing.core.address;

import lombok.RequiredArgsConstructor;
import org.jd.domain.dto.AddressDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {
    public AddressDto format(AddressDto addressDto) {
        return addressDto.getPostalCode() != null ? doSomeCoolStuff(addressDto) : addressDto;
    }

    private AddressDto doSomeCoolStuff(AddressDto addressDto) {
        return addressDto;
    }

}
