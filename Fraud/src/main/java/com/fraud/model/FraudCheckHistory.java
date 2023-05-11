package com.fraud.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence",initialValue = 1, allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence")
    private Long id;
    private Long customerId;
    private Boolean fraudster;
    private Date CreatedAt;
}
