package com.propiconnect.inmoshare.user.interfaces.rest;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByIdQuery;
import com.propiconnect.inmoshare.user.domain.services.UserCommandService;
import com.propiconnect.inmoshare.user.domain.services.UserQueryService;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.CreateUserResource;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UserResource;
import com.propiconnect.inmoshare.user.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.propiconnect.inmoshare.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/inmoshare/user")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }


    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        Optional<User> user = userCommandService
                .handle(CreateUserCommandFromResourceAssembler.toCommandFromResource(resource));
        return user.map(source ->
                        new ResponseEntity<>(UserResourceFromEntityAssembler.toUserResource(source),CREATED))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }



    @GetMapping("{userId}")
    public ResponseEntity<UserResource> getUser(@PathVariable Long userId) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(userId));
        return user.map(source -> ResponseEntity.ok(UserResourceFromEntityAssembler.toUserResource(source)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    @PutMapping("{userId}")
    public ResponseEntity<UserResource> updateUser(
            @PathVariable Long userId,
            @RequestBody CreateUserResource resource) {
        UpdateUserCommand command = new UpdateUserCommand(
                userId,
                resource.name(),
                resource.username(),
                resource.password(),
                resource.subscription(),
                resource.userType()
        );

        Optional<User> updateUser = userCommandService.update(command);
        return updateUser.map(source ->
                        ResponseEntity.ok(UserResourceFromEntityAssembler.toUserResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(userId));
        if (user.isPresent()) {
            userCommandService.deleteById(userId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
