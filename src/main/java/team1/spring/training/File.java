package team1.spring.training;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="File_id")
    private Long id;

    //location,timestamp,filename,
    @Column(name="File_location")
    private String location;
    @Column(name="File_creation_time")
    private Date timestamp;
    @Column(name="File_name")
    private String filename;

    public File(String location, Date timestamp, String filename) {
        this.location = location;
        this.timestamp = timestamp;
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTimestamp() { return timestamp; }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}