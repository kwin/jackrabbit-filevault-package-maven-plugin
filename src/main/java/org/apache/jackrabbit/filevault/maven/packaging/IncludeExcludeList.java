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

import java.io.PrintWriter;
import java.util.ArrayList;

public class IncludeExcludeList extends ArrayList<String> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public boolean add(String entry) {
        return entry != null && super.add(entry);
    }

    public void write(PrintWriter pw, String tag) {
        for (String include: this) {
            pw.print(Filter.INDENT);
            pw.print(Filter.INDENT);
            pw.print('<');
            pw.print(tag);
            pw.print(" pattern=\"");
            pw.print(include);
            pw.print("\" />");
            pw.println();
        }
    }
}