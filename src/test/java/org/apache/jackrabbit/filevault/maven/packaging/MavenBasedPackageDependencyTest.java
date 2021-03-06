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
package org.apache.jackrabbit.filevault.maven.packaging;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.jackrabbit.filevault.maven.packaging.SimpleEmbeddedTest.SimpleArtifact;
import org.apache.maven.artifact.Artifact;
import org.junit.Assert;
import org.junit.Test;

public class MavenBasedPackageDependencyTest {

    @Test
    public void testUriToMavenCoordinates() throws URISyntaxException {
        Assert.assertEquals(new SimpleArtifact("group1", "name1", null, "zip"), MavenBasedPackageDependency.uriToMavenCoordinates(new URI("maven", "group1:name1", null)));
    }

    @Test
    public void testMavenCoordinatesToUri() throws URISyntaxException {
        Assert.assertEquals(new URI("maven", "group1:name1:1.0:zip:classifier1", null), MavenBasedPackageDependency.mavenCoordinatesToUri("group1", "name1", "1.0", "classifier1"));
        Assert.assertEquals(new URI("maven", "group1:name1:1.0:zip", null), MavenBasedPackageDependency.mavenCoordinatesToUri("group1", "name1", "1.0", null));
    }

    @Test 
    public void testMavenCoordinatesToUriRoundtrip() throws URISyntaxException {
        Artifact artifact = new SimpleArtifact("groupname", "artifactName", null, "zip");
        Assert.assertEquals(artifact, MavenBasedPackageDependency.uriToMavenCoordinates(MavenBasedPackageDependency.mavenCoordinatesToUri(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion(), artifact.getClassifier())));
    }
    
    @Test 
    public void testUriToMavenCoordinatesRoundtrip() throws URISyntaxException {
        URI uri = new URI("maven", "test-group:some name:1.0:zip", null);
        Artifact artifact = MavenBasedPackageDependency.uriToMavenCoordinates(uri);
        Assert.assertEquals(uri, MavenBasedPackageDependency.mavenCoordinatesToUri(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion(), artifact.getClassifier()));
    }
}
