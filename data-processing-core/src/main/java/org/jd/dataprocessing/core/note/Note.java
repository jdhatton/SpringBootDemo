package org.jd.dataprocessing.core.note;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "note", schema = "jd")
public class Note {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String company;
    @CreatedBy
    private String createdBy;
    private String createdByFullName;

    @CreatedDate
    private ZonedDateTime createDate;
    @Column(
            name = "modified_date"
    )
    @LastModifiedDate
    private ZonedDateTime updateDate;

    private String value;
}
