package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.FormInstanceDao;
import com.boot.security.server.model.FormInstance;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/formInstances")
public class FormInstanceController {

    @Autowired
    private FormInstanceDao formInstanceDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public FormInstance save(@RequestBody FormInstance formInstance) {
        formInstanceDao.save(formInstance);

        return formInstance;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public FormInstance get(@PathVariable Long id) {
        return formInstanceDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public FormInstance update(@RequestBody FormInstance formInstance) {
        formInstanceDao.update(formInstance);

        return formInstance;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return formInstanceDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<FormInstance> list(PageTableRequest request) {
                return formInstanceDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        formInstanceDao.delete(id);
    }
}
