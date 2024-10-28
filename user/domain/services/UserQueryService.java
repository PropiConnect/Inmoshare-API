package com.propiconnect.inmoshare.user.domain.services;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByUserIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByUserIdQuery query);
}
