#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import ${package}.controllers.${symbol_dollar}{mainEntity}Controller;
import ${package}.controllers.DAOException;
import ${package}.dto.${symbol_dollar}{mainEntity}DTO;
import ${package}.dto.MessageDTO;
import ${package}.entities.${symbol_dollar}{mainEntity};
import ${package}.entities.${symbol_dollar}{mainEntity};
import ${package}.entities.${symbol_dollar}{mainEntity};
import ${package}.mapper.${symbol_dollar}{mainEntity}Mapper;
import ${package}.rest.${symbol_dollar}{mainEntity}Resource;

@ApplicationScoped
@Path("${symbol_dollar}{mainEntity}/v1")
public class ${symbol_dollar}{mainEntity}ResourceService implements ${symbol_dollar}{mainEntity}Resource {

    @Inject private Logger logger;

    @Inject private ${symbol_dollar}{mainEntity}Controller ${symbol_dollar}{mainEntity}Controller;

    @Inject private ${symbol_dollar}{mainEntity}Mapper ${symbol_dollar}{mainEntity}Mapper;

    public Response find${symbol_dollar}{mainEntity}(Integer id) {
        logger.debug("find() entry.");

        if (id == null) {
                return Response.status(500).entity(new MessageDTO("The provided ID is null.")).build();
        }

        ${symbol_dollar}{mainEntity}DTO ${symbol_dollar}{mainEntity} = ${symbol_dollar}{mainEntity}Mapper.map(${symbol_dollar}{mainEntity}Controller.find(id));

        if(${symbol_dollar}{mainEntity} == null) {
                return Response.status(404).entity(new MessageDTO("The provided ID has no match in the database.")).build();
        }

        logger.debug("find() exit.");
        return Response.status(200).entity(${symbol_dollar}{mainEntity}).build();
    }

    public Response findAll${symbol_dollar}{mainEntity}s() {
        logger.debug("findAll() entry.");

        List<${symbol_dollar}{mainEntity}DTO> list${symbol_dollar}{mainEntity}s = new ArrayList<>();
        for(${symbol_dollar}{mainEntity} a : this.${symbol_dollar}{mainEntity}Controller.findAll()) {
            list${symbol_dollar}{mainEntity}s.add(${symbol_dollar}{mainEntity}Mapper.map(a));
        }

        logger.debug("findAll() exit.");
        return Response.status(200).entity(list${symbol_dollar}{mainEntity}s).build();
    }

    public Response create${mainEntity}(${mainEntity}DTO entity) {
        try {
            this.${symbol_dollar}{mainEntity}Controller.create(${symbol_dollar}{mainEntity}Mapper.map(entity));
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(200).entity(new MessageDTO("${symbol_dollar}{mainEntity} has been updated.")).build();
    }

    public Response edit${symbol_dollar}{mainEntity}(Integer id, ${symbol_dollar}{mainEntity}DTO entity) {
        try {
                entity.setId(id);
                this.${symbol_dollar}{mainEntity}Controller.update(${symbol_dollar}{mainEntity}Mapper.map(entity));
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(200).entity(new MessageDTO("${symbol_dollar}{mainEntity} has been updated.")).build();
    }

    public Response delete${symbol_dollar}{mainEntity}(Integer id) {
        try {
                this.${symbol_dollar}{mainEntity}Controller.delete(id);
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(204).build();
    }

}
