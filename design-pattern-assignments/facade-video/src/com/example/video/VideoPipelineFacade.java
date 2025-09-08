package com.example.video;

public class VideoPipelineFacade {
    Decoder dec = new Decoder();
    FilterEngine fe = new FilterEngine();
    Encoder enc = new Encoder();

    public java.nio.file.Path process(java.nio.file.Path inFile, java.nio.file.Path outFile) {
        Frame[] frames = dec.decode(inFile);
        frames = fe.grayscale(frames);
        frames = fe.scale(frames, 0.5);

        SharpenAdapter sharpen = new SharpenAdapter(new LegacySharpen());
        frames = sharpen.sharpen(frames, 5);
        return enc.encode(frames, outFile);
    }
}
