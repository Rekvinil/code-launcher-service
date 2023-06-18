package com.vkr.codelauncherservice.data.web;

import com.vkr.codelauncherservice.data.IResult;
import com.vkr.codelauncherservice.data.Status;

public class LaunchResult implements IResult {
    public String userId;
    public String projectName;
    public Status status;
    public String log;
}
