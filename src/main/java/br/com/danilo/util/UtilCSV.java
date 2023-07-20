package br.com.danilo.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class UtilCSV {
	
	public List<String> lerTodasLinhas(byte[] file) throws IOException {
	    List<String> allLines = new ArrayList<>();
	    try (InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(file))) {
	        CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
	        for (CSVRecord record : csvParser) {
	            allLines.add(record.get(0));
	        }
	    }
	    return allLines;
	}
    
    public List<String> lerTodasLinhas(MultipartFile file) throws IOException{
    	List<String> allLines = new ArrayList<>();
    	try (CSVParser csvParser = CSVFormat.DEFAULT.parse(new InputStreamReader(file.getInputStream()))) {
    		for (CSVRecord record : csvParser) {
    			allLines.add(record.get(0));
    		}
    	}
    	return allLines;
    }
    
}
