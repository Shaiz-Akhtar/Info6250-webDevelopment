package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.convertor.AppointmentConvertor;
import com.entity.Appointment;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class AppointmentDao {
    private MongoCollection<Document> mongoCollectionUsers;
    public AppointmentDao(MongoClient mongo) {
        this.mongoCollectionUsers = mongo.getDatabase("hospitalManagementSystem").getCollection("appointments");
    }
    public Appointment create(Appointment appt) {
    	System.out.println("Inside apptDAO - " + appt.toString());
        Document apptDoc = AppointmentConvertor.toDocument(appt);
        this.mongoCollectionUsers.insertOne(apptDoc);
        ObjectId id = (ObjectId) apptDoc.get("_id");
        appt.setId(id.toString());
        System.out.println("ID - " + appt.getId());
        return appt;
    }
    public void update(Appointment appt) {
        Bson filter = Filters.eq("_id", new ObjectId(appt.getId()));
        Bson update = Updates.combine(
            Updates.set("status", "Checkup Completed")
//            Updates.set("comments", appt.getComments())
        );
        this.mongoCollectionUsers.updateOne(filter, update);
        System.out.println("Inside update" + appt.toString());
    }
    public void delete(String id) {
        this.mongoCollectionUsers.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
    
    
    public Appointment getAppointmentDataById(String id) {
        ObjectId objectId = null;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            // Handle the case where the string is not a valid ObjectID
            return null;
        }
        Bson filter = Filters.eq("_id", objectId);
        Document doc = this.mongoCollectionUsers.find(filter).first();
        if (doc == null) {
            // Handle the case where the specified ID does not exist in the collection
            return null;
        }
        Appointment appt = AppointmentConvertor.toAppointment(doc);
        System.out.println("Inside getAppointmentDataById" + appt.toString());
        return appt;
    }
    
   

    
    public List<Appointment> getList() {
        List<Appointment> appts = new ArrayList<Appointment>();
        MongoCursor<Document>  cursor = mongoCollectionUsers.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Appointment appt = AppointmentConvertor.toAppointment(doc);
                appts.add(appt);
            }
        } finally {
            cursor.close();
        }
        return appts;
    }
    
    
	public List<Appointment> getListByUsername(String fullName) {
        List<Appointment> apptList = getList();
        List<Appointment> appts = new ArrayList<>();
        for(Appointment app: apptList) {
        	System.out.println("PARAM - " + fullName);
        	System.out.println("LOOP - " + app.getFullName());
            if(app.getFullName().equals(fullName)) {
                appts.add(app);
            }
        }
        return appts;
    }
    
    
    public List<Appointment> getListByDoctorName(String docName) {
        List<Appointment> apptList = getList();
        List<Appointment> appts = new ArrayList<>();
        for(Appointment app: apptList) {
            if(app.getDocName().equals(docName)) {
                appts.add(app);
            }
        }
        return appts;
    }
}