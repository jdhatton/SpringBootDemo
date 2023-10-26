package org.jd.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AddressDto {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String stateOrProvince;
    private String postalCode;
    private String countryCode;
}