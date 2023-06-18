package com.vkr.codelauncherservice.controller;

import com.vkr.codelauncherservice.data.RequestType;
import com.vkr.codelauncherservice.data.web.DownloadProjectInfo;
import com.vkr.codelauncherservice.data.web.FileListResult;
import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.data.web.UserProjectInfo;
import com.vkr.codelauncherservice.service.CodeLauncherService;
import com.vkr.codelauncherservice.service.ProjectDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/codeLauncher")
@Slf4j
public class CodeLauncherController {
    private CodeLauncherService codeLauncherService;
    private ProjectDownloadService projectDownloadService;

    public CodeLauncherController(CodeLauncherService codeLauncherService, ProjectDownloadService projectDownloadService) {
        this.codeLauncherService = codeLauncherService;
        this.projectDownloadService = projectDownloadService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/launchProject")
    public IResult getProjectList(@RequestBody UserProjectInfo userProjectInfo) {
        log.info("launchProject");
        DownloadProjectInfo downloadProjectInfo = new DownloadProjectInfo();

        StringBuilder sb = new StringBuilder();
        sb.append(new Random().nextInt(100));
        downloadProjectInfo.id = sb.toString();
        downloadProjectInfo.projectName = userProjectInfo.projectName;
        downloadProjectInfo.userId = userProjectInfo.userId;
        downloadProjectInfo.requestType = RequestType.REQUEST_LAUNCH_PROJECT;

        FileListResult fileListResult = projectDownloadService.downloadFromS3Storage(downloadProjectInfo);

        return codeLauncherService.launch(fileListResult);
    }


}
