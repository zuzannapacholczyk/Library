package start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.*;
import database.SynchronizerOperations;
import entities.ReaderToInform;

public class Synchronizer {

	private String fileName = "dateInfo.txt";
	private SynchronizerOperations synchronizerOperations;

	public Synchronizer() {
		synchronizerOperations = new SynchronizerOperations();
		readDateFromFile();
	}

	private void readDateFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String result = br.readLine();
			if (!result.equals(getTodayDate())) {
				synchronizerOperations.countPunishments();
				writeDateToFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeDateToFile() {
		Writer writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(this.getTodayDate());
		} catch (IOException ex) {
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {/* ignore */
			}
		}
	}

	private String getTodayDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
