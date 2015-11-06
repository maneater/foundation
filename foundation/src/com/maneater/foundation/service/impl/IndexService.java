package com.maneater.foundation.service.impl;

import org.springframework.stereotype.Service;

import com.maneater.foundation.service.IIndexService;

@Service
public class IndexService implements IIndexService {

	@Override
	public boolean isSiteOpen() {
		return true;
	}

}
