package com.ejemplo.service;

import com.ejemplo.model.ContactModel;

import java.util.List;

/**
 * Created by EliteBook on 12-06-17.
 */
public interface ContactService {

    ContactModel addContact (ContactModel contactModel);

    List <ContactModel> showAllContacts ();

    void deleteContact(int id);

    ContactModel showOne (int id);



}
