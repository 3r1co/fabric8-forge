/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.forge.rest.git.dto;

import java.util.List;

/**
 */
public class CommitDetail extends GitDTOSupport {
    private final CommitInfo commitInfo;
    private final List<DiffInfo> diffs;

    public CommitDetail(CommitInfo commitInfo, List<DiffInfo> diffs) {
        this.commitInfo = commitInfo;
        this.diffs = diffs;
    }

    @Override
    public String toString() {
        return "CommitDetail{" +
                "commitInfo=" + commitInfo +
                ", diffs=" + diffs +
                '}';
    }

    public CommitInfo getCommitInfo() {
        return commitInfo;
    }

    public List<DiffInfo> getDiffs() {
        return diffs;
    }
}
