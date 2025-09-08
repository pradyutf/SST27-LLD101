package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        Path inFile = Path.of("in.mp4");
        Path outFile = Path.of("out.mp4");
        VideoPipelineFacade facade = new VideoPipelineFacade();
        Path out = facade.process(inFile, outFile);
        System.out.println("Wrote " + out);

        // TODO: Replace all above with VideoPipelineFacade.process(...)
    }
}
