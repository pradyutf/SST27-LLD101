package com.example.video;

public class SharpenAdapter {

    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = legacy;
    }
    public Frame[] sharpen(Frame[] frames, int strength) {
        String handle = "HANDLE:0"; // dummy initial handle
        for (int i = 0; i < frames.length; i++) {
            handle = legacy.applySharpen(handle, strength);
            frames[i] = new Frame(0,0); // new Frame with dummy dimensions
            // In a real scenario, we would use the handle to get the processed frame data
        }
        return frames;
    }
}
