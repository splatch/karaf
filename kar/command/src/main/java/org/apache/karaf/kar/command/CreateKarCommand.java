/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.kar.command;

import java.util.List;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;

@Command(scope = "kar", name = "create", description = "Create a kar file for a list of feature repos")
public class CreateKarCommand extends KarCommandSupport {
    
    @Argument(index = 0, name = "repoName", description = "Repository name. The kar will contain all features of the named repository by default", required = true, multiValued = false)
    private String repoName;
    
    @Argument(index = 1, name = "features", description = "Names of the features to include. If set then only these features will be added", required = false, multiValued = true)
    private List<String> features;
    
    public Object doExecute() throws Exception {
        this.getKarService().create(repoName, features, System.out);
        return null;
    }
    
}
