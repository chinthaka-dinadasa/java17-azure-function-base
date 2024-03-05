package com.javatodev.app;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

public class CustomerAPI {

    @FunctionName("readCustomers")
    public HttpResponseMessage readCustomers(@HttpTrigger(name = "req",
        methods = {HttpMethod.GET},
        route = "customers",
        authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
                                             final ExecutionContext context) {
        context.getLogger().info("Reading customers API triggered.");
        return request.createResponseBuilder(HttpStatus.OK).body("Hello from customers Reading API").build();
    }

    @FunctionName("readCustomerById")
    public HttpResponseMessage readCustomerById(@HttpTrigger(name = "req",
        methods = {HttpMethod.GET},
        route = "customers/{id}",
        authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request, final ExecutionContext context, @BindingName("id") String id) {
        context.getLogger().info("Reading customer by id API triggered.");
        return request.createResponseBuilder(HttpStatus.OK).body("Reading customer by id API triggered." + id).build();
    }

}
