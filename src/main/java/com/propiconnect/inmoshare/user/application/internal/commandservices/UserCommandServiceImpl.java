package com.propiconnect.inmoshare.user.application.internal.commandservices;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.commands.CreateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.enums.UserType; // Import de UserType
import com.propiconnect.inmoshare.user.domain.services.UserCommandService;
import com.propiconnect.inmoshare.user.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        var user = new User(command);
        var createdUser = userRepository.save(user);
        return Optional.of(createdUser);
    }

    @Override
    public Optional<User> update(UpdateUserCommand command) {
        return userRepository.findById(command.sourceId()).map(existingUser -> {
            existingUser.setName(command.name());
            existingUser.setUsername(command.username());
            existingUser.setPassword(command.password());
            existingUser.setPhone(command.phone());
            existingUser.setEmail(command.email());
            existingUser.setAddress(command.address());
            existingUser.setUserType(command.userType());

            userRepository.save(existingUser);
            return existingUser;
        });
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> updateUserType(Long userId, UserType userType) {
        return userRepository.findById(userId).map(user -> {
            user.setUserType(userType);
            userRepository.save(user);
            return user;
        });
    }
}
