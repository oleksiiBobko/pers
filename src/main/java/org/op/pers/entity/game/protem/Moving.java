package org.op.pers.entity.game.protem;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.op.pers.entity.game.Location;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "moving")
public class Moving {

    @Id
    @GeneratedValue
    private long id;

    private long startTime;
    
    private long eta;

    @OneToOne(fetch = FetchType.EAGER)
    private Location from;

    @OneToOne(fetch = FetchType.EAGER)
    private Location to;

}
