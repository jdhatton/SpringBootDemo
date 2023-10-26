package org.jd.domain.feign;

import org.jd.domain.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "address", url = "${data-processing.url}/address")
public interface AddressClient {

    @PostMapping("format")
    AddressDto format(@RequestBody AddressDto addressDto);

}
