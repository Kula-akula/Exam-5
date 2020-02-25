package main.models;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@XmlRootElement(name="request")

public class Log {
    private String name;
    private Integer birthDate;
    private String gender;
    private Date createdDate;
}
