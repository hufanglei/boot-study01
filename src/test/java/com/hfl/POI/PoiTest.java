package com.hfl.POI;

import com.hfl.dto.WebDto;
import com.hfl.tools.ExcelUtil;
import com.hfl.tools.POIword;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Test
    public void testRead() throws Exception {
        //Excel文件
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));
        //Excel工作表
        HSSFSheet sheet = wb.getSheetAt(0);
        //表头那一行
        HSSFRow titleRow = sheet.getRow(0);
        //表头那个单元格
        HSSFCell titleCell = titleRow.getCell(0);
        String title = titleCell.getStringCellValue();
        System.out.println("标题是："+title);
    }

    //读取到列表
    @Test
    public void testReadList() throws Exception {
        List<WebDto> list = new ArrayList<WebDto>();

        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));

        HSSFSheet sheet = book.getSheetAt(0);

        for(int i=2; i<sheet.getLastRowNum()+1; i++) {
            HSSFRow row = sheet.getRow(i);
            String name = row.getCell(0).getStringCellValue(); //名称
            String url = row.getCell(1).getStringCellValue(); //url
            String username = row.getCell(2).getStringCellValue();
            String password = row.getCell(3).getStringCellValue();
            Integer readCount = (int) row.getCell(4).getNumericCellValue();

            list.add(new WebDto(name, url, username, password, readCount));
        }

        System.out.println("共有 " + list.size() + " 条数据：");
        for(WebDto wd : list) {
            System.out.println(wd);
        }
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

    @Test
    public void test() throws Exception {
        List<WebDto> list = new ArrayList<WebDto>();
        list.add(new WebDto("知识林", "http://www.zslin.com", "admin", "111111", 555));
        list.add(new WebDto("权限系统", "http://basic.zslin.com", "admin", "111111", 111));
        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333));

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "网站信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info-template.xls", new FileOutputStream("D:/temp/out.xls"),
                list, WebDto.class, true);
    }
}
