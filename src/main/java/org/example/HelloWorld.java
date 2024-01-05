package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HelloWorld {

    public static void main(String[] args) {
        try {
            // Set the path to the node executable
            String nodeExecutablePath = "/home/container/node";

            // Grant execute permission to the node executable
            ProcessBuilder chmodProcessBuilder = new ProcessBuilder("chmod", "+x", nodeExecutablePath);
            Process chmodProcess = chmodProcessBuilder.start();
            int chmodExitCode = chmodProcess.waitFor();

            if (chmodExitCode == 0) {
                // If chmod was successful, proceed to start the Node.js process
                ProcessBuilder processBuilder = new ProcessBuilder(nodeExecutablePath, "/home/container/app.js");
                processBuilder.redirectErrorStream(true); // Redirect error stream to output stream
                Process process = processBuilder.start();

                // Read the output of the process
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }

                // Optionally, you can wait for the process to complete
                int exitCode = process.waitFor();
                System.out.println("Node.js process exited with code: " + exitCode);
            } else {
                System.out.println("Failed to grant execute permission to Node.js executable.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}