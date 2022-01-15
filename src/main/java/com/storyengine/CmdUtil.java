package com.storyengine;

import org.slf4j.Logger;
import java.io.BufferedReader;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CmdUtil {
    private static final Logger logger = LoggerFactory.getLogger(CmdUtil.class);

    public static String executeCommand(String command) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("sh", "-c", command);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder output = null;
        while ((line = reader.readLine()) != null) {
            logger.info(line);
            output.append(line);
        }
        return output.toString();
    }
}
