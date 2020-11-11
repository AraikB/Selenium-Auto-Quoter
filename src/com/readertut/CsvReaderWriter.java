package com.readertut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWriter {
 

	private driverInfo driverInfo;

	public CsvReaderWriter(String filepath) {
		this.driverInfo = readCsv(filepath);
	}

	public driverInfo getDriverInfo() {
		return this.driverInfo;
	}

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Disco Ric\\Documents\\Book1.csv";
		System.out.println("Starting Read driverInfo.csv file");
	}

	public driverInfo readCsv(String filePath) {
		BufferedReader reader = null; 
		driverInfo = new driverInfo();

		try {
			List<driverInfo> driverInfos = new ArrayList<driverInfo>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if(fields.length > 0) {

					driverInfo.setDate(fields[0]);
					driverInfo.setFirstName(fields[1]);
					driverInfo.setLastName(fields[2]);
					driverInfo.setMailingAddress(fields[3]);
					driverInfo.setZipCode(fields[4]);
					driverInfo.setPhoneNumber(fields[5]);
					driverInfo.setEmailAddress(fields[6]);
					driverInfo.setResidenceType(fields[7]);
					driverInfo.setInsuredMerc(fields[8]);
					driverInfo.setDateOfBirth(fields[9]);
					driverInfo.setDateFirstLicensed(fields[10]);
					driverInfo.setMaritalStatus(fields[11]);
					driverInfo.setLicenseNumber(fields[12]);
					driverInfo.setRelationtoInsured(fields[13]);
					driverInfos.add(driverInfo);
				}
				for(driverInfo u: driverInfos) {
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driverInfo;
	}
}
