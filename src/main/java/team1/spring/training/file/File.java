package team1.spring.training.file;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Files")
@Getter @Setter
@RequiredArgsConstructor
@NoArgsConstructor()
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id", nullable = false)  long id;
    //location,timestamp,filename,
    @NonNull private String location;
    @NonNull private String timestamp;
    @NonNull private String name;
}