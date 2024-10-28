package com.propiconnect.inmoshare.user.domain.services;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByIdQuery query);
}
