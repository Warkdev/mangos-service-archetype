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

import ${package}.dto.${symbol_dollar}{mainEntity}DTO;

public interface ${symbol_dollar}{mainEntity}Resource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retrieves an ${symbol_dollar}{mainEntity} given the id",
        description = "This API is retrieving the ${symbol_dollar}{mainEntity} with the given from the database."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "The ${symbol_dollar}{mainEntity}", content = @Content(
                        mediaType = "application/json", schema = @Schema(implementation = ${symbol_dollar}{mainEntity}DTO.class)
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${symbol_dollar}{mainEntity} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected event occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response find${symbol_dollar}{mainEntity}(@PathParam("id") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retrieves all ${symbol_dollar}{mainEntity}s",
        description = "This API is retrieving all ${symbol_dollar}{mainEntity}s from the database."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "A list of ${symbol_dollar}{mainEntity}s", content = @Content(
                        mediaType = "application/json", schema = @Schema(implementation = ${symbol_dollar}{mainEntity}DTO.class, description = "A list of ${symbol_dollar}{mainEntity}s")
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response findAll${symbol_dollar}{mainEntity}s();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Register a new ${symbol_dollar}{mainEntity}",
        description = "This API is registering a new ${symbol_dollar}{mainEntity} based on the provided input."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "201", description = "The ${symbol_dollar}{mainEntity} has been registered", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response create${mainEntity}(${mainEntity}DTO entity);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edit an ${symbol_dollar}{mainEntity}",
        description = "This API is updating an existing ${symbol_dollar}{mainEntity} based on the provided input."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "The ${symbol_dollar}{mainEntity} has been updated", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${symbol_dollar}{mainEntity} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response edit${symbol_dollar}{mainEntity}(@PathParam("id") Integer id, ${symbol_dollar}{mainEntity}DTO entity);

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an ${symbol_dollar}{mainEntity}",
        description = "This API is deleting an existing ${symbol_dollar}{mainEntity} based on the provided id."
                + "It will also delete the bans for this ${symbol_dollar}{mainEntity}, the link with the realms and the warden logs"
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "204", description = "The ${symbol_dollar}{mainEntity} has been deleted", content = @Content(
                        mediaType = "application/json"
                )
            ),
            @APIResponse(responseCode = "400", description = "Error with the request"),
            @APIResponse(responseCode = "404", description = "${symbol_dollar}{mainEntity} not found"),
            @APIResponse(responseCode = "500", description = "An unexpected even occured")
        }
    )
    @Tag(name = "${symbol_dollar}{mainEntity}")
    public Response delete${symbol_dollar}{mainEntity}(@PathParam("id") Integer id);

}
