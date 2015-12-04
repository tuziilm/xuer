package com.dxj.xuer.mvc;

import com.dxj.xuer.common.OperationLogType;
import com.dxj.xuer.common.Paginator;
import com.dxj.xuer.common.Query.NameQuery;
import com.dxj.xuer.common.RemarkForm;
import com.dxj.xuer.domain.Article;
import com.dxj.xuer.domain.OperationLog;
import com.dxj.xuer.service.ArticleService;
import com.dxj.xuer.service.ArticleTypeService;
import com.dxj.xuer.service.OperationLogService;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-3
 * Time: 上午10:22
 */
@Controller
@RequestMapping("/article/article")
public class ArticleController extends CRUDController<Article,ArticleService,ArticleController.Form,NameQuery>{

    public ArticleController() {
        super("article/article");
    }

    private final Logger log= LoggerFactory.getLogger(getClass());

    @Resource
    private OperationLogService operationLogService;

    @Resource
    private ArticleTypeService articleTypeService;

    @Resource
    public void setArticleService(ArticleService articleService){
        this.service=articleService;
    }

    @Override
    protected void postCreate(Model model) {
        model.addAttribute("types", articleTypeService.getAllArticleTypesCache());
    }

    @Override
    protected void postModify(int id, Article obj, Model model) {
        postCreate(model);
    }

    @Override
    protected void onSaveError(Form form, BindingResult errors, Model model, HttpServletRequest request, HttpServletResponse response) {
        postCreate(model);
    }

    @Override
    protected boolean preList(int page, Paginator paginator, NameQuery query, Model model) {
        model.addAttribute("typeMap", articleTypeService.getAllArticleTypesMapCache());
        return super.preList(page, paginator, query, model);
    }

    @Override
    public void innerSave(ArticleController.Form form, BindingResult errors, Model model, HttpServletRequest request, HttpServletResponse response) {
        Article article = form.toObj();
        service.saveOrUpdate(article);
        operationLogService.save(OperationLog.valueOf(OperationLogType.ARTICLE, String.format("%s文章[ID:%s, 名称:%s]", article.getId() == null ? "新增" : "修改", article.getId(), article.getTitle())));
    }

    public static class Form extends RemarkForm<Article> {
        @NotBlank(message = "标题不能为空")
        private String title;
        @NotBlank(message = "内容不能为空")
        private String content;
        private Integer type;
        private Integer readCount;

        @Override
        public Article newObj() {
            return new Article();
        }

        @Override
        public void populateObj(Article article) {
            article.setTitle(title);
            article.setContent(content);
            article.setType(type);
            article.setReadCount(readCount);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getReadCount() {
            return readCount;
        }

        public void setReadCount(Integer readCount) {
            this.readCount = readCount;
        }
    }
}
