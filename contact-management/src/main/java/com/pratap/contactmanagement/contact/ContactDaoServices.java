package com.pratap.contactmanagement.contact;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactDaoServices {

     List<Contact> contacts = new ArrayList<>();
    public ContactDaoServices(){
        contacts.add(new Contact("Pratap","Nishad",
                "pratap@test.com","9999999999"));
        contacts.add(new Contact("Ram","Singh",
                "ram@test.com","111111111"));
        contacts.add(new Contact("Sam","Sharma",
                "sam@test.com","2222222222"));
        contacts.add(new Contact("Neha","Jain",
                "neha@test.com","3333333333"));
        contacts.add(new Contact("Priya","Gupta",
                "priya@test.com","4444444444"));
        contacts.add(new Contact("Pawan","Kumar",
                "pawan@test.com","5555555555"));
    }

    public List<Contact> getContacts(){
        return contacts;
    }
    public  Contact addContact(Contact contact){
        contacts.add(contact);
        return contact;
    }



    public List<Contact> getContactByAnyWildcard(String query) {
        List<Contact> result = new ArrayList<>();
        for(Contact  contact : contacts){
            if( contact.getEmail().equalsIgnoreCase(query)||
                contact.getPhoneNumber().equalsIgnoreCase(query)||
                contact.getFirstName().equalsIgnoreCase(query)||
                contact.getLastName().equalsIgnoreCase(query)
            )
                result.add(contact);
        }
        return result;

    }
    public  List<Contact> getContactByEmail(String email){
        List<Contact> result = new ArrayList<>();
        for(Contact  contact : contacts){
            if(contact.getEmail().equalsIgnoreCase(email))
                result.add(contact);
        }
        return result;
    }

    public  List<Contact> getContactByPhone(String phone){
        List<Contact> result = new ArrayList<>();
        for(Contact  contact : contacts){
            if(contact.getPhoneNumber().equalsIgnoreCase(phone))
                result.add(contact);
        }
        return result;
    }

    public  List<Contact> getContactByFirstName(String firstName){
        List<Contact> result = new ArrayList<>();
        for(Contact  contact : contacts){
            if(contact.getFirstName().equalsIgnoreCase(firstName))
                result.add(contact);
        }
        return result;
    }

    public  List<Contact> getContactByLastName(String lastName){
        List<Contact> result = new ArrayList<>();
        for(Contact  contact : contacts){
            if(contact.getLastName().equalsIgnoreCase(lastName))
                result.add(contact);
        }
        return result;
    }

    public  Contact updateContactByEmail(Contact updatedContact){
        for(Contact  contact : contacts){
            if(contact.getEmail().equalsIgnoreCase(updatedContact.getEmail())) {
                contact.deepCopy(updatedContact);
                return updatedContact;
            }
        }
        return null;
    }

    public  Contact updateContactByPhone(Contact updatedContact){
        for(Contact  contact : contacts){
            if(contact.getPhoneNumber().equalsIgnoreCase(updatedContact.getPhoneNumber())) {
                contact.deepCopy(updatedContact);
                return updatedContact;
            }
        }
        return null;
    }

    public  Contact deleteByPhone(String mobile){
        int count = 0;
        Contact toReturn = null;
        for(Contact  contact : contacts){
            if(contact.getPhoneNumber().equalsIgnoreCase(mobile)){
                toReturn = contact;
                contacts.remove(count);
            }
            count++;
        }
        return toReturn;
    }

    public  Contact deleteByEmail(String email){
        int count = 0;
        Contact toReturn = null;
        for(Contact  contact : contacts){
            if(contact.getEmail().equalsIgnoreCase(email)){
                toReturn = contact;
                contacts.remove(count);
            }
            count++;
        }
        return toReturn;
    }

}
