package org.jd.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NoteDto {
    private Long id;
    private String value;
    private String company;
    private String createdBy;
    private String createdByFullName;
    private ZonedDateTime createDate;
    private ZonedDateTime updateDate;
}
