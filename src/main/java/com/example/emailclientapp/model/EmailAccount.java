package com.example.emailclientapp.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();
        properties.put("incomingHost", "imap.poczta.onet.pl");
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtps.host", "smtp.poczta.onet.pl");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.poczta.onet.pl");
    }

    public String getAddress() {
        return address;
    }


    public String getPassword() {
        return password;
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return address;
    }
}
