package com.corecard.file_level;

import com.corecard.file_level.model.*;
import com.corecard.file_level.utils.ProcessingLines;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class FileLevelDeTokenizationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FileLevelDeTokenizationApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        if (args.length < 2) {
            System.out.println("Use: java -jar file-level-de-tokenization-1.0.jar ACH_tokenized.txt ACH_tokenized.txt");
            return;
        }

        Path file1 = Path.of(args[0]);
        Path file2 = Path.of(args[1]);

        if (!Files.exists(file1) || !Files.exists(file2)) {
            System.out.println("Error: One of both files not exist.");
            return;
        }

        List<String> lines = ProcessingLines.readingLines(file1);


        Structure structure = ProcessingLines.splitingLines(lines);

        Structure structure2 = ProcessingLines.splitInTwoTheLines(lines);
/*
        for (int x = 0; x <= 3; x++) {
            System.out.println(structure.getLineBody().getPrimaryNumber().get(x) +
                    structure.getLineBody().getAccountTokenEncrypted().get(x) +
                    structure.getLineBody().getSecondNumber().get(x) +
                    structure.getLineBody().getNameToken().get(x) +
                    structure.getLineBody().getFinalNumber().get(x));
        }


 */
        for (int x = 0; x <= 3; x++) {
            System.out.println(structure2.getLineSplitedBody().getPrimaryPart().get(x) +
                    structure2.getLineSplitedBody().getSecondPart().get(x));
        }

    }

}
