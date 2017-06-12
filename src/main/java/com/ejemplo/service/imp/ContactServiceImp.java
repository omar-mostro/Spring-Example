package com.ejemplo.service.imp;

import com.ejemplo.component.ContactConverter;
import com.ejemplo.entity.Contact;
import com.ejemplo.model.ContactModel;
import com.ejemplo.repository.ContactRepository;
import com.ejemplo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImp")
public class ContactServiceImp implements ContactService{

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {


        Contact contac = contactRepository.save(contactConverter.converterContactModel2Contact(contactModel));
        return contactConverter.converterContac2ContactModel(contac);
    }

    @Override
    public List<ContactModel> showAllContacts() {

        List<Contact> contacts =  contactRepository.findAll();
        List<ContactModel> contactModels = new ArrayList<ContactModel>();

        for (Contact contact:contacts){

            contactModels.add(contactConverter.converterContac2ContactModel(contact));

        }

        return contactModels;
    }

    @Override
    public void deleteContact(int id) {

        contactRepository.delete(id);

    }

    @Override
    public ContactModel showOne(int id) {
        return contactConverter.converterContac2ContactModel(contactRepository.findOne(id));
    }
}
