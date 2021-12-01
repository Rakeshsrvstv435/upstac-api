package org.upgrad.upstac.governmentathority;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApproveUserRequest {

    Long userId;

    String status;
}
