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
import com.boot.security.server.dao.FormResultDao;
import com.boot.security.server.model.FormResult;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/formResults")
public class FormResultController {

    @Autowired
    private FormResultDao formResultDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public FormResult save(@RequestBody FormResult formResult) {
        formResultDao.save(formResult);

        return formResult;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public FormResult get(@PathVariable Long id) {
        return formResultDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public FormResult update(@RequestBody FormResult formResult) {
        formResultDao.update(formResult);

        return formResult;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return formResultDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<FormResult> list(PageTableRequest request) {
                return formResultDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        formResultDao.delete(id);
    }
}
