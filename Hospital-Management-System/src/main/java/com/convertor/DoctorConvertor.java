package com.convertor;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.entity.Doctor;



public class DoctorConvertor {
    
    public static Document toDocument(Doctor doctor) {
    	System.out.println("Inside doc mapper");
        Document doc = new Document("fullname", doctor.getFullName())
            .append("dob", doctor.getDob()) 
            .append("qualification", doctor.getQualification())
            .append("specialist", doctor.getSpecialist())
            .append("email", doctor.getEmail())
            .append("mob", doctor.getMob())
            .append("password", doctor.getPassword());
        System.out.println("done doc mapper");
        if (doctor.getId() != null) {
            doc.append("_id",new ObjectId(doctor.getId()));
        }
        System.out.println("end doc mapper");
        return doc;
    }
    
    
    public static Doctor toDoctor(Document doctorDoc) {
		System.out.println(doctorDoc);

		Doctor doctor = new Doctor();
		
		doctor.setFullName(doctorDoc.getString("fullname"));
		
      doctor.setDob(doctorDoc.getString("dob"));
      doctor.setQualification(doctorDoc.getString("qualification"));
     doctor.setSpecialist( doctorDoc.getString("specialist"));
      doctor.setEmail(doctorDoc.getString("email"));
     doctor.setMob( doctorDoc.getString("mob"));
    doctor.setPassword(  doctorDoc.getString("password"));
	doctor.setId(((ObjectId) doctorDoc.get("_id")).toString());
		System.out.println("AFTER" + doctor);
		System.out.println("");
		System.out.println("");


		return doctor;
	}

    
    
    
    
//    public static Doctor toDoctor(Document doctorDoc) {
//        //String id = doctorDoc.getString("_id");
//        String fullName = doctorDoc.getString("fullname");
//        String dob = doctorDoc.getString("dob");
//        String qualification = doctorDoc.getString("qualification");
//        String specialist = doctorDoc.getString("specialist");
//        String email = doctorDoc.getString("email");
//        String mob = doctorDoc.getString("mob");
//        String password = doctorDoc.getString("password");
//        doctorDoc.se(((ObjectId) doctorDoc.get("_id")).toString());
//        Doctor doctor = new Doctor(id,fullName, dob, qualification, specialist, email, mob, password);
//        return doctor;
//    }
}
