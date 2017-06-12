package com.ejemplo.component;

import com.ejemplo.entity.Contact;
import com.ejemplo.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact converterContactModel2Contact(ContactModel contactModel){

        Contact contact = new Contact();

        contact.setCity(contactModel.getCity());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setId(contactModel.getId());
        contact.setTelephone(contactModel.getTelephone());

        return contact;
    }

    public ContactModel converterContac2ContactModel(Contact contact){

        ContactModel contactModel = new ContactModel();

        contactModel.setCity(contact.getCity());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setId(contact.getId());
        contactModel.setTelephone(contact.getTelephone());

        return contactModel;

    }

}
