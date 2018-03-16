package org.op.pers.entity.misc;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

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
import org.hibernate.annotations.Type;
import org.op.pers.util.PersUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activation_token")
public class ActivationToken implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3963664610667271558L;

    private static final int EXPIRATION = 60 * 24;

    @Id
    @Column(name = "token_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    private long tockenId;

    @Column(name = "token")
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersUser user;

    @Column(name = "expire")
    @Type(type = "timestamp")
    private Timestamp expire;

    @Column(name = "verified")
    private boolean verified;

    public ActivationToken() {
        super();
    }

    public ActivationToken(PersUser user) {
        super();
        this.token = PersUtils.getUUID();
        this.user = user;
        this.expire = calculateExpiryDate(EXPIRATION);
        this.verified = false;
    }

    private Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Timestamp(cal.getTime().getTime());
    }

    public boolean isExpired() {
        long current = System.currentTimeMillis();
        long expiration = expire.getTime();
        return current > expiration;
    }

    public void reset() {
        this.expire = calculateExpiryDate(EXPIRATION);
        this.verified = false;
        this.token = PersUtils.getUUID();
    }

}
