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

import ${package}.controllers.${mainEntity}Controller;
import ${package}.controllers.DAOException;
import ${package}.dto.${mainEntity}DTO;
import ${package}.dto.MessageDTO;
import ${package}.entities.${mainEntity};
import ${package}.mapper.${mainEntity}Mapper;
import ${package}.rest.${mainEntity}Resource;

@ApplicationScoped
@Path("${mainEntity}/v1")
public class ${mainEntity}ResourceService implements ${mainEntity}Resource {

    @Inject private Logger logger;

    @Inject private ${mainEntity}Controller ${mainEntity}Controller;

    @Inject private ${mainEntity}Mapper ${mainEntity}Mapper;

    public Response find${mainEntity}(Integer id) {
        logger.debug("find() entry.");

        if (id == null) {
                return Response.status(500).entity(new MessageDTO("The provided ID is null.")).build();
        }

        ${mainEntity}DTO ${mainEntity} = ${mainEntity}Mapper.map(${mainEntity}Controller.find(id));

        if(${mainEntity} == null) {
                return Response.status(404).entity(new MessageDTO("The provided ID has no match in the database.")).build();
        }

        logger.debug("find() exit.");
        return Response.status(200).entity(${mainEntity}).build();
    }

    public Response findAll${mainEntity}s() {
        logger.debug("findAll() entry.");

        List<${mainEntity}DTO> list${mainEntity}s = new ArrayList<>();
        for(${mainEntity} a : this.${mainEntity}Controller.findAll()) {
            list${mainEntity}s.add(${mainEntity}Mapper.map(a));
        }

        logger.debug("findAll() exit.");
        return Response.status(200).entity(list${mainEntity}s).build();
    }

    public Response create${mainEntity}(${mainEntity}DTO entity) {
        try {
            this.${mainEntity}Controller.create(${mainEntity}Mapper.map(entity));
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(200).entity(new MessageDTO("${mainEntity} has been updated.")).build();
    }

    public Response edit${mainEntity}(Integer id, ${mainEntity}DTO entity) {
        try {
                entity.setId(id);
                this.${mainEntity}Controller.update(${mainEntity}Mapper.map(entity));
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(200).entity(new MessageDTO("${mainEntity} has been updated.")).build();
    }

    public Response delete${mainEntity}(Integer id) {
        try {
                this.${mainEntity}Controller.delete(id);
        } catch (DAOException daoEx) {
                return Response.status(404).entity(new MessageDTO(daoEx.getMessage())).build();
        } catch (Exception ex) {
                return Response.status(500).entity(new MessageDTO(ex.getMessage())).build();
        }
        return Response.status(204).build();
    }

}
