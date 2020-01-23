# A custom Keycloak User Storage Provider

This example demonstrates how to deploy custom Keycloak User storage provider.
The storage provider is implemented in the `jar-module` project.

This example is based on [keycloak-user-spi-demo](https://github.com/dasniko/keycloak-user-spi-demo) by [@dasniko](https://github.com/dasniko).

This example build the plugin, copy to Keycloak image and run it.

## Build
Build the keycloak docker with the custom provider

    docker-compose build

## Start Keycloak
    
    docker-compose up
