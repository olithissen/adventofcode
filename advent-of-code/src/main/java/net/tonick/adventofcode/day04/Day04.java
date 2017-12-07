/**
 * (c) 2017 Generali Deutschland Informatik Services GmbH, Aachen 
 *
 * All rights reserved.
 * Any copy, modification and distribution of the software and of the accompanying 
 * documentation require prior written permission/consent of the copyright holder.
 */
package net.tonick.adventofcode.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day04 {

    /**
     * @param args
     * @throws Exception 
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException, Exception {
        List<String> lines = Files.readAllLines(Paths.get(Day04.class.getResource("input.txt").toURI()));
        int valid = 0;
        
        for (String string : lines) {
            String[] split = string.split("\\s+");
            long count = Arrays.stream(split).map(s -> {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }).distinct().count();
            
            if (split.length == count) {
                valid++;
            }
        }
        
        System.out.println(valid);
    }

}
