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

import ${package}.entities.${symbol_dollar}{mainEntity};
import ${package}.mapper.${symbol_dollar}{mainEntity}Mapper;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;

@ApplicationScoped
public class ${symbol_dollar}{mainEntity}Controller {
    @Inject private Logger logger;

    @PersistenceContext(name = "AUTH_PU")
    private EntityManager em;

    @Inject private ${symbol_dollar}{mainEntity}Mapper mapper;

    
    }
