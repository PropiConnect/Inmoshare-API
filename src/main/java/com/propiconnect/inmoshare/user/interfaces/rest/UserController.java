package com.propiconnect.inmoshare.user.interfaces.rest;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import com.propiconnect.inmoshare.user.domain.model.commands.UpdateUserCommand;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByEmailAndPasswordQuery;
import com.propiconnect.inmoshare.user.domain.model.queries.GetUserByIdQuery;
import com.propiconnect.inmoshare.user.domain.services.UserCommandService;
import com.propiconnect.inmoshare.user.domain.services.UserQueryService;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.CreateUserResource;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UserBasicResource;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UserResource;
import com.propiconnect.inmoshare.user.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.propiconnect.inmoshare.user.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import com.propiconnect.inmoshare.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import com.propiconnect.inmoshare.user.interfaces.rest.resources.UpdateUserTypeResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        Optional<User> user = userCommandService
                .handle(CreateUserCommandFromResourceAssembler.toCommandFromResource(resource));
        return user.map(source ->
                        new ResponseEntity<>(UserResourceFromEntityAssembler.toUserResource(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("{userId}")
    public ResponseEntity<UserResource> getUser(@PathVariable Long userId) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(userId));
        return user.map(source -> ResponseEntity.ok(UserResourceFromEntityAssembler.toUserResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para actualizar los datos del usuario
    @PutMapping("{userId}")
    public ResponseEntity<UserResource> updateUser(
            @PathVariable Long userId,
            @RequestBody UserResource resource) {
        UpdateUserCommand command = UpdateUserCommandFromResourceAssembler.toCommand(userId, resource);
        Optional<User> updateUser = userCommandService.update(command);
        return updateUser.map(source ->
                        ResponseEntity.ok(UserResourceFromEntityAssembler.toUserResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un usuario por ID
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

    // PATCH Endpoint para actualizar solo el userType
    @PatchMapping("{userId}/userType")
    public ResponseEntity<UserResource> updateUserType(
            @PathVariable Long userId,
            @RequestBody UpdateUserTypeResource resource) {
        Optional<User> updatedUser = userCommandService.updateUserType(userId, resource.userType());
        return updatedUser.map(source ->
                        ResponseEntity.ok(UserResourceFromEntityAssembler.toUserResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para obtener el userId y username usando email y contraseña
    @PostMapping("/authenticate")
    public ResponseEntity<UserBasicResource> authenticateUser(@RequestParam String email, @RequestParam String password) {
        var query = new GetUserByEmailAndPasswordQuery(email, password);
        Optional<User> user = userQueryService.handle(query);
        return user.map(u -> ResponseEntity.ok(new UserBasicResource(u.getId(), u.getUsername())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


}
