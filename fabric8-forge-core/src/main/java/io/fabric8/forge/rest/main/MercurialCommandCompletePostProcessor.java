package io.fabric8.forge.rest.main;

import javax.servlet.http.HttpServletRequest;

import org.jboss.forge.addon.ui.controller.CommandController;

import io.fabric8.forge.rest.dto.ExecutionRequest;
import io.fabric8.forge.rest.dto.ExecutionResult;
import io.fabric8.forge.rest.hooks.CommandCompletePostProcessor;
import io.fabric8.forge.rest.ui.RestUIContext;

public class MercurialCommandCompletePostProcessor implements
		CommandCompletePostProcessor {

	@Override
	public void firePostCompleteActions(String name,
			ExecutionRequest executionRequest, RestUIContext context,
			CommandController controller, ExecutionResult results,
			HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails preprocessRequest(String name,
			ExecutionRequest executionRequest, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
