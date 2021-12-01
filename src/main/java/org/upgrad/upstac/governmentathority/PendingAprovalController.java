package org.upgrad.upstac.governmentathority;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/government")
public class PendingAprovalController {

    @Autowired
    private UserService userService;

    @GetMapping("/pending-approvals")
    @PreAuthorize("hasAnyRole('GOVERNMENT_AUTHORITY')")
    List<PendingUserDetails> getAllApprovalPendingUser(){


        List<User> userList = userService.findPendingApprovals();

        List<PendingUserDetails> pendingUserDetails = new ArrayList<>();

        for (User user : userList) {
                pendingUserDetails.add(PendingUserDetails.builder().user(user).build());
        }

        return pendingUserDetails;


    }

    @PutMapping("/update-approval")
    @PreAuthorize("hasAnyRole('GOVERNMENT_AUTHORITY')")
    void updateApprovalForUser(@RequestBody ApproveUserRequest user) {

            userService.findById(user.getUserId());


            Optional<User> actualUser = userService.findById(user.getUserId());

            actualUser.ifPresent(foundUser -> userService.updateStatusAndSave(foundUser,AccountStatus.APPROVED));

    }

}
