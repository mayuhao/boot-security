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
import com.boot.security.server.dao.ElementDefinitionDao;
import com.boot.security.server.model.ElementDefinition;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/elementDefinitions")
public class ElementDefinitionController {

    @Autowired
    private ElementDefinitionDao elementDefinitionDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public ElementDefinition save(@RequestBody ElementDefinition elementDefinition) {
        elementDefinitionDao.save(elementDefinition);

        return elementDefinition;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public ElementDefinition get(@PathVariable Long id) {
        return elementDefinitionDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public ElementDefinition update(@RequestBody ElementDefinition elementDefinition) {
        elementDefinitionDao.update(elementDefinition);

        return elementDefinition;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return elementDefinitionDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<ElementDefinition> list(PageTableRequest request) {
                return elementDefinitionDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        elementDefinitionDao.delete(id);
    }
}
