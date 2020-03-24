package team1.spring.training;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="Files")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id", nullable = false) long id;
    //location,timestamp,filename,
    @Column(name="location")
    private String location;
    @Column(name="timestamp")
    private String timestamp;
    @Column(name="name")
    private String name;

    public File(){ }

    public File(String location, String timestamp, String name) {
        this.location = location;
        this.timestamp = timestamp;
        this.name = name;
    }

    public long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(id, file.id) &&
                Objects.equals(name, file.name) &&
                Objects.equals(location, file.location) &&
                Objects.equals(timestamp, file.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, timestamp, location);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("File{");
        sb.append("id=").append(id);
        sb.append(", fileName='").append(name).append('\'');
        sb.append(", timeStamp='").append(timestamp).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}