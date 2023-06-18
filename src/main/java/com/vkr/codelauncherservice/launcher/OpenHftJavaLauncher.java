package com.vkr.codelauncherservice.launcher;

import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.data.Status;
import com.vkr.codelauncherservice.data.web.FileListResult;
import com.vkr.codelauncherservice.data.web.LaunchResult;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class OpenHftJavaLauncher implements ICodeLauncher {
    public IResult launch(FileListResult fileListResult) {
        LaunchResult result = new LaunchResult();
        result.userId = fileListResult.getUserId();
        result.projectName = fileListResult.getProjectName();
        try {
            for (String filePath : fileListResult.getFileList()) {
                File file = new File(filePath);
                String str = FileUtils.readFileToString(file, "utf-8");
                System.out.println(str);


            }
        }catch (Exception e) {
            result.status = Status.FAIL;
            result.log = e.getMessage();
        }

        return result;
    }
}
