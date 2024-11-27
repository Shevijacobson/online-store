//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequest;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//
//@Configuration
//public class RestTemplateConfig {
//
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
//            @Override
//            public org.springframework.http.client.ClientHttpResponse intercept(
//                    ClientHttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//                // מוסיף את הכותרת Authorization עם הטוקן
//                request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + JwtUtil.getCurrentToken());
//                return execution.execute(request, body);
//            }
//        });
//        return restTemplate;
//    }
//}
//
