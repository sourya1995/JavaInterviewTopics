package AWS;

import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("/api/v2")
public class DocumentController {
    private static String bucketName = "whatever";

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA)
    public URL uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String keyName = file.getOriginalFilename();

        AWSCredentials credentials = new BasicAWSCredentials();
        AmazonS3Client client = new AmazonS3Client(credentials);
        try {
            System.out.println("uploading file " + name);
            s3client.putObject(new PutObjectRequest(bucketName, keyName, is, new ObjectMetadata()));
            URL url = s3client.generatePresignedURL(bucketName, keyName, Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)));
            return url;

        }catch(AmazonServiceException e) {
            e.getMessage();
            e.getStatusCode();
            e.getErrorCode();
        } catch(AmazonClientException e) {
            System.out.println("Error message" + e.getMessage());
        }

        return null;
    }
}
