package io.fabric8.forge.rest.hg;

import io.fabric8.forge.rest.dto.ExecutionRequest;
import io.fabric8.forge.rest.dto.ExecutionResult;
import io.fabric8.forge.rest.hooks.CommandCompletePostProcessor;
import io.fabric8.forge.rest.main.UserDetails;
import io.fabric8.forge.rest.ui.RestUIContext;

import javax.servlet.http.HttpServletRequest;

import org.jboss.forge.addon.ui.controller.CommandController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MercurialCommandCompletePostProcessor implements
		CommandCompletePostProcessor {
	
	private static final transient Logger LOG = LoggerFactory.getLogger(MercurialCommandCompletePostProcessor.class);

	@Override
	public void firePostCompleteActions(String name,
			ExecutionRequest executionRequest, RestUIContext context,
			CommandController controller, ExecutionResult results,
			HttpServletRequest request) {
		
		LOG.info("PostProcessing Mercurial Request");
		
	}

	@Override
	public UserDetails preprocessRequest(String name,
			ExecutionRequest executionRequest, HttpServletRequest request) {
		
		LOG.info("Preprocessing Mercurial Request");
		
		return null;
	}

}
