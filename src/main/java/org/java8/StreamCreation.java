package org.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String s[]) throws IOException {
        createEmptyStream(null).forEach(System.out::print);
        createStreamFromSupplier(()-> "element").forEach(System.out::print);
        createStreamUsingIterate().forEach(System.out::print);
        createStreamFromString("a,b,c").forEach(System.out::print);
        System.out.println("-------------------------------------------------------");
        createStreamFromFile(Paths.get("C:\\Users\\rakes\\Documents\\Tasks.txt")).forEach(System.out::print);
    }

    /**
     * Example to demonstrate empty string to avoid null pointer exception
     * @param list
     * @return
     */
    private static Stream createEmptyStream(List<String> list){
        return Objects.isNull(list) ? Stream.empty() : list.stream();
    }

    /**
     * Stream of arrays
     */
    private static Stream createStreamFromArray(String[] arr){
        //Another example of creating stream using array elements
        Stream.of("a","b","c");
        return Arrays.stream(arr);
    }

    /**
     * Create stream using supplier
     * @param supplierFunction
     * @return
     */
    private static Stream createStreamFromSupplier(Supplier supplierFunction){
        return Stream.generate(supplierFunction).limit(10);
    }

    /**
     * Creating stream using iterate function
     * @return
     */
    private static Stream createStreamUsingIterate(){
        return Stream.iterate(1, n -> n + 1).limit(10);
    }

    /**
     * Create stream from comma separated string
     * @param delimitedString
     * @return
     */
    private static Stream createStreamFromString(String delimitedString){
        return Pattern.compile(",").splitAsStream(delimitedString);
    }

    /**
     * Create stream of strings using lines from a file
     * @param filePath
     * @return
     * @throws IOException
     */
    private static Stream createStreamFromFile(Path filePath) throws IOException {
        return Files.lines(filePath);
    }
}
