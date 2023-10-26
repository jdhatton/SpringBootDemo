package org.jd.dataprocessing.core.note;

import org.jd.domain.dto.NoteDto;
import org.mapstruct.Mapping;

import java.util.List;

@org.mapstruct.Mapper
public abstract class NoteMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "createdByFullName", source = "createdByFullName")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateDate", source = "updateDate")
    @Mapping(target = "value", source = "value")
    public abstract NoteDto toDto(Note note);

    public abstract List<NoteDto> toDtoList(List<Note> notes);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "createdByFullName", source = "createdByFullName")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "value", source = "value")
    public abstract Note fromDto(NoteDto note);

    public abstract List<Note> fromDtoList(List<NoteDto> notes);

}
