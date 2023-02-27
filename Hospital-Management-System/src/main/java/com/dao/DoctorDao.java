package com.dao;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.entity.Doctor;
//
//public class DoctorDao {
//	private Connection conn;
//
//	public DoctorDao(Connection conn) {
//		super();
//		this.conn = conn;
//	}
//
//	public boolean registerDoctor(Doctor d) {
//		boolean f = false;
//
//		try {
//			String sql = "insert into doctor(fullname, dob, qualification, specialist, email, mob, password) values(?,?,?,?,?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, d.getFullName());
//			ps.setString(2, d.getDob());
//			ps.setString(3, d.getQualification());
//			ps.setString(4, d.getSpecialist());
//			ps.setString(5, d.getEmail());
//			ps.setString(6, d.getMob());
//			ps.setString(7, d.getPassword());
//
//			int i = ps.executeUpdate();
//			if (i == 1) {
//				f = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//	public List<Doctor> getAllDoctor() {
//		List<Doctor> list = new ArrayList<>();
//		Doctor d = null;
//		try {
//
//			String sql = "select * from doctor order by id desc";
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				d = new Doctor();
//				d.setId(rs.getInt(1));
//				d.setFullName(rs.getString(2));
//				d.setDob(rs.getString(3));
//				d.setQualification(rs.getString(4));
//				d.setSpecialist(rs.getString(5));
//				d.setEmail(rs.getString(6));
//				d.setMob(rs.getString(7));
//				d.setPassword(rs.getString(8));
//				list.add(d);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public Doctor getDoctorById(int id) {
//
//		Doctor d = null;
//		try {
//
//			String sql = "select * from doctor where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				d = new Doctor();
//				d.setId(rs.getInt(1));
//				d.setFullName(rs.getString(2));
//				d.setDob(rs.getString(3));
//				d.setQualification(rs.getString(4));
//				d.setSpecialist(rs.getString(5));
//				d.setEmail(rs.getString(6));
//				d.setMob(rs.getString(7));
//				d.setPassword(rs.getString(8));
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return d;
//	}
//
//	public boolean updateDoctor(Doctor d) {
//		boolean f = false;
//
//		try {
//			String sql = "update doctor set fullname=?,dob=?,qualification=?,specialist=?,email=?,mob=?,password=? where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, d.getFullName());
//			ps.setString(2, d.getDob());
//			ps.setString(3, d.getQualification());
//			ps.setString(4, d.getSpecialist());
//			ps.setString(5, d.getEmail());
//			ps.setString(6, d.getMob());
//			ps.setString(7, d.getPassword());
//			ps.setInt(8, d.getId());
//			int i = ps.executeUpdate();
//
//			if (i == 1) {
//				f = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//	public boolean deleteDoctor(int id) {
//		boolean f = false;
//		try {
//			String sql = "delete from doctor where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//
//			int i = ps.executeUpdate();
//			if (i == 1) {
//				f = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//	public Doctor login(String email, String psw) {
//		Doctor d = null;
//		try {
//
//			String sql = "select * from doctor where email=? and password=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			ps.setString(2, psw);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				d = new Doctor();
//				d = new Doctor();
//				d.setId(rs.getInt(1));
//				d.setFullName(rs.getString(2));
//				d.setDob(rs.getString(3));
//				d.setQualification(rs.getString(4));
//				d.setSpecialist(rs.getString(5));
//				d.setEmail(rs.getString(6));
//				d.setMob(rs.getString(7));
//				d.setPassword(rs.getString(8));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return d;
//	}
//
//	public int countDoctor() {
//		int i = 0;
//		try {
//			String sql = "select * from doctor";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				i++;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return i;
//	}
//
////	public int countAppointment() {
////		int i = 0;
////		try {
////			String sql = "select * from appointment";
////			PreparedStatement ps = conn.prepareStatement(sql);
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				i++;
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return i;
////	}
////
////	public int countAppointmentByDocotrId(int did) {
////		int i = 0;
////		try {
////			String sql = "select * from appointment where doctor_id=?";
////			PreparedStatement ps = conn.prepareStatement(sql);
////			ps.setInt(1, did);
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				i++;
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return i;
////	}
////
////	public int countUSer() {
////		int i = 0;
////		try {
////			String sql = "select * from user_dtls";
////			PreparedStatement ps = conn.prepareStatement(sql);
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				i++;
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return i;
////	}
//
//	public int countSpecialist() {
//		int i = 0;
//		try {
//			String sql = "select * from specialist";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				i++;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return i;
//	}
//
//	public boolean checkOldPassword(int userid, String oldPassword) {
//		boolean f = false;
//
//		try {
//			String sql = "select * from doctor where id=? and password=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, userid);
//			ps.setString(2, oldPassword);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				f = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//	public boolean changePassword(int userid, String newPassword) {
//		boolean f = false;
//
//		try {
//			String sql = "update doctor set password=? where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, newPassword);
//			ps.setInt(2, userid);
//
//			int i = ps.executeUpdate();
//			if (i == 1) {
//				f = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//	public boolean editDoctorProfile(Doctor d) {
//		boolean f = false;
//
//		try {
//			String sql = "update doctor set fullname=?, dob=?, qualification=?, specialist=?, email=?, mob=? where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, d.getFullName());
//			ps.setString(2, d.getDob());
//			ps.setString(3, d.getQualification());
//			ps.setString(4, d.getSpecialist());
//			ps.setString(5, d.getEmail());
//			ps.setString(6, d.getMob());
//			ps.setInt(7, d.getId());
//			int i = ps.executeUpdate();
//
//			if (i == 1) {
//				f = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//
//}






import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.convertor.DoctorConvertor;
import com.entity.Doctor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;



public class DoctorDao {

	private MongoCollection<Document> mongoCollectionUsers;

	public DoctorDao(MongoClient mongo) {
		this.mongoCollectionUsers = mongo.getDatabase("hospital").getCollection("doctors");
	}
	
	public Doctor create(Doctor doctor) {
        Document userDoc = DoctorConvertor.toDocument(doctor);
        this.mongoCollectionUsers.insertOne(userDoc);
        ObjectId id = (ObjectId) userDoc.get("_id");
        doctor.setId(id.toString());
        return doctor;
    }
 
    public void update(Doctor doctor) {
        this.mongoCollectionUsers.updateOne(Filters.eq("_id", new ObjectId(doctor.getId())), new Document("$set", DoctorConvertor.toDocument(doctor)));
        System.out.println("Inside Update Method");
        
    }
    
    public void delete(String id) {
        this.mongoCollectionUsers.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
    
    public void deleteDoc(String id) {
        this.mongoCollectionUsers.deleteOne(Filters.eq("fullname", id));
    }
 
    public boolean exists(String id) {
        FindIterable<Document>  doc = this.mongoCollectionUsers.find(Filters.eq("_id", id)).limit(1);
        return doc != null;
    }
 
    public List<Doctor> getList() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        MongoCursor<Document>  cursor = mongoCollectionUsers.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Doctor doctor = DoctorConvertor.toDoctor(doc);
                doctors.add(doctor);
            }
        } finally {
            cursor.close();
        }
        return doctors;
    }
 
    public Doctor getDoctor(String id) {
    	System.out.println("Ater Coming into Methof");
        Document doc = this.mongoCollectionUsers.find(Filters.eq("_id", new ObjectId(id))).first();
        System.out.println("Exiting from Method");
        return DoctorConvertor.toDoctor(doc);
       
    }
    
    
    public Doctor login(String email, String password) {
        Document doc = this.mongoCollectionUsers.find(Filters.and(Filters.eq("email", email), Filters.eq("password", password)))
                .first();
        if (doc != null) {
            return DoctorConvertor.toDoctor(doc);
        } else {
            return null;
        }

}
    
    
    public Doctor getDoctorDataByName(String name) {
    	System.out.println("Calling mong");
        MongoCollection<Document> collection = this.mongoCollectionUsers;
        Document query = new Document("fullName", name);
        FindIterable<Document> result = collection.find(query);
        if (result.iterator().hasNext()) {
            Document doctorDoc = result.iterator().next();
            Doctor doc =new Doctor(doctorDoc.getString("fullName"), doctorDoc.getString("specialization"), doctorDoc.getString("email"), doctorDoc.getString("phone"));
            System.out.println("Inside get Doc method --"+ doc.getFullName());
            return doc;
            
           
        } else {
            return null;
        }
    }
    
    public boolean checkOldPassword(String doctorName, String oldPassword) {
        Document doc = this.mongoCollectionUsers.find(Filters.eq("fullName", doctorName)).first();
        if (doc != null) {
            String password = doc.getString("password");
            return password.equals(oldPassword);
        } else {
            return false;
        }
    }


    
    public void updatePassword(String doctorName, String newPassword) {
        Document query = new Document("fullName", doctorName);
        Document update = new Document("$set", new Document("password", newPassword));
        this.mongoCollectionUsers.updateOne(query, update);
    }

}
