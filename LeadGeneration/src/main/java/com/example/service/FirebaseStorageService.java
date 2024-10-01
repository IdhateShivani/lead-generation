//package com.example.service; 
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.UUID;
//
//@Service
//public class FirebaseStorageService {
//
//    private final Storage storage;
//    private final String bucketName = "leadgeneration-6f347.appspot.com"; // Your Firebase Storage bucket name
//
//    public FirebaseStorageService() throws IOException {
//        // Load the service account key
//        try (FileInputStream serviceAccountStream = new FileInputStream("src/main/resources/lead.json")) {
//            // Initialize Firebase Storage with the service account credentials
//            this.storage = StorageOptions.newBuilder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
//                    .setProjectId("eadgeneration-6f347") // Your Google Cloud Project ID
//                    .build()
//                    .getService();
//        }
//    }
//
//    public String uploadFile(MultipartFile file) throws IOException {
//        // Generate a unique file name
//        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//
//        // Create a BlobInfo object to define the blob's metadata
//        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
//                .setContentType(file.getContentType())
//                .build();
//
//        // Upload the file to Firebase Storage
//        storage.create(blobInfo, file.getBytes());
//
//        // Return the public URL for the uploaded file
//        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media", bucketName, fileName);
//    }
//
//	public static String uploadFile(byte image) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

package com.example.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    private final Storage storage;
    private final String bucketName = "leadgeneration-6f347.appspot.com"; // Your Firebase Storage bucket name

    public FirebaseStorageService() throws IOException {
        // Load the service account key
        try (FileInputStream serviceAccountStream = new FileInputStream("src/main/resources/lead.json")) {
            // Initialize Firebase Storage with the service account credentials
            this.storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                    .setProjectId("leadgeneration-6f347") // Your Google Cloud Project ID
                    .build()
                    .getService();
        }
    }

    // Method to upload the file to a specific folder
    public String uploadFile(MultipartFile file, String folderName) throws IOException {
        // Generate a unique file name
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        // Combine folder path and file name (e.g., "company form image/unique-filename.jpg")
        String fullPath = folderName + "/" + fileName;

        // Create a BlobInfo object to define the blob's metadata
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fullPath)
                .setContentType(file.getContentType())
                .build();

        // Upload the file to Firebase Storage
        storage.create(blobInfo, file.getBytes());

        // Return the public URL for the uploaded file
        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media", bucketName, fullPath);
    }

    public static String uploadFile(byte image) {
        return null; // Keeping this static method as per your structure
    }
}

