package com.yaml.beans;

import java.util.Map;

public class Aws {
	
	private String version;
	private Map<String, Command> phases;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Map<String, Command> getPhases() {
		return phases;
	}
	public void setPhases(Map<String, Command> phases) {
		this.phases = phases;
	}
	
	
	

}
