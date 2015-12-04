package com.dxj.xuer.mvc;

import com.dxj.xuer.common.IdForm;
import com.dxj.xuer.common.OperationLogType;
import com.dxj.xuer.common.Query;
import com.dxj.xuer.common.RemarkForm;
import com.dxj.xuer.domain.ArticleType;
import com.dxj.xuer.domain.OperationLog;
import com.dxj.xuer.service.ArticleTypeService;
import com.dxj.xuer.service.OperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-3
 * Time: ����10:22
 */
@Controller
@RequestMapping("/article/type")
public class ArticleTypeController extends CRUDController<ArticleType,ArticleTypeService,ArticleTypeController.Form,Query.NameQuery>{

    public ArticleTypeController() {
        super("article/type");
    }

    private final Logger log= LoggerFactory.getLogger(getClass());

    @Resource
    private OperationLogService operationLogService;

    @Resource
    public void setArticleTypeService(ArticleTypeService articleTypeService){
        this.service=articleTypeService;
    }

    @Override
    public void innerSave(ArticleTypeController.Form form, BindingResult errors, Model model, HttpServletRequest request, HttpServletResponse response) {
        ArticleType articleType = form.toObj();
        service.saveOrUpdate(articleType);
        operationLogService.save(OperationLog.valueOf(OperationLogType.ARTICLE_TYPE, String.format("%s�������[ID:%s, ����:%s]", articleType.getId() == null ? "����" : "�޸�", articleType.getId(), articleType.getName())));
    }

    public static class Form extends RemarkForm<ArticleType> {

        private String name;


        @Override
        public ArticleType newObj() {
            return new ArticleType();
        }

        @Override
        public void populateObj(ArticleType articleType) {
            articleType.setName(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
