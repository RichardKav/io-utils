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
package eu.ascetic.ioutils.execution.stream;

/**
 * This allows for a stream gobbler to be exchangeable. i.e. allows a choice to be
 * made such as send to file, screen or to be discarded.
 * 
 * This is based upon the Runtime.exec() tutorial:
 * http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html
 *
 * It is important to read why gobblers are needed.
 * @see Runtime#exec(java.lang.String)
 *
 * @author Richard Kavanagh
 */
public interface StreamGobbler extends Runnable {

}
