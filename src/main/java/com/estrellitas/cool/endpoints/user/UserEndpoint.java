package com.estrellitas.cool.endpoints.user;

import com.estrellitas.cool.generate.*;
import com.estrellitas.cool.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = "http://lasestrellitas.com/example",
            localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserByIdRequest(@RequestPayload GetUserByIdRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setUser(userService.getUserById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = "http://lasestrellitas.com/example",
            localPart = "createUserRequest")
    @ResponsePayload
    public GetUserByIdResponse createUserRequest(@RequestPayload CreateUserRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setUser(userService.createUser(request.getId(), request.getNames(), request.getLastname(), request.getEmail(), request.getAge(), request.getPassword(), request.getGender()));
        return response;
    }


    @PayloadRoot(namespace = "http://lasestrellitas.com/example",
            localPart = "getUserByEmailRequest")
    @ResponsePayload
    public GetUserByEmailResponse getUserByEmailRequest(@RequestPayload GetUserByEmailRequest request) {
        GetUserByEmailResponse response = new GetUserByEmailResponse();
        response.setUser(userService.getUserByEmail(request.getEmail()));
        return response;
    }

    @PayloadRoot(namespace = "http://lasestrellitas.com/example",
            localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUserRequest(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse res = new DeleteUserResponse();
        res.setMessage(userService.deleteUser(request.getEmail(), request.getPassword()));
        return res;
    }
}
