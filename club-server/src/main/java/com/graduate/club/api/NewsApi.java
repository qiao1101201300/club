package com.graduate.club.api;

import com.graduate.club.entity.News;
import com.graduate.club.enums.ResultEnum;
import com.graduate.club.service.NewsService;
import com.graduate.club.util.ConfigHelper;
import com.graduate.club.util.Constants;
import com.graduate.club.util.ResultUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.NewsVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
@Api(value = "社团新闻", tags = "NewsApi")
@Slf4j
public class NewsApi {
    @Autowired
    private NewsService newsService;

    @PostMapping("selectNews")
    public ResultVO selectNews(@RequestBody NewsVO newsVO) {

        PageVO pageVO = newsService.selectNews(newsVO);
        return ResultUtils.success(pageVO);
    }

    @PostMapping("create")
    public ResultVO create(@RequestBody News news) {
        news.setStatus(Constants.Status.INIT);
        boolean b = newsService.insertSelective(news);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody News news) {
        if (StringUtils.isBlank(news.getId())) {
            return ResultUtils.error(ResultEnum.PARAM_ERROR.getCode(), "id不能为空");
        }
        boolean b = newsService.updateByPrimaryKey(news);
        return b ? ResultUtils.success() : ResultUtils.error(ResultEnum.ERROR);
    }

}
