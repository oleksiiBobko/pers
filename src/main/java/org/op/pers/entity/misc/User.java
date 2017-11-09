package org.op.pers.entity.misc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.op.pers.entity.game.Empire;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2837221441316782206L;

    @Id
    @GeneratedValue
    private long userId;

    private String name;

    private String password;

    private boolean active;

    @Size(min = 3, max = 32, message = "The login must be at least 5 characters long.")
    private String login;

    @Size(max = 32, message = "First name is too long.")
    private String firstName;

    @Size(max = 32, message = "Last name is too long.")
    private String lastName;

    @Email(regexp = "^((?!\\.).*)@(.*)$", message = "Incorrect email format")
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id")
    private ActivationToken token;

    @OneToMany(targetEntity = Empire.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Empire> empires = new ArrayList<>();

}
