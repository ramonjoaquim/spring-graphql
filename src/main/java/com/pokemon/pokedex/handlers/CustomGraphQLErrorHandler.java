package com.pokemon.pokedex.handlers;

import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrors) {
        return graphQLErrors.stream().map(this::handleGraphQLError).collect(Collectors.toList());
    }

    private GraphQLError handleGraphQLError(GraphQLError error) {
       return error;
    }
}
