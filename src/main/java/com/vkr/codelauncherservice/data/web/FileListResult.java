package com.vkr.codelauncherservice.data.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vkr.codelauncherservice.data.IResult;
import lombok.*;

import java.util.List;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class FileListResult implements IResult {
    String userId;

    @NotNull
    @JsonProperty
    String projectName;

    @NotNull
    @JsonProperty
    List<String> fileList;
}
