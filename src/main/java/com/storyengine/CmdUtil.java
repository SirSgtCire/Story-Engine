package com.storyengine;

import org.slf4j.Logger;
import java.io.IOException;
import java.io.BufferedReader;
import org.slf4j.LoggerFactory;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class CmdUtil {
    private static final Logger logger = LoggerFactory.getLogger(CmdUtil.class);

    public static String executeCommand(String command) throws IOException {
        String output = null;
        Process p = Runtime.getRuntime().exec(command);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            output = reader.lines().collect(Collectors.joining("\n", "", "\n"));
            logger.info("Command Line Invoker output:\n"+output);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
