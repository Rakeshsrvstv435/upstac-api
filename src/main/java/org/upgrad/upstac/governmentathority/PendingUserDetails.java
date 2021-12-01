package org.upgrad.upstac.governmentathority;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.upgrad.upstac.users.User;

import java.util.List;

@Getter
@Setter
@Builder
public class PendingUserDetails {


    String contentType = "application/json";

    String fieldName = "sample";

    String id = "1";

    User user;
}
