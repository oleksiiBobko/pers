package org.op.pers.entity.game;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "alliance")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="allianceId")
public class Alliance implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2682950456192133262L;

    @Id
    @GeneratedValue
    @Column(name = "allianceid")
    private long allianceId;

    private String name;

    @OneToMany(targetEntity = Empire.class, mappedBy = "alliance",
    fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<Empire> empires;

}
