package grim3212.raygun.common;

import grim3212.raygun.Raygun;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class Sounds {
	
	@ForgeSubscribe
	   public void onSound(SoundLoadEvent event)
	   {
	       try
	       {
	       		String [] soundFiles = {
	       				"raysh.ogg"
	       				};
	       		for (int i = 0; i < soundFiles.length; i++){
	       			event.manager.soundPoolSounds.addSound(soundFiles[i], Raygun.class.getResource("/mods/Raygun/sounds/" + soundFiles[i]));
	       		}
	      
	       }
	       catch (Exception e)
	       {
	           System.err.println("Raygun: Failed to register one or more sounds.");
	       }
	   }
}
