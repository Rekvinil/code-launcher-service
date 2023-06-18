package com.vkr.codelauncherservice.launcher;

import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.data.web.FileListResult;

public interface ICodeLauncher {
    IResult launch(FileListResult fileListResult);
}
