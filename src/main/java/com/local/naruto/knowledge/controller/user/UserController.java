package com.local.naruto.knowledge.controller.user;

import com.local.naruto.common.JsonResult;
import com.local.naruto.knowledge.entity.ConditionModel;
import com.local.naruto.knowledge.entity.UserModel;
import com.local.naruto.knowledge.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User控制层
 *
 * @Author Naruto Chen
 * @Date 2022/02/08
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return JsonResult<UserModel>
     */
    @GetMapping(value = "/{id}")
    public JsonResult<UserModel> getUser(@PathVariable(value = "id") String id) {
        UserModel userModel = userService.getUserById(id);
        return new JsonResult<>(userModel);
    }

    /**
     * 批量删除用户信息
     *
     * @param ids id列表
     * @return JsonResult
     */
    @DeleteMapping
    public JsonResult<Integer> batchDeleteUser(@RequestBody List<String> ids) {
        return new JsonResult<>(userService.batchDeleteUser(ids));
    }

    /**
     * 批量插入用户信息
     *
     * @param list 用户信息列表
     * @return JsonResult
     */
    @PostMapping(value = "/batch")
    public JsonResult<Integer> batchAddUser(@RequestBody List<UserModel> list) {
        userService.batchAddUser(list);
        return new JsonResult<>(list.size());
    }

    /**
     * 批量更新用户信息
     *
     * @param list 用户信息列表
     * @return JsonResult
     */
    @PutMapping(value = "/batch")
    public JsonResult<Integer> batchUpdateUser(@RequestBody List<UserModel> list) {
        userService.batchUpdateUser(list);
        return new JsonResult<>(list.size());
    }

    /**
     * 查询所有用户信息
     *
     * @return JsonResult
     */
    @GetMapping(value = "/all")
    public JsonResult<List<UserModel>> getAllUser() {
        List<UserModel> all = userService.getAllUser();
        return new JsonResult<>(all, all.size());
    }

    /**
     * 多条件查询用户信息
     *
     * @param param 查询模型
     * @return JsonResult
     */
    @PostMapping(value = "/condition")
    public JsonResult<List<UserModel>> condition(@RequestBody ConditionModel param) {
        return userService.conditionalQuery(param);
    }
}
