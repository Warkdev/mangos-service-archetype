#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import ${package}.dto.${mainEntity}DTO;

public interface ${mainEntity}Resource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retrieves an ${mainEntity.toLowerCase()} given the id",
        description = "This API is retrieving the ${mainEntity.toLowerCase()} with the given from the database."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "The ${mainEntity.toLowerCase()}", content = @Content(
                        mediaType = "application/json", schema = @Schema(implementation = ${mainEntity}DTO.class)
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${mainEntity.toLowerCase()} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected event occured")
        }
    )
    @Tag(name = "${mainEntity.toLowerCase()}")
    public Response find${mainEntity}(@PathParam("id") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retrieves all ${mainEntity}s",
        description = "This API is retrieving all ${mainEntity}s from the database."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "A list of ${mainEntity}s", content = @Content(
                        mediaType = "application/json", schema = @Schema(implementation = ${mainEntity}DTO.class, description = "A list of ${mainEntity}s")
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${mainEntity}")
    public Response findAll${mainEntity}s();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Register a new ${mainEntity}",
        description = "This API is registering a new ${mainEntity} based on the provided input."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "201", description = "The ${mainEntity} has been registered", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${mainEntity}")
    public Response create${mainEntity}(${mainEntity}DTO entity);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edit an ${mainEntity}",
        description = "This API is updating an existing ${mainEntity} based on the provided input."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "The ${mainEntity} has been updated", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${mainEntity} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${mainEntity}")
    public Response edit${mainEntity}(@PathParam("id") Integer id, ${mainEntity}DTO entity);

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an ${mainEntity}",
        description = "This API is deleting an existing ${mainEntity} based on the provided id."
                + "It will also delete the bans for this ${mainEntity}, the link with the realms and the warden logs"
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "204", description = "The ${mainEntity} has been deleted", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${mainEntity} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response delete${symbol_dollar}{mainEntity}(@PathParam("id") Integer id);

}
