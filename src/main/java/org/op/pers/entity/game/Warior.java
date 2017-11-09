package org.op.pers.entity.game;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "warior")
public class Warior {

    @Id
    @GeneratedValue
    private long wariorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empireId")
    private Empire empire;

    private int healthPoint;

    private int magic;

    private int level;

}
