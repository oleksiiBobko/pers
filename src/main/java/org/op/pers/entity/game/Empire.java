package org.op.pers.entity.game;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.op.pers.entity.game.protem.Moving;
import org.op.pers.entity.game.protem.Reserach;
import org.op.pers.entity.game.resources.Food;
import org.op.pers.entity.game.resources.Gold;
import org.op.pers.entity.game.resources.Stone;
import org.op.pers.entity.game.resources.Wood;
import org.op.pers.entity.misc.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "empire")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empireId")
public class Empire implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7392192731420447980L;

    @Id
    @Column(name = "empireid")
    @GeneratedValue
    private long empireId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allianceid")
    private Alliance alliance;

    @OneToOne(mappedBy = "empire", cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "foodid")
    private Food food;

    @OneToOne(mappedBy = "empire", cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "goldid")
    private Gold gold;

    @OneToOne(mappedBy = "empire", cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "stoneid")
    private Stone stone;

    @OneToOne(mappedBy = "empire", cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "woodid")
    private Wood wood;

    @OneToMany(targetEntity = Building.class, mappedBy = "empire", fetch = FetchType.LAZY, cascade = {
            CascadeType.ALL })
    private Set<Building> buildings;

    @OneToMany(targetEntity = Mine.class, mappedBy = "empire", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<Mine> mines;

    @OneToMany(targetEntity = Forest.class, mappedBy = "empire", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<Forest> forests;

    @OneToMany(targetEntity = Reserach.class, mappedBy = "empire", fetch = FetchType.LAZY, cascade = {
            CascadeType.ALL })
    private List<Reserach> Reseraches;

    @OneToMany(targetEntity = Moving.class, mappedBy = "from", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Moving> movings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worldid")
    private World world;

}
