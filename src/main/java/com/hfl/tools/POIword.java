package com.hfl.tools;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.Map;

/**
 * Created by hfl on 2017-5-2.
 *  POI导出Word文件 工具类
 *
 */
public class POIword {


    /**
     *
     * exportFile：需要保存导出文件的路径
     * @param tmpFile  模板文件
     * @param contentMap 数据模型，包含具体数据的map对象
     * @param exportFile  需要保存导出文件的路径
     * @throws Exception
     *
     */
    public static  void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
        FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }

        //导出到文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        OutputStream outputStream = new FileOutputStream(exportFile);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.close();
    }

}
