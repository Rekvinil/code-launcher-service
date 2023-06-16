package com.vkr.codelauncherservice.controller;

import com.vkr.codelauncherservice.data.web.FileListResult;
import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.service.CodeLauncherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/codeLauncher")
@Slf4j
public class CodeLauncherController {
    private CodeLauncherService codeLauncherService;

    public CodeLauncherController(CodeLauncherService codeLauncherService) {
        this.codeLauncherService = codeLauncherService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/launchProject")
    public IResult getProjectList(@RequestBody FileListResult dataServiceRequest) {
        log.info("launchProject");
        return codeLauncherService.launch();
    }
}
