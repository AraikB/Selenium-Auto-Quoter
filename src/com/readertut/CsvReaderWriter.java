package com.readertut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWriter {
	//private 

	private driverInfo driverInfo;

	public CsvReaderWriter(String filepath) {
		this.driverInfo = readCsv(filepath);
	}

	public driverInfo getDriverInfo() {
		return this.driverInfo;
	}

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Disco Ric\\Documents\\Book1.csv";

		//	System.out.println("starting write driverInfo.csv file:" + filePath);
		//	writeCsv(filePath);

		System.out.println("Starting Read driverInfo.csv file");
		//readCsv(filePath);
	}
	/*	public static void writeCsv(String filePath) {
		List<driverInfo> driverInfos = new ArrayList<driverInfo>();

		driverInfo driverInfo = new driverInfo();
		driverInfo.setFirstName("Jack");
		driverInfo.setLastName("Tutorial 1");;
		driverInfos.add(driverInfo);

		driverInfo = new driverInfo();
		driverInfo.setId(2);
		driverInfo.setFirstName("Jack");
		driverInfo.setLastName("Tutorial 2");;
		driverInfos.add(driverInfo);

		driverInfo = new driverInfo();
		driverInfo.setId(3);
		driverInfo.setFirstName("Jack");
		driverInfo.setLastName("Tutorial 3");;
		driverInfos.add(driverInfo);

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			fileWriter.append("Id, First Name, Last Name");
			for(driverInfo u: driverInfos) {
				fileWriter.append(String.valueOf(u.getId()));
				fileWriter.append(",");
				fileWriter.append(u.getFirstName());
				fileWriter.append(",");
				fileWriter.append(u.getLastName());
				fileWriter.append("\n");

				}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
			fileWriter.flush();
			fileWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}*/
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
					/*		System.out.printf("Client Name :%s, %s  \n Address : %s Zip Code : %s \n Phone Number - Email : %s - %s \n Residence Type : %s \n "
							+ "Insured with Mercury : %s \n Date of Birth : %s \n Marital Status : %s \n License Nummber : %s \n Relationship to Insured : %s \n",  
							u.getLastName(), u.getFirstName(), u.getMailingAddress(), 
							u.getZipCode(), u.getPhoneNumber(), u.getEmailAddress(), u.getResidenceType(), u.getInsuredMerc(), u.dateOfBirth, u.getMaritalStatus(), 
							u.getLicenseNumber(), u.getRelationtoInsured()); */
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
