package uk.ac.tees.MAD.W9560777.coviddiary;

public class Register_data_user {
    String nametext, email_text, password;

    public Register_data_user(){}

    public Register_data_user(String nametext, String email_text, String password) {
        this.nametext = nametext;
        this.email_text = email_text;
        this.password = password;
    }


    public String getNametext() {
        return nametext;
    }

    public void setNametext(String nametext) {
        this.nametext = nametext;
    }

    public String getEmail_text() {
        return email_text;
    }

    public void setEmail_text(String email_text) {
        this.email_text = email_text;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
