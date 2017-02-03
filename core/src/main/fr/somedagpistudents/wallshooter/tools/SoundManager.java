package fr.somedagpistudents.wallshooter.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

/**
 * Created by benjamin on 2/2/17.
 */
public class SoundManager {
    private HashMap<String, Sound> sounds;

    public SoundManager() {
        this.sounds = new HashMap<String, Sound>();
        this.loadSounds();
    }

    private void loadSounds() {
        loadSound(Assets.SOUND_EXPLOSION);
        loadSound(Assets.SOUND_LASER);
    }

    private void loadSound(String sound) {
        this.sounds.put(sound, Gdx.audio.newSound(Gdx.files.internal(sound)));
    }

    public void playSound(String sound) {
        this.sounds.get(sound).play(0.1f);
    }


    public void dispose() {
        for (Sound sound : this.sounds.values()) {
            sound.dispose();
        }
    }
}
