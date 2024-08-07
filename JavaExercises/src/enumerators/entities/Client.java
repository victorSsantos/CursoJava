package enumerators.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat ("dd/MM/yyyy");
        return "Client: " + name + " (" + fmt.format(birthDate) + ") - " + email;
    }
}
