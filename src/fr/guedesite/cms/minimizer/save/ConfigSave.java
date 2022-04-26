package fr.guedesite.cms.minimizer.save;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import fr.guedesite.utils.CrashHandler;
import fr.guedesite.utils.nbt.io.NBTUtil;
import fr.guedesite.utils.nbt.tag.CompoundTag;
import fr.guedesite.utils.nbt.tag.ListTag;

public class ConfigSave {

	private static final Logger LOGGER = Logger.getLogger(ConfigSave.class.getPackageName() );

	private final File file;
	
	private CompoundTag tag;
	private Configuration[] configs;
	
	
	public ConfigSave(String file) {
		this.file = new File(file);
		LOGGER.log(Level.INFO, "Init Config Save");
		if(this.file.exists()) {
			LOGGER.log(Level.INFO, "Load file "+this.file.getAbsolutePath());
			try {
				tag = (CompoundTag) NBTUtil.read(file).getTag();
			} catch (IOException e) {
				CrashHandler.Push(e);
			}
		} else {
			LOGGER.log(Level.INFO, "can't find config file create new one: "+this.file.getAbsolutePath());
			try {
				this.file.createNewFile();
				tag = new CompoundTag();
			} catch (IOException e) {
				CrashHandler.Push(e);
			}
		}
	}
	
	private void generateConfig() {
		if(tag.containsKey("config")) {
			ListTag<CompoundTag> conf = tag.getListTag("config").asCompoundTagList();
			this.configs = new Configuration[conf.size()];
			for(int i = 0; i<conf.size(); i++) {
				this.configs[i] = new Configuration(conf.get(i));
			}
			LOGGER.log(Level.INFO, "Load "+conf.size()+" config(s)");
		} else {
			LOGGER.log(Level.INFO, "Load 0 config");
			this.configs = new Configuration[0];
		}
	}
	
	public Configuration[] getAllConfig() {
		return this.configs;
	}
	
	public Configuration getConfigById(int id) {
		try {
			return this.configs[0];
		} catch(Exception e) {
			CrashHandler.Push(e);
			return null;
		}
	}
	
	
	
	public void SaveConfig() {
		try {
			NBTUtil.write(this.tag, this.file);
		} catch (IOException e) {
			CrashHandler.Push(e);
		}
	}
	
	
	
}
