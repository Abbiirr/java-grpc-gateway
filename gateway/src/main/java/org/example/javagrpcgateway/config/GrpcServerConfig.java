@Configuration
public class GrpcServerConfig {

    @Bean
    public GrpcServerConfigurer serverConfigurer(GrpcAuthorizationInterceptor interceptor) {
        return serverBuilder -> serverBuilder.intercept(interceptor);
    }
}
