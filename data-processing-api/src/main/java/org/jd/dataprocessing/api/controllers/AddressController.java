package org.jd.dataprocessing.api.controllers;

import lombok.RequiredArgsConstructor;
import org.jd.dataprocessing.core.address.AddressService;
import org.jd.domain.dto.AddressDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    /**
     * Not enough time to demonstrate the security features
     */

    @PostMapping("format")
    //@NoAuth(reason = "No underlying data is being updated by the method.")
    public AddressDto format(@RequestBody AddressDto addressDto) {
        return addressService.format(addressDto);
    }

}
