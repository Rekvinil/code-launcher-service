package com.vkr.codelauncherservice.service;

import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.data.web.FileListResult;
import com.vkr.codelauncherservice.launcher.ICodeLauncher;

public class CodeLauncherService {
    private ICodeLauncher codeLauncher;

    public CodeLauncherService(ICodeLauncher codeLauncher) {
        this.codeLauncher = codeLauncher;
    }

    public IResult launch(FileListResult fileListResult) {
        return codeLauncher.launch(fileListResult);
    }

}
