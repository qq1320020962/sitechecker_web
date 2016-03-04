package com.sitechecker.service;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.Terminal;

public interface TerminalService {
	
	public Collection<Terminal> findAllTerminal();
	
	public Terminal findTerminalByTid(Serializable tid);
	
	public void updateTerminalByTid(Serializable tid);
	
	public void deleteTerminalByTid(Serializable tid);
	
}
