package com.bp.restart.hackerrank.BalancedSystemFilesPartition;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class BalancedSystemFilesPartition {
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> parent = IntStream.range(0, parentCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int files_sizeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> files_size = IntStream.range(0, files_sizeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
*/
        List<Integer> parent = new ArrayList<>();
        parent.add(-1);
        parent.add(0);
        parent.add(1);
        parent.add(2);
        parent.add(4);
        List<Integer> files_size = new ArrayList<>();
        files_size.add(1);
        files_size.add(4);
        files_size.add(3);
        files_size.add(4);
        int result = Result.mostBalancedPartition(parent, files_size);
        System.out.println("="+result);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }

}
