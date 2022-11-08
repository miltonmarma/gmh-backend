package com.example.getmesocialservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase() throws IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        org.springframework.core.io.Resource resource = resolver.getResource("classpath:gmh-myphotoapp-firebase-adminsdk-6ykip-62f442ef07.json");

        FileInputStream serviceAccount = new FileInputStream(resource.getFile());

        FirebaseOptions options = ( new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)))
                .build();

        return FirebaseApp.initializeApp(options);
    }

}