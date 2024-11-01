package com.propiconnect.inmoshare.user.application.internal.queryservices;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByIdQuery;
import com.propiconnect.inmoshare.user.domain.services.UserQueryService;
import com.propiconnect.inmoshare.user.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }

}
