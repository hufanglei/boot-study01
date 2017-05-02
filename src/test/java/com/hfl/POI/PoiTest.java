package com.hfl.POI;

import com.hfl.tools.POIword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hfl on 2017-5-2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiTest {

    @Test
    public void testExportWord2() throws Exception {
        String tmpFile = "D:/temp/template.doc";
        String expFile = "D:/temp/result.doc";
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "标题部份");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容测试使用POI导出到Word的内容测试使用POI导出到Word的内容测试使用POI导出到Word的内容测试使用POI导出到Word的内容测试使用POI导出到Word的内容！");
        datas.put("author", "胡方雷");
        datas.put("url", "http://www.baidu.com");

        POIword.build(ResourceUtils.getFile(tmpFile), datas, expFile);
    }
}
