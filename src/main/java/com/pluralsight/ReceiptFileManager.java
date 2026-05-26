package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static final String SRC_MAIN_RESOURCES_RECEIPTS = "src/main/resources/receipts/";

    public static void saveReceipt(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = LocalDateTime.now().format(formatter);
        String fileLocation = SRC_MAIN_RESOURCES_RECEIPTS +fileName+".txt";
        try {
            FileWriter fileWriter = new FileWriter(fileLocation);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(order.showOrder());
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e){
            System.err.println("File Location not found");
        }
    }
}
