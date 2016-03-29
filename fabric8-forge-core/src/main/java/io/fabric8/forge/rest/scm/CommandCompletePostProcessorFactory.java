package io.fabric8.forge.rest.scm;

import io.fabric8.forge.rest.hg.MercurialCommandCompletePostProcessor;
import io.fabric8.forge.rest.hooks.CommandCompletePostProcessor;
import io.fabric8.forge.rest.main.GitCommandCompletePostProcessor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class CommandCompletePostProcessorFactory {

	@Produces
	@SCM(SCMType.GIT)
	public CommandCompletePostProcessor getGitCommandCompletePostProcessor(
			@New GitCommandCompletePostProcessor gitCommandCompletePostProcessor) {
		return gitCommandCompletePostProcessor;
	}
	
	@Produces
	@SCM(SCMType.MERCURIAL)
	public CommandCompletePostProcessor getMercurialCommandCompletePostProcessor(
			@New MercurialCommandCompletePostProcessor mercuialCommandCompletePostProcessor) {
		return mercuialCommandCompletePostProcessor;
	}
	
}
