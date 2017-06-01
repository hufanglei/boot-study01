package com.hfl.test.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Created by hfl on 2017-5-23.
 */
public class TitlePositionEditor extends PropertyEditorSupport {

    private String[] options = {"Left", "Center", "Right"};

    //①代表可选属性值的字符串标识数组
    public String[] getTags() { return options; }


    //②代表属性初始值的字符串
    public String getJavaInitializationString() { return "" + getValue(); }


    //③将内部属性值转换为对应的字符串表示形式，供属性编辑器显示之用
    public String getAsText(){
        int value = (Integer) getValue();
        return options[value];
    }

    //④将外部设置的字符串转换为内部属性的值
    public void setAsText(String s){
        for (int i = 0; i < options.length; i++){
            if (options[i].equals(s)){
                setValue(i);
                return;
            }
        }
    }

}
