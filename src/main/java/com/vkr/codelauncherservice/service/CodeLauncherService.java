package com.vkr.codelauncherservice.service;

import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.launcher.ICodeLauncher;

public class CodeLauncherService {
    private ICodeLauncher codeLauncher;

    public CodeLauncherService(ICodeLauncher codeLauncher) {
        this.codeLauncher = codeLauncher;
    }

    public IResult launch() {
        return codeLauncher.launch();
    }

}
