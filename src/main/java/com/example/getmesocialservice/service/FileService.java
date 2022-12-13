package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.getmesocialservice.model.imageFile;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.io.IOException;
import java.util.Date;

@Service
public class FileService {
    public imageFile upload(MultipartFile file) {
        Date d = new Date();
        String imageID = Long.toString(file.getSize()) + Integer.toString(d.getSeconds()) + Integer.toString(d.getMinutes()) + Integer.toString(d.getHours());

        imageFile uploadedFile = new imageFile(imageID,file.getContentType(),file.getName(),file.getOriginalFilename(),"Tom");
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4E37VXBOTHR7X4PR","DHmHXV0Dl4CqjXJyKndA2K1YKqPv/2I3UCG8+4Wm");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("gmh-backend-assignment7",file.getOriginalFilename(),file.getInputStream(),metadata);

            MongoClient client = MongoClients.create("mongodb+srv://TomMilton:Hiccups123@cluster0.zuodxrk.mongodb.net/?retryWrites=true&w=majority");

            //DB db = mongoClient.getDB("GMH_Frontend_A7\n" + ".GMH_Frontend_A7");

            return uploadedFile;

        } catch (AmazonServiceException | IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4E37VXBOTHR7X4PR","DHmHXV0Dl4CqjXJyKndA2K1YKqPv/2I3UCG8+4Wm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();

        return s3.getObject("gmh-backend-assignment7",key);
    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA4E37VXBOTHR7X4PR","DHmHXV0Dl4CqjXJyKndA2K1YKqPv/2I3UCG8+4Wm");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();
        s3.deleteObject("gmh-backend-assignment7",key);

    }
}
//gmh-backend-assignment7