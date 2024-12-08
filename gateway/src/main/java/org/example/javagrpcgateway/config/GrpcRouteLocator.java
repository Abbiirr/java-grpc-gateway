@Configuration
public class GrpcRouteLocator {

    @Bean
    public RouteDefinitionRepository grpcRoutes() {
        return new InMemoryRouteDefinitionRepository();
    }

    @Bean
    public RouteLocator grpcRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("grpc-route", r -> r.path("/api/**")
                        .filters(f -> f.filter(new GrpcAuthorizationFilter()))
                        .uri("grpc://localhost:9090")) // Target gRPC server URI
                .build();
    }
}
