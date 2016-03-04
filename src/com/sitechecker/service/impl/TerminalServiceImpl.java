package com.sitechecker.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import com.sitechecker.dao.TerminalDao;
import com.sitechecker.domain.Terminal;
import com.sitechecker.service.TerminalService;

public class TerminalServiceImpl implements TerminalService {

	@Resource(name="terminalDao")
	private TerminalDao<Terminal> terminalDao;
	
	@Override
	public Collection<Terminal> findAllTerminal() {
		return this.terminalDao.getAllEntry();
	}

	@Override
	public Terminal findTerminalByTid(Serializable tid) {
		return this.terminalDao.getEntryByID(tid);
	}

	@Override
	public void updateTerminalByTid(Serializable tid) {
		Terminal terminal = this.findTerminalByTid(tid);
		this.terminalDao.updateEntry(terminal);
	}

	@Override
	public void deleteTerminalByTid(Serializable tid) {
		this.terminalDao.deleteEntry(tid);
	}

}
