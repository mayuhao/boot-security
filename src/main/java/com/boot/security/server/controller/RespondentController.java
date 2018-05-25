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
import com.boot.security.server.dao.RespondentDao;
import com.boot.security.server.model.Respondent;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/respondents")
public class RespondentController {

    @Autowired
    private RespondentDao respondentDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Respondent save(@RequestBody Respondent respondent) {
        respondentDao.save(respondent);

        return respondent;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Respondent get(@PathVariable Long id) {
        return respondentDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Respondent update(@RequestBody Respondent respondent) {
        respondentDao.update(respondent);

        return respondent;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return respondentDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Respondent> list(PageTableRequest request) {
                return respondentDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        respondentDao.delete(id);
    }
}
