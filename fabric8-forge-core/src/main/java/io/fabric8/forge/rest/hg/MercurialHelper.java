package io.fabric8.forge.rest.hg;



import io.fabric8.forge.rest.git.dto.CommitInfo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aragost.javahg.Changeset;
import com.aragost.javahg.Repository;
import com.aragost.javahg.commands.AddCommand;
import com.aragost.javahg.commands.CommitCommand;
import com.aragost.javahg.commands.LogCommand;
import com.aragost.javahg.commands.PullCommand;
import com.aragost.javahg.commands.PushCommand;
import com.google.common.collect.Lists;

public class MercurialHelper {
	
	private static final transient Logger LOG = LoggerFactory.getLogger(MercurialHelper.class);
	
	public static void doAddCommitAndPushFiles(Repository repo) {
		AddCommand.on(repo).execute();
        CommitCommand.on(repo).user("forge").message("Modified Repository from the forge").execute();
        try {
			PushCommand.on(repo).execute();
			LOG.info("Successfully pushed mercurial changes.");
		} catch (IOException e) {
			LOG.error("Failed to push Mercurial Changes: ", e);
		}
	}
	
	public static List<CommitInfo> getHistory(Repository repo, int limit) {
		List<CommitInfo> history = Lists.newArrayList();
		List<Changeset> changesets = LogCommand.on(repo).execute();
		for(Changeset changeset : changesets) {
			history.add(new CommitInfo(
					changeset.getNode(), 
					changeset.getUser(), 
					"", "", "", 
					changeset.getTimestamp().getDate(), 
					false,
					changeset.getMessage()));
		}
		
		history = Lists.reverse(history);

		return (limit > history.size() || limit == 0) ? history : history.subList(0, limit - 1);
	}

	public static void doPull(Repository repo) {
		try {
			PullCommand.on(repo).force().execute();
			LOG.info("Successfully pulled mercurial changes.");
		} catch (IOException e) {
			LOG.error("Failed to pull Mercurial Repo: ", e);
		}
	}

}
