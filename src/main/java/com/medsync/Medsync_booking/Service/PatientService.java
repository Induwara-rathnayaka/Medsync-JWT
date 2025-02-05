package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Patient;
import com.medsync.Medsync_booking.Repository.PatientRepositery;

@Service
public class PatientService {

    @Autowired
    PatientRepositery Repo;

    public String creatPatient(Patient patient){

        Optional<Patient> searchPatient = Repo.findByEmail(patient.getEmail());

        //save user unique email 
        if(searchPatient.isPresent()){
           return "Alredy use this email";
        }else{
            Repo.save(patient);
            return "Registration sucsessfull";
        }  
    }

    public Patient getPatientById(String id){
        Optional<Patient> patient = Repo.findById(id); 
        return patient.orElse(null);
    }

    public  List<Patient> getAllPatient(){
        return Repo.findAll();
    }

    public Patient updatePatient(String id , Patient patient){
        if (Repo.existsById(id)) {
            patient.setNIC(id);
            return Repo.save(patient);
        }
        return null;
    }

    public String deletePatient(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Patient not found";
    }

    public Patient FindByEmail(String email) {
        Optional<Patient> patient = Repo.findByEmail(email);
        return patient.orElse(null);
    }

    public String loging(String email, String password){
        Optional<Patient> paitent = Repo.findByEmailAndPassword(email, password);

        if (paitent.isPresent()) {
            return "Login Sucsessfull";

        }else{
            return "Patient not found";
        }
    }
}