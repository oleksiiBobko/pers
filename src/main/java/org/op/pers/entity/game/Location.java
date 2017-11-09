package org.op.pers.entity.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private long locationId;

//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Moving movingFrom;
//
//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Moving movingTo;

    private int x;

    private int y;

}
