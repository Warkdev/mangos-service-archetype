#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import java.util.Date;
import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import ${package}.entities.${mainEntity};
import ${package}.mapper.${mainEntity}Mapper;

@ApplicationScoped
public class ${mainEntity}Controller {
    @Inject private Logger logger;

    #if($persistenceUnits.contains("AUTH"))
@PersistenceContext(unitName = "AUTH_PU")
    private EntityManager emAuth;
    #end

    #if($persistenceUnits.contains("CHAR"))
@PersistenceContext(unitName = "CHAR_PU")
    private EntityManager emChar;
    #end

    #if($persistenceUnits.contains("WORLD"))
@PersistenceContext(unitName = "WORLD_PU")
    private EntityManager emWorld;
    #end

    #if($persistenceUnits.contains("DBC"))
@PersistenceContext(unitName = "DBC_PU")
    private EntityManager emDbc;
    #end

    @Inject private ${mainEntity}Mapper mapper;

    }
