package org.op.pers.entity.game.resources;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.op.pers.entity.game.Empire;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "gold")
public class Gold implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5267096939024115348L;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "empire"))
    @GeneratedValue(generator = "generator")
    @Column(name = "goldid", unique = true, nullable = false)
    private long goldId;

    private long amount;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Empire empire;

}
