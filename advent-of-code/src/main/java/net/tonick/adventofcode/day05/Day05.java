/**
 * (c) 2017 Generali Deutschland Informatik Services GmbH, Aachen 
 *
 * All rights reserved.
 * Any copy, modification and distribution of the software and of the accompanying 
 * documentation require prior written permission/consent of the copyright holder.
 */
package net.tonick.adventofcode.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * JavaDoc für Day05
 *
 */
public class Day05 {
    /**
     * @param args
     * @throws Exception 
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException, Exception {
        List<String> lines = Files.readAllLines(Paths.get(Day05.class.getResource("input.txt").toURI()));
        int[] instructions = lines.stream().map(Integer::valueOf).mapToInt(Integer::intValue).toArray();
        
        run(instructions);
    }
    
    private static void run(int[] instructions) {
        int counter = 0;
        int pointer = 0;
        
        for(counter = 0; pointer >= 0 && pointer < instructions.length; counter++) {
            int next = pointer + instructions[pointer];
            if (instructions[pointer] >= 3) {
                instructions[pointer]--;
            } else {
                instructions[pointer]++;
            }
            pointer = next;
        }
        
        System.out.println(counter);
    }
}
