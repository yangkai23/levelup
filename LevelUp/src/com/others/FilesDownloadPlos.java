package com.others;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesDownloadPlos {
    public static void main(String[] args) throws IOException {
        String outputPath="C:\\cps\\provider_setup\\PLoS\\downloads\\";
        try{
            List<String> urls=Files.readAllLines(Paths.get("C:\\cps\\provider_setup\\PLoS\\urls.txt"));
            for (String url:urls){
                int indexOf=url.indexOf("journal.");
                String fileName=url.substring(indexOf+8,indexOf+20).concat(".pdf");
                download(url,outputPath+fileName);
            }
        }catch (Exception e ){
            System.out.println("Error");
        }
    }
    public static void download(String href, String outputPath) throws IOException, MalformedURLException {
        // Connection conn = Jsoup.connect(href);
        // Document doc = conn.get();
        // String html = doc.toString();
        URL url = new URL(href);

        FileUtils.copyURLToFile(url, new File(outputPath));

        // String filename = "Plos_N.txt";
        // FileUtils.writeStringToFile(new File(outputPath), html, "UTF-8");
    }
}
