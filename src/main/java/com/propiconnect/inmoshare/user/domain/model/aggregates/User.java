package com.propiconnect.inmoshare.user.domain.model.aggregates;

import com.propiconnect.inmoshare.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.propiconnect.inmoshare.user.domain.model.commands.CreateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends AuditableAbstractAggregateRoot<User> {

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
    private String phone;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String address;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private UserType userType;

    protected User() {
        this.name = Strings.EMPTY;
        this.username = Strings.EMPTY;
        this.phone = Strings.EMPTY;
        this.email = Strings.EMPTY;
        this.password = Strings.EMPTY;
        this.address = Strings.EMPTY;
        this.userType = UserType.FREE; // Valor por defecto
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.username = command.username();
        this.phone = command.phone();
        this.email = command.email();
        this.password = command.password();
        this.address = command.address();
        this.userType = UserType.FREE; // Valor por defecto
    }
}
