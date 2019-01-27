import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class TestTemplate {
    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testAdd() {
        TbItem item = new TbItem();
        item.setId(2L);
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(1L);
        item.setSeller("华为 2 号专卖店");
        item.setTitle("华为 Mate9");
        item.setPrice(new BigDecimal(2000));
        solrTemplate.saveBean(item);
        solrTemplate.commit();
    }

    @Test
    public void testFindOne() {
        TbItem item = solrTemplate.getById(1, TbItem.class);
        System.out.println(item.getTitle());
    }

    @Test
    public void testDelete() {
        solrTemplate.deleteById("2");
        solrTemplate.commit();
    }

    @Test
    public void testAddList() {
        List<TbItem> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            TbItem item = new TbItem();
            item.setId(i + 1L);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为 2 号专卖店");
            item.setTitle("华为 Mate" + i);
            item.setPrice(new BigDecimal(2000 + i));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }


    // 分页查询
    @Test
    public void testPageQuery() {
        Query query = new SimpleQuery("*:*");// 设置查询所有字段的所有值      id:2 : 查询id为2的数据

        query.setOffset(0);//起始位置
        query.setRows(20);//每页显示记录数


        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);// 分页查询

        // getTotalElements : 获取总记录数
        System.out.println("总记录数：" + page.getTotalElements());

        // getContent : 获取分页查询的内容
        List<TbItem> list = page.getContent();

        // getTotalPages : 获取总页数
        System.out.println("总页数：" + page.getTotalPages());

        showList(list);
    }

    // 显示记录数据
    private void showList(List<TbItem> list) {
        for (TbItem item : list) {
            System.out.println(item.getTitle() + "    " + item.getPrice());
        }
    }
    // 条件查询
    @Test
    public void testPageQueryMutil() {
        Query query = new SimpleQuery("*:*");

        //类似于  sql  where item_category like 手机 and item_title like 2
        Criteria criteria = new Criteria("item_category").contains("手机");// 设置查询条件，类别包含手机的数据
        criteria = criteria.and("item_title").contains("2");// 追加查询条件，title中包含2的
        query.addCriteria(criteria);// 添加查询条件

        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数：" + page.getTotalElements());
        List<TbItem> list = page.getContent();
        showList(list);
    }
    //全部删除
    @Test
    public void testDeleteAll() {
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete(query);//根据query查询的数据进行删除操作
        solrTemplate.commit();
    }


}
