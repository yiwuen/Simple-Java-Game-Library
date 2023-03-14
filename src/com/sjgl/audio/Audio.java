package com.sjgl.audio;

import java.io.*;

import javax.sound.sampled.*;

/**
 * Simple audio class for playing audio. This is very basic and isn't recommended for serious audio-playing. Creating a audio class with more
 * functionality is highly recommended.
 * 
 * @author yiwuen
 *
 */

public final class Audio {

	private String audioPath;
	private Clip clip;
	private AudioInputStream ais;

	/**
	 * Constructs/loads an audio based on the given relative path. .wav is supported.
	 * @param audioPath Relative path to the audio file
	 */
	public Audio(String audioPath) {
		this.audioPath = audioPath;
		
		init();
	}

	/**
	 * Constructs/loads an audio based on the given path. .wav is supported.
	 * @param audioPath Path to the audio file.
	 * @param loop Loops the audio
	 */
	public Audio(String audioPath, boolean loop) {
		this.audioPath = audioPath;
		
		init();

		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	private void init() {
		try {
			ais = AudioSystem.getAudioInputStream(new File(audioPath).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Plays the audio.
	 */
	public void play() {
		try {
			clip.open(ais);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Stops the audio.
	 */
	public void stop() {
		clip.stop();
		clip.close();
	}

	/**
	 * Pauses the audio.
	 */
	public void pause() {
		if (clip.isOpen())
			clip.stop();
	}

}