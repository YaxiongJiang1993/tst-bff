package com.tst.bff.client;

import com.tst.user.client.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "tst-user",
        contextId = "userClient")
public interface UserClient extends UserApi {
}
