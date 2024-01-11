package artory.artory.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    private String env;
    
    @GetMapping("/hc")
    public ResponseEntity<?> healhtCheck(){
        Map<String, String> responseData = new HashMap<>();

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv(){
        return ResponseEntity.ok(env);
    }
}

