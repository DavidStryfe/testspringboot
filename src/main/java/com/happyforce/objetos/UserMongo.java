package com.happyforce.objetos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserMongo {

    @Id
    public ObjectId _id;

    private String name;
    private String password;

    public UserMongo(ObjectId _id, String name, String password) {
        this._id = _id;
        this.name = name;
        this.password = password;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserMongo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
