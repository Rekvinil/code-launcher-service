package com.vkr.codelauncherservice.data.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vkr.codelauncherservice.data.IResult;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class SuccessCodeLaunchResult implements IResult {
    @NotNull
    @JsonProperty
    String output;
}
