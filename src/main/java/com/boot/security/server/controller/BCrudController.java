package com.boot.security.server.controller;

import java.util.List;

import com.boot.security.server.annotation.LogAnnotation;
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
import com.boot.security.server.dao.BCrudDao;
import com.boot.security.server.model.BCrud;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bCruds")
public class BCrudController {

    @Autowired
    private BCrudDao bCrudDao;

    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存")
    public BCrud save(@RequestBody BCrud bCrud) {
        bCrudDao.save(bCrud);

        return bCrud;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public BCrud get(@PathVariable Long id) {
        return bCrudDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public BCrud update(@RequestBody BCrud bCrud) {
        bCrudDao.update(bCrud);

        return bCrud;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return bCrudDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<BCrud> list(PageTableRequest request) {
                return bCrudDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        bCrudDao.delete(id);
    }
}
