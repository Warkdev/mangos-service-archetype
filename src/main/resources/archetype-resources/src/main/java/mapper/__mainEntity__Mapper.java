#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ${package}.entities.${symbol_dollar}{mainEntity};
import ${package}.dto.${symbol_dollar}{mainEntity}DTO;

@Mapper(componentModel = "cdi")
public interface ${symbol_dollar}{mainEntity}}Mapper {

    ${symbol_dollar}{mainEntity}DTO map(${symbol_dollar}{mainEntity} ${symbol_dollar}{mainEntity});

    ${symbol_dollar}{mainEntity} map(${symbol_dollar}{mainEntity}DTO dto);

    default Date map(Long value) {
        return new Date(value);
    }

    default Long map(Date date) {
        return date.getTime();
    }
}
