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
import com.boot.security.server.dao.FormDefinitionDao;
import com.boot.security.server.model.FormDefinition;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/formDefinitions")
public class FormDefinitionController {

    @Autowired
    private FormDefinitionDao formDefinitionDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public FormDefinition save(@RequestBody FormDefinition formDefinition) {
        formDefinitionDao.save(formDefinition);

        return formDefinition;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public FormDefinition get(@PathVariable Long id) {
        return formDefinitionDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public FormDefinition update(@RequestBody FormDefinition formDefinition) {
        formDefinitionDao.update(formDefinition);

        return formDefinition;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return formDefinitionDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<FormDefinition> list(PageTableRequest request) {
                return formDefinitionDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        formDefinitionDao.delete(id);
    }
}
