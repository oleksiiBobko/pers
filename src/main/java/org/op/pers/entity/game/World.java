package org.op.pers.entity.game;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "world")
public class World implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5256401368602271070L;

    @Id
    @GeneratedValue
    @Column(name = "worldid")
    private long worldId;

    private String name;

    private int width;

    private int height;

    @OneToMany(targetEntity = Empire.class, mappedBy = "world", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<Empire> empires = new HashSet<>();

}
