package main.models;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@XmlRootElement(name="log")
public class Request {
    private int id;
    private String name;
    private Integer birthDate;
    private String gender;

}
