package com.convertor;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.entity.Appointment;

public class AppointmentConvertor {
    public static Document toDocument(Appointment appt) {
    	System.out.println("APPT - " + appt.toString());
        Document doc = new Document(
//                        "userId", appt.getUserId())
                "fullName", appt.getFullName())
                .append("gender", appt.getGender())
                .append("age", appt.getAge())
                .append("appointmentDate", appt.getAppointmentDate())
                .append("email", appt.getEmail())
                .append("phone", appt.getPhone())
                .append("diseases", appt.getDiseases())
                .append("docName", appt.getDocName())   
                .append("address", appt.getAddress())
                .append("status", appt.getStatus()
                
                        );
        System.out.println("AFTER - ");
        return doc;
    }
    public static Appointment toAppointment(Document apptDoc) {
        Appointment appt = new Appointment();
        appt.setId(((ObjectId) apptDoc.get("_id")).toString());
        appt.setFullName(apptDoc.getString("fullName"));
        appt.setGender(apptDoc.getString("gender"));
        appt.setAge(apptDoc.getString("age"));
        appt.setAppointmentDate(apptDoc.getString("appointmentDate"));
        appt.setEmail(apptDoc.getString("email"));
        appt.setPhone(apptDoc.getString("phone"));
        appt.setDiseases(apptDoc.getString("diseases"));
        appt.setDocName(apptDoc.getString("docName"));
        appt.setAddress(apptDoc.getString("address"));
        appt.setStatus(apptDoc.getString("status"));
        System.out.println("Inside toAppointment Mapper" + appt.getFullName());
        return appt;
    }
}