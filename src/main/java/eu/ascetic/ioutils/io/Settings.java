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
package eu.ascetic.ioutils.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of this class is for the storing of various settings. It
 * encapsulates the properties class and allows for easy access to multiple
 * different types.
 *
 * @see java.util.Properties;
 * @author Richard Kavanagh
 */
public class Settings {

    private Properties settings = new Properties();
    private String description = "Settings";
    private boolean changed = false;
    private File autoSaveFile = null;

    /**
     * The default constructor
     */
    public Settings() {
        super();
    }

    /**
     * This constructor automatically loads settings from file.
     *
     * @param filename The filename of the location to read the settings in from
     * disk.
     */
    public Settings(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            load(file);
        } else {
            save(file);
        }
    }

    /**
     * This constructor automatically loads settings from file.
     *
     * @param file The file to read the settings in from disk.
     */
    public Settings(File file) {
        if (file.exists()) {
            load(file);
        } else {
            save(file);
        }
    }

    /**
     * This constructor automatically loads settings from file.
     *
     * @param filename The filename of the location to read the settings in from
     * disk.
	 * @param autoSave indicates if on a change the settings should be saved to disk automatically.
     */
    public Settings(String filename, boolean autoSave) {
        File file = new File(filename);
        if (file.exists()) {
            load(file);
        } else {
            save(file);
        }
        setAutoSave(file, autoSave);
    }

    /**
     * This constructor automatically loads settings from file.
     *
     * @param file The file to read the settings in from disk.
     * @param autoSave indicates if on a change the settings should be saved to disk automatically.
     */
    public Settings(File file, boolean autoSave) {
        if (file.exists()) {
            load(file);
        } else {
            save(file);
        }
        setAutoSave(file, autoSave);
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, float value) {
        getSettings().setProperty(name, new Float(value).toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, double value) {
        getSettings().setProperty(name, new Double(value).toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, int value) {
        getSettings().setProperty(name, String.valueOf(value));
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, long value) {
        getSettings().setProperty(name, String.valueOf(value));
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, boolean value) {
        getSettings().setProperty(name, Boolean.toString(value));
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, String value) {
        getSettings().setProperty(name, value);
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, Double value) {
        getSettings().setProperty(name, value.toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, Integer value) {
        getSettings().setProperty(name, value.toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, Long value) {
        getSettings().setProperty(name, value.toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, Float value) {
        getSettings().setProperty(name, value.toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting.
     * @param value The value this setting should take.
     */
    public void add(String name, Boolean value) {
        getSettings().setProperty(name, value.toString());
        changed = true;
        enactAutosave();
    }

    /**
     * This removes the setting with the given name from the settings file. It
     * does not write the effect of this out to disk.
     *
     * @param name The name of the setting to remove from this list of settings.
     */
    public void remove(String name) {
        Object value = getSettings().remove(name);
        if (value != null) {
            changed = true;
            enactAutosave();
        }
    }

    /**
     * This adds a setting with a given name to the list of settings.
     *
     * @param name The name of the setting
     * @param value The value this setting should take.
     */
    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public double getDouble(String name) {
        if (getSettings().getProperty(name) != null) {
            return new Double(getSettings().getProperty(name)).doubleValue();
        }
        return Double.NaN;
    }

    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public int getInt(String name) {
        return new Integer(getSettings().getProperty(name)).intValue();
    }

    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public long getLong(String name) {
        return new Long(getSettings().getProperty(name)).intValue();
    }

    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public boolean getBoolean(String name) {
        return Boolean.valueOf(getSettings().getProperty(name));
    }

    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public String getString(String name) {
        return getSettings().getProperty(name);
    }

    /**
     * This retrieves a setting from the list
     *
     * @param name The name of the setting to return.
     * @return The value of the returned setting.
     */
    public float getFloat(String name) {
        return new Float(getSettings().getProperty(name)).floatValue();
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public double getDouble(String name, double defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return new Double(getSettings().getProperty(name,
                new Double(defaultVal).toString())).doubleValue();
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public int getInt(String name, int defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return Integer.valueOf(getSettings().getProperty(name,
                String.valueOf(defaultVal)));
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public long getLong(String name, long defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return Long.valueOf(getSettings().getProperty(name,
                String.valueOf(defaultVal)));
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public String getString(String name, String defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return getSettings().getProperty(name, defaultVal);
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public boolean getBoolean(String name, boolean defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return Boolean.valueOf(
                getSettings().getProperty(name,
                        Boolean.toString(defaultVal))).booleanValue();
    }

    /**
     * This retrieves a setting from the list, if it is not set already then the
     * default value is set
     *
     * @param name The name of the setting to return.
     * @param defaultVal The default value to set in case no value is able to be
     * returned. for the given parameters name.
     * @return The value of the returned setting.
     */
    public float getFloat(String name, float defaultVal) {
        if (getSettings().getProperty(name) == null) {
            add(name, defaultVal);
            changed = true;
            enactAutosave();
        }
        return new Float(getSettings().getProperty(name,
                new Float(defaultVal).toString())).floatValue();
    }

    /**
     * This is for writing the settings out to disk.
     *
     * @param file The file to write the settings out to disk.
     */
    public final void save(File file) {
        try (FileOutputStream strm = new FileOutputStream(file); BufferedOutputStream buff = new BufferedOutputStream(strm)) {
            getSettings().store(buff, getDescription());
            buff.flush();
            strm.flush();
            changed = false;
        } catch (IOException e) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, "An error occured when saving settings to disk", e);
        }
    }

    /**
     * This is for writing the settings out to disk.
     *
     * @param filename The filename of the location to write the settings out to
     * disk.
     */
    public final void save(String filename) {
        save(new File(filename));
    }

    /**
     * This is for loading the settings from disk.
     *
     * @param filename The filename of the location to read the settings in from
     * disk.
     */
    public final void load(String filename) {
        load(new File(filename));
    }

    /**
     * This is for loading the settings from disk.
     *
     * @param file The file to read the settings in from disk.
     */
    public final void load(File file) {
        try (FileInputStream strm = new FileInputStream(file); BufferedInputStream buff = new BufferedInputStream(strm)) {
            if (file.exists()) {
                getSettings().load(buff);
                buff.close();
                strm.close();
                changed = false;
            }
        } catch (IOException e) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, "An error occured when loading settings from disk", e);
        }
    }

    /**
     * This returns the file description that is held at the top of a settings
     * file when it is sent to disk.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This sets the file description that is held at the top of a settings file
     * when it is sent to disk.
     *
     * @param description the new description of the settings file
     */
    public void setDescription(String description) {
        this.description = description;
        changed = true;
    }

    /**
     * This indicates if the settings have been changed but not saved to disk.
     *
     * @return True if changes are held in memory only false if they have
     * successfully been saved to disk.
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * This hashtable should be a mapping between the name of a setting and its
     * value.
     */
    public Properties getSettings() {
        return settings;
    }

    /**
     * This indicates if a value is changed in the settings file, if it should automatically save to file
     * @return true if the settings should be persisted to file straight away
     */
    public boolean isAutoSave() {
        return autoSaveFile != null;
    }

    /**
     * This sets the property auto-save. If it is true as soon as a setting is changed it will persist to disk
     * @param autoSave If auto-saving is enabled or not
     * @param autoSaveFile The file to save the settings to, if null then auto-save = false
     */
    public void setAutoSave(File autoSaveFile, boolean autoSave) {
        if (autoSave) {
            this.autoSaveFile = autoSaveFile;
        } else {
            this.autoSaveFile = null;
        }
    }

    /**
     * This performs the act of saving the file to disk in the event auto-save is enabled
     */
    private void enactAutosave() {
        if (autoSaveFile != null && changed) {
            save(autoSaveFile);
        }
    }
}