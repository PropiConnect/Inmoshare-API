package com.propiconnect.inmoshare.user.domain.services;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.commands.CreateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
    Optional<User> update(UpdateUserCommand command);
    void deleteById(Long userId);
}
