package com.vkr.codelauncherservice.service;

import com.vkr.codelauncherservice.data.web.DownloadProjectInfo;
import com.vkr.codelauncherservice.data.web.FileListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Slf4j
public class ProjectDownloadService {

    private String dataStorageServiceLink = "http://localhost:3000/api/files";
    private String dataStorageServiceGetFilesEndpoint = "/getFiles";

    private RestTemplate restTemplate;

    public FileListResult downloadFromS3Storage(DownloadProjectInfo downloadProjectInfo) {

        StringBuilder sb = new StringBuilder();
        sb.append(dataStorageServiceLink);
        sb.append(dataStorageServiceGetFilesEndpoint);
        ResponseEntity<FileListResult> responseEntity = restTemplate.postForEntity(sb.toString(), downloadProjectInfo, FileListResult.class);

        FileListResult fileListResult = responseEntity.getBody();

        for (String file : fileListResult.getFileList())
            downloadFromS3Storage(file);

        FileListResult fileListResult1 = new FileListResult();
        fileListResult1.setUserId(downloadProjectInfo.userId);
        fileListResult1.setProjectName(downloadProjectInfo.projectName);
        fileListResult1.setFileList(new ArrayList<String>());

        return fileListResult1;
    }

    private void downloadFromS3Storage(String fileLink){
//        AmazonS3 s3Client = s3AuthenticationService.getRequesterS3Client(requesterHost);
//        if(getFilesCount() == 1) {
//            try {
//                S3Object o = s3Client.getObject(requesterBucket, path);
//                S3ObjectInputStream s3is = o.getObjectContent();
//                FileOutputStream fos = new FileOutputStream(localPath.toFile());
//                byte[] read_buf = new byte[1024];
//                int read_len;
//                while ((read_len = s3is.read(read_buf)) > 0) {
//                    fos.write(read_buf, 0, read_len);
//                }
//                s3is.close();
//                fos.close();
//                filesList.add(localPath);
//            } catch (Exception e) {
//                log.error("Can't download file from s3 storage", e);
//            }
//        } else {
//            TransferManager transferManager = TransferManagerBuilder.standard().withS3Client(s3Client).build();
//            try {
//                MultipleFileDownload download = transferManager.downloadDirectory(requesterBucket, path, localPath.getParent().toFile());
//                download.waitForCompletion();
//                addFiles(localPath.toFile());
//            } catch (Exception e){
//                log.error("Can't download directory from s3 storage", e);
//            }
//        }
    }
}
