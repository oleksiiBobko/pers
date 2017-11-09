package org.op.pers.entity.game;

import javax.persistence.Entity;
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
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "empireId")
    private Empire empire;

    private int position;

}
