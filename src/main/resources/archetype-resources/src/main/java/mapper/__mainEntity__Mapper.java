#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ${package}.entities.${mainEntity};
import ${package}.dto.${mainEntity}DTO;

@Mapper(componentModel = "cdi")
public interface ${mainEntity}}Mapper {

    ${mainEntity}DTO map(${mainEntity} entity);

    ${mainEntity} map(${mainEntity}DTO dto);

    default Date map(Long value) {
        return new Date(value);
    }

    default Long map(Date date) {
        return date.getTime();
    }
}
