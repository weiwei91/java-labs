package discovery.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryProviderApplication.class, args);
    }

    @RestController
    static class TestController {

        @GetMapping("/echo")
        public String echo(String name) {
            return "echo:provider:" + name;
        }

        @PostMapping("/postEcho")
        public String postEcho(String name) {
            return "postEcho:provider:" + name;
        }

    }

}
