package com.fimc.calculator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse {
    
    private String action;
    private String result;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
    
}

