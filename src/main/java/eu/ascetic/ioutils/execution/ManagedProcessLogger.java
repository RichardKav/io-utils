/**
 * This code was created as part of the Intelligent Scheduling for Quality of
 * Service (ISQoS) project (2009-2013) as part of the original author's PhD.
 * 
 * Copyright 2013 Richard Kavanagh
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package eu.ascetic.ioutils.execution;

import eu.ascetic.ioutils.io.GenericLogger;
import eu.ascetic.ioutils.io.ResultsStore;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This logs managed processes and indicates the status of them.
 * @author Richard
 */
public class ManagedProcessLogger extends GenericLogger<ManagedProcess> {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm:ss");    

    public ManagedProcessLogger(File file, boolean overwrite) {
        super(file, overwrite);
    }    
    
    @Override
    public void writeHeader(ResultsStore store) {
        store.add("Time Written Out");
        store.append("Command");        
        store.append("Finished");
        store.append("Working Directory");
        store.append("Standard In");
        store.append("Standard Out");
        store.append("Standard Error");
    }

    @Override
    public void writebody(ManagedProcess item, ResultsStore store) {
        store.add(FORMAT.format(new Date()));
        store.append(item.getCommand());
        store.append(item.hasFinished());
        store.append(item.getWorkingDirectory().getAbsolutePath());
        store.append(item.getStdIn());
        store.append(item.getStdOut());        
        store.append(item.getStdError());
    } 
    
}
