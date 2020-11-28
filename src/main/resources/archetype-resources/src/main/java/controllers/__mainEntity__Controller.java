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

    @Transactional
    /**
     * Creates an ${mainEntity.toLowerCase()} in the dabatase.
     * @param ${mainEntity.toLowerCase()} The ${mainEntity.toLowerCase()} to create.
     * @throws DAOException Send a DAOException if something happened during the data validation.
     */
    public void create(${mainEntity} ${mainEntity.toLowerCase()}) throws DAOException {
        logger.debug("create() entry.");
        // Add validations here

        em.persist(${mainEntity.toLowerCase()});
        logger.debug("create() exit.");
    }

    @Transactional
    /**
     * Updates an ${mainEntity} in the dabatase.
     * @param ${mainEntity} The ${mainEntity} to edit.
     * @throws DAOException Send a DAOException if something happened during the data validation.
     */
    public void update(${mainEntity} ${mainEntity.toLowerCase()}) throws DAOException {
        logger.debug("update() entry.");
        // Add validations here

        em.merge(${mainEntity.toLowerCase()});
        logger.debug("update() exit.");
    }

    /**
     * Delete an ${mainEntity} in the database. This method will also delete all links with the bans for this ${mainEntity}.
     * @param id The ID of the ${mainEntity} to be deleted.
     * @throws DAOException Send a DAOException if something happened during the data validation.
     */
    @Transactional
    public void delete(Integer id) throws DAOException {
        logger.debug("delete() entry.");

        ${mainEntity} ${mainEntity.toLowerCase()} = find(id);
        if(${mainEntity.toLowerCase()} == null) {
            logger.debug("delete() exit.");
            throw new DAOException("The ${mainEntity.toLowerCase()} doesn't exist");
        }

        em.remove(${mainEntity.toLowerCase()});

        logger.debug("delete() exit.");
    }

    /**
     * Retrieves an ${mainEntity.toLowerCase()} by its ID.
     * @param id The ID of the ${mainEntity.toLowerCase()}
     * @return The ${mainEntity.toLowerCase()} if found, null otherwise.
     */
    public ${mainEntity} find(Integer id) {
        logger.debug("find() entry.");
        try {
            ${mainEntity} ${mainEntity.toLowerCase()} = (${mainEntity}) em.createNamedQuery("${mainEntity}.findById").setParameter("id", id).getSingleResult();
            logger.debug("find() exit.");
            return ${mainEntity.toLowerCase()};
        } catch (NoResultException nre) {
            logger.debug("No ${mainEntity.toLowerCase()} found with this id.");
            logger.debug("find() exit.");
            return null;
        }
    }
    /**
     * Retrieves all ${mainEntity.toLowerCase()}s from the database.
     * @return A list of ${mainEntity}.
     */
    @SuppressWarnings("unchecked")
    public List<${mainEntity}> findAll() {
        return (List<${mainEntity}>) em.createNamedQuery("${mainEntity}.findAll").getResultList();
    }

    }
