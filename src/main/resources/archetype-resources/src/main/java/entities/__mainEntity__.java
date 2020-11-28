#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="${mainEntity.toLowerCase()}"
)

@NamedQueries({
    @NamedQuery(name = "${mainEntity}.findAll", query = "SELECT a FROM ${mainEntity} ${mainEntity.toLowerCase()[0]}"),
    @NamedQuery(name = "${mainEntity}.findById", query = "SELECT a FROM ${mainEntity} ${mainEntity.toLowerCase()[0]} where ${mainEntity.toLowerCase()[0]}.id = :id"),
})
/**
 * This class represent an entity ${mainEntity} from the Realm Database.
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class ${mainEntity} implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
