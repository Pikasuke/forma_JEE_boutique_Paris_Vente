package com.parivente.beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Bdd {
		private String filename;
		private List<String> allLines;

		public Bdd(String filename){
			this.filename = filename;
		}

		public List<String> readFile() {
			
			try {
				allLines = Files.readAllLines(Paths.get(this.filename));
			} catch (IOException e) {
				e.printStackTrace();
			}

			return allLines;
		}
	}


//	public void separateur() {
//		for (String line : allLines) {
//		String[] arr =null;
//				arr = line.split("\\|");
//	}
