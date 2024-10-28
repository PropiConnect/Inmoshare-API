package com.propiconnect.inmoshare.user.domain.model.aggregates;


import com.propiconnect.inmoshare.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long userId;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String username;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String suscription;

    @Column
    @Getter
    @Setter
    private String userType;

    protected User() {
        this.name = Strings.EMPTY;
        this.username = Strings.EMPTY;
        this.password = Strings.EMPTY;
        this.suscription = Strings.EMPTY;
        this.userType = Strings.EMPTY;
    }

    public User(CreateUserCommand command){
        this.name = command.name();
        this.username = command.username();
        this.password = command.password();
        this.suscription = command.subscription();
        this.userType = command.userType();
    }
}
